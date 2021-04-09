package divinerpg.util.datagen;

import com.google.gson.*;
import divinerpg.*;
import divinerpg.blocks.base.*;
import divinerpg.blocks.twilight.*;
import divinerpg.registries.*;
import net.minecraft.advancements.criterion.*;
import net.minecraft.block.*;
import net.minecraft.data.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.*;
import net.minecraft.loot.functions.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.*;
import net.minecraftforge.registries.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.*;

@SuppressWarnings("NullableProblems")
public class GenerateBlockLoot implements IDataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final DataGenerator generator;
    private final Map<Block, Function<Block, LootTable.Builder>> functionTable = new HashMap<>();

    public GenerateBlockLoot(DataGenerator generator) {
        this.generator = generator;
    }


    @Override
    public void run(DirectoryCache cache) throws IOException {
        Map<ResourceLocation, LootTable.Builder> tables = new HashMap<>();

        for (Block block : ForgeRegistries.BLOCKS) {
            if (!DivineRPG.MODID.equals(block.getRegistryName().getNamespace())) {
                continue;
            }
            //Use runData to generate
            if (block.getRegistryName().getPath().contains("_glass")) {
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genSilk);
                tables.put(block.getRegistryName(), func.apply(block));
            } else if (block.getRegistryName().getPath().contains("_vine") || block instanceof BlockTwilightGrass){
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genSilkShears);
                tables.put(block.getRegistryName(), func.apply(block));
            } else if (block == BlockRegistry.edenOre || block == BlockRegistry.wildwoodOre || block == BlockRegistry.apalachiaOre || block == BlockRegistry.skythernOre || block == BlockRegistry.mortumOre){
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genTwilightOre);
                tables.put(block.getRegistryName(), func.apply(block));
            } else if (block instanceof BlockModSlab){
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genSlab);
                tables.put(block.getRegistryName(), func.apply(block));
            } else if (block.getRegistryName().getPath().contains("_leaves")){
            }else if(block instanceof BlockModCrop || block instanceof BlockModGrass){

            }else
                if(!block.getRegistryName().toString().contains("_wall")){
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genRegular);
                tables.put(block.getRegistryName(), func.apply(block));
            }
        }

        for (Map.Entry<ResourceLocation, LootTable.Builder> e : tables.entrySet()) {
            Path path = getPath(generator.getOutputFolder(), e.getKey());
            IDataProvider.save(GSON, cache, LootTableManager.serialize(e.getValue().setParamSet(LootParameterSets.BLOCK).build()), path);
        }
    }

    @Override
    public String getName() {
        return "DivineRPG block loot tables";
    }

    private static Path getPath(Path root, ResourceLocation id) {
        return root.resolve("data/" + id.getNamespace() + "/loot_tables/blocks/" + id.getPath() + ".json");
    }

    private static LootTable.Builder genRegular(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantRange.exactly(1)).add(entry).when(SurvivesExplosion.survivesExplosion());
        return LootTable.lootTable().withPool(pool);
    }
    private static LootTable.Builder genSilk(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantRange.exactly(1)).add(entry).when(SurvivesExplosion.survivesExplosion()).when(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))));
        return LootTable.lootTable().withPool(pool);
    }
    private static LootTable.Builder genSilkShears(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantRange.exactly(1)).add(entry).when(SurvivesExplosion.survivesExplosion()).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)).or(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))));
        return LootTable.lootTable().withPool(pool);
    }
    private static LootTable.Builder genTwilightOre(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.lootTableItem(b);
        //Works but no dupe prevention at all. 
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantRange.exactly(1)).add(entry).apply(SetCount.setCount(ConstantRange.exactly(1))).apply(SetCount.setCount(ConstantRange.exactly(3)).when(EntityHasProperty.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().equipment(EntityEquipmentPredicate.Builder.equipment().head(ItemPredicate.Builder.item().of(ItemRegistry.edenHelmet).build()).chest(ItemPredicate.Builder.item().of(ItemRegistry.edenChestplate).build()).legs(ItemPredicate.Builder.item().of(ItemRegistry.edenLeggings).build()).feet(ItemPredicate.Builder.item().of(ItemRegistry.edenBoots).build()).build())))).when(SurvivesExplosion.survivesExplosion());
        return LootTable.lootTable().withPool(pool);
    }
    private static LootTable.Builder genSlab(Block b) {
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantRange.exactly(1)).add(ItemLootEntry.lootTableItem(b).apply(SetCount.setCount(ConstantRange.exactly(2)).when(BlockStateProperty.hasBlockStateProperties(b).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))).when(SurvivesExplosion.survivesExplosion())).when(SurvivesExplosion.survivesExplosion());
        return LootTable.lootTable().withPool(pool);
    }
    private static LootTable.Builder genFortune(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantRange.exactly(1)).add(entry).when(SurvivesExplosion.survivesExplosion()).apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE));
        return LootTable.lootTable().withPool(pool);
    }


    //TODO - leaves, probably more

}