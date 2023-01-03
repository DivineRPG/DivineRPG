package divinerpg.data;

import com.google.gson.*;
import divinerpg.DivineRPG;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.entries.*;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@SuppressWarnings("NullableProblems")
public class GenerateBlockLoot implements DataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final DataGenerator generator;
    private final Map<Block, Function<Block, LootTable.Builder>> functionTable = new HashMap<>();

    public GenerateBlockLoot(DataGenerator generator) {
        this.generator = generator;
    }

    private static Path getPath(Path root, ResourceLocation id) {
        return root.resolve("data/" + id.getNamespace() + "/loot_tables/blocks/" + id.getPath() + ".json");
    }

    private static LootTable.Builder genRegular(Block b) {
        LootPoolEntryContainer.Builder<?> entry = LootItem.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantValue.exactly(1)).add(entry).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(pool);
    }

    private static LootTable.Builder genSilk(Block b) {
        LootPoolEntryContainer.Builder<?> entry = LootItem.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantValue.exactly(1)).add(entry).when(ExplosionCondition.survivesExplosion()).when(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))));
        return LootTable.lootTable().withPool(pool);
    }

    private static LootTable.Builder genSilkShears(Block b) {
        LootPoolEntryContainer.Builder<?> entry = LootItem.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantValue.exactly(1)).add(entry).when(ExplosionCondition.survivesExplosion()).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS)).or(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))));
        return LootTable.lootTable().withPool(pool);
    }

    private static LootTable.Builder genTwilightOre(Block b) {
        LootPoolEntryContainer.Builder<?> entry = LootItem.lootTableItem(b);
        //Works but no dupe prevention at all.
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantValue.exactly(1)).add(entry).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3)).when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().equipment(EntityEquipmentPredicate.Builder.equipment().head(ItemPredicate.Builder.item().of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_helmet"))).build()).chest(ItemPredicate.Builder.item().of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_chestplate"))).build()).legs(ItemPredicate.Builder.item().of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_leggings"))).build()).feet(ItemPredicate.Builder.item().of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_boots"))).build()).build())))).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(pool);
    }

    private static LootTable.Builder genSlab(Block b) {
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(b).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))).when(ExplosionCondition.survivesExplosion())).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(pool);
    }

    private static LootTable.Builder genFortune(Block b) {
        LootPoolEntryContainer.Builder<?> entry = LootItem.lootTableItem(b);
        LootPool.Builder pool = LootPool.lootPool().name("main").setRolls(ConstantValue.exactly(1)).add(entry).when(ExplosionCondition.survivesExplosion()).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE));
        return LootTable.lootTable().withPool(pool);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output) {
        return null;
    }

    @Override
    public String getName() {
        return "DivineRPG block loot tables";
    }

}