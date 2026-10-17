package divinerpg.data;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.DivineRegistries;
import divinerpg.registries.FluidRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class ModBlockLoot extends BlockLootSubProvider {

    private static final Set<Supplier<? extends Block>> NO_LOOT_BLOCKS = Set.of(
            BlockRegistry.arcanaPortalFrame,
            BlockRegistry.proximitySpawner,
            BlockRegistry.terranGhostBlock,
            FluidRegistry.SMOLDERING_TAR_BLOCK
    );

    private static final Map<Block, Item> ORE_DROPS = Map.of(
            BlockRegistry.realmiteOre.get(), ItemRegistry.raw_realmite.get(),
            BlockRegistry.realmiteOreDeepslate.get(), ItemRegistry.raw_realmite.get(),
            BlockRegistry.arlemiteOre.get(), ItemRegistry.raw_arlemite.get(),
            BlockRegistry.arlemiteOreDeepslate.get(), ItemRegistry.raw_arlemite.get(),
            BlockRegistry.rupeeOre.get(), ItemRegistry.raw_rupee.get(),
            BlockRegistry.rupeeOreDeepslate.get(), ItemRegistry.raw_rupee.get()
    );

    private static final Map<Block, Block> LEAVES_TO_SAPLING = Map.of(
            BlockRegistry.divineLeaves.get(), BlockRegistry.divineSapling.get(),
            BlockRegistry.brittleLeaves.get(), BlockRegistry.shiverspineSapling.get(),
            BlockRegistry.auroraoakLeaves.get(), BlockRegistry.auroraoakSapling.get(),
            BlockRegistry.cozybarkLeaves.get(), BlockRegistry.cozybarkSapling.get(),
            BlockRegistry.streamleafLeaves.get(), BlockRegistry.streamleafSapling.get()
    );

    public ModBlockLoot(LootTableSubProvider.Context context) {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags(), context);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DivineRegistries.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get()).toList();
    }

    @Override
    protected void generate() {
        for (DeferredHolder<Block, ? extends Block> holder : DivineRegistries.BLOCKS.getEntries()) {
            Block block = holder.get();
            if (isNoLootBlock(block)) {
                add(block, LootTable.lootTable());
                continue;
            }
            Item oreDrop = ORE_DROPS.get(block);
            if (oreDrop != null) {
                add(block, createOreDrop(block, oreDrop));
                continue;
            }
            Block sapling = LEAVES_TO_SAPLING.get(block);
            if (sapling != null) {
                add(block, createLeavesDrops(block, sapling, NORMAL_LEAVES_SAPLING_CHANCES));
                continue;
            }
            dropSelf(block);
        }
    }

    private boolean isNoLootBlock(Block block) {
        return NO_LOOT_BLOCKS.stream().anyMatch(supplier -> supplier.get() == block);
    }
}