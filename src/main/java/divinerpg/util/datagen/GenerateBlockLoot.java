package divinerpg.util.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.datafixers.kinds.Const;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModSlab;
import divinerpg.registries.*;
import net.minecraft.advancements.criterion.*;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.*;
import net.minecraft.loot.functions.*;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("NullableProblems")
public class GenerateBlockLoot implements IDataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final DataGenerator generator;
    private final Map<Block, Function<Block, LootTable.Builder>> functionTable = new HashMap<>();

    public GenerateBlockLoot(DataGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void act(DirectoryCache cache) throws IOException {
        Map<ResourceLocation, LootTable.Builder> tables = new HashMap<>();

        for (Block block : ForgeRegistries.BLOCKS) {
            if (!DivineRPG.MODID.equals(block.getRegistryName().getNamespace())) {
                continue;
            }
            //Use runData to generate
            if (block.getRegistryName().getPath().contains("_glass")) {
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genSilk);
                tables.put(block.getRegistryName(), func.apply(block));
            } else if (block.getRegistryName().getPath().contains("_vine")){
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genSilkShears);
                tables.put(block.getRegistryName(), func.apply(block));
            } else if (block == BlockRegistry.edenOre || block == BlockRegistry.wildwoodOre || block == BlockRegistry.apalachiaOre || block == BlockRegistry.skythernOre || block == BlockRegistry.mortumOre){
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genTwilightOre);
                tables.put(block.getRegistryName(), func.apply(block));
            } else if (block instanceof BlockModSlab){
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genSlab);
                tables.put(block.getRegistryName(), func.apply(block));
            }else{
                Function<Block, LootTable.Builder> func = functionTable.getOrDefault(block, GenerateBlockLoot::genRegular);
                tables.put(block.getRegistryName(), func.apply(block));
            }
        }

        for (Map.Entry<ResourceLocation, LootTable.Builder> e : tables.entrySet()) {
            Path path = getPath(generator.getOutputFolder(), e.getKey());
            IDataProvider.save(GSON, cache, LootTableManager.toJson(e.getValue().setParameterSet(LootParameterSets.BLOCK).build()), path);
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
        LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry).acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(pool);
    }
    private static LootTable.Builder genSilk(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry).acceptCondition(SurvivesExplosion.builder()).acceptCondition(MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))));
        return LootTable.builder().addLootPool(pool);
    }
    private static LootTable.Builder genSilkShears(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry).acceptCondition(SurvivesExplosion.builder()).acceptCondition(MatchTool.builder(ItemPredicate.Builder.create().item(Items.SHEARS)).alternative(MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))));
        return LootTable.builder().addLootPool(pool);
    }
    private static LootTable.Builder genTwilightOre(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
        //Works but no dupe prevention at all. 
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry).acceptFunction(SetCount.builder(ConstantRange.of(1))).acceptFunction(SetCount.builder(ConstantRange.of(3)).acceptCondition(EntityHasProperty.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().equipment(EntityEquipmentPredicate.Builder.createBuilder().setHeadCondition(ItemPredicate.Builder.create().item(ItemRegistry.edenHelmet).build()).setChestCondition(ItemPredicate.Builder.create().item(ItemRegistry.edenChestplate).build()).setLegsCondition(ItemPredicate.Builder.create().item(ItemRegistry.edenLeggings).build()).setFeetCondition(ItemPredicate.Builder.create().item(ItemRegistry.edenBoots).build()).build())))).acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(pool);
    }
    private static LootTable.Builder genSlab(Block b) {
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(b).acceptFunction(SetCount.builder(ConstantRange.of(2)).acceptCondition(BlockStateProperty.builder(b).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(SlabBlock.TYPE, SlabType.DOUBLE)))).acceptCondition(SurvivesExplosion.builder())).acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(pool);
    }
    private static LootTable.Builder genFortune(Block b) {
        LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry).acceptCondition(SurvivesExplosion.builder()).acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE));
        return LootTable.builder().addLootPool(pool);
    }


    //TODO - leaves, probably more

}