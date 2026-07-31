package divinerpg.data;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.DivineRegistries;
import divinerpg.registries.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLoot extends BlockLootSubProvider {

    private static final Set<Block> NO_LOOT_BLOCKS = Set.of(
            BlockRegistry.arcanaPortalFrame.get(),
            BlockRegistry.proximitySpawner.get(),
            BlockRegistry.terranGhostBlock.get()
    );

    private static final Map<Block, Item> ORE_DROPS = Map.of(
            BlockRegistry.realmiteOre.get(), ItemRegistry.raw_realmite.get(),
            BlockRegistry.realmiteOreDeepslate.get(), ItemRegistry.raw_realmite.get(),
            BlockRegistry.arlemiteOre.get(), ItemRegistry.raw_arlemite.get(),
            BlockRegistry.arlemiteOreDeepslate.get(), ItemRegistry.raw_arlemite.get(),
            BlockRegistry.rupeeOre.get(), ItemRegistry.raw_rupee.get(),
            BlockRegistry.rupeeOreDeepslate.get(), ItemRegistry.raw_rupee.get()
    );

    private static final Map<Block, Block> LEAF_TO_SAPLING = Map.of(
            BlockRegistry.divineLeaves.get(), BlockRegistry.divineSapling.get(),
            BlockRegistry.brittleLeaves.get(), BlockRegistry.shiverspineSapling.get(),
            BlockRegistry.auroraoakLeaves.get(), BlockRegistry.auroraoakSapling.get(),
            BlockRegistry.cozybarkLeaves.get(), BlockRegistry.cozybarkSapling.get(),
            BlockRegistry.streamleafLeaves.get(), BlockRegistry.streamleafSapling.get()
    );

    protected ModBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        for (DeferredHolder<Block, ? extends Block> holder : DivineRegistries.BLOCKS.getEntries()) {
            Block block = holder.get();
            if (NO_LOOT_BLOCKS.contains(block)) {
                continue;
            } else if (ORE_DROPS.containsKey(block)) {
                Item drop = ORE_DROPS.get(block);
                if (drop == net.minecraft.world.item.Items.AIR) {
                    throw new IllegalStateException("Drop for block " + block + " is AIR!");
                }
                this.add(block, (b) -> createOreDrop(b, drop));
            } else if (LEAF_TO_SAPLING.containsKey(block)) {
                Block sapling = LEAF_TO_SAPLING.get(block);
                if (sapling == null) {
                    throw new IllegalStateException("Sapling for leaf " + block + " is null!");
                }
                this.add(block, (b) -> createLeavesDrops(b, sapling, NORMAL_LEAVES_SAPLING_CHANCES));
            } else {
                this.dropSelf(block);
            }
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return DivineRegistries.BLOCKS.getEntries().stream()
                .map(DeferredHolder::get)
                .filter(block -> !NO_LOOT_BLOCKS.contains(block))
                .collect(Collectors.toList());
    }
}