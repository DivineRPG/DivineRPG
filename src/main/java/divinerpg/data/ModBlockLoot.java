package divinerpg.data;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.DivineRegistries;
import divinerpg.registries.FluidRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ModBlockLoot extends BlockLootSubProvider {

    private static final Set<String> NO_LOOT_PATHS = Set.of(
            "arcana_portal_frame",
            "proximity_spawner",
            "terran_ghost_block",
            "smoldering_tar",
            "smoldering_tar_block"
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
        Map<Block, Item> oreDrops = Map.of(
                BlockRegistry.realmiteOreSet.getFirst().get(), ItemRegistry.raw_realmite.get(),
                BlockRegistry.realmiteOreSet.getLast().get(), ItemRegistry.raw_realmite.get(),
                BlockRegistry.arlemiteOreSet.getFirst().get(), ItemRegistry.raw_arlemite.get(),
                BlockRegistry.arlemiteOreSet.getLast().get(), ItemRegistry.raw_arlemite.get(),
                BlockRegistry.rupeeOreSet.getFirst().get(), ItemRegistry.raw_rupee.get(),
                BlockRegistry.rupeeOreSet.getLast().get(), ItemRegistry.raw_rupee.get()
        );

        Map<Block, Block> leavesToSapling = Map.of(
                BlockRegistry.divineWoodSet.get(2).get(), BlockRegistry.divineWoodSet.getFirst().get(),
                BlockRegistry.shiverspineWoodSet.get(2).get(), BlockRegistry.shiverspineWoodSet.getFirst().get(),
                BlockRegistry.auroraoakWoodSet.get(2).get(), BlockRegistry.auroraoakWoodSet.getFirst().get(),
                BlockRegistry.cozybarkWoodSet.get(2).get(), BlockRegistry.cozybarkWoodSet.getFirst().get(),
                BlockRegistry.streamleafWoodSet.get(2).get(), BlockRegistry.streamleafWoodSet.getFirst().get()
        );

        for (DeferredHolder<Block, ? extends Block> holder : DivineRegistries.BLOCKS.getEntries()) {
            Block block = holder.get();
            if (block.getLootTable().isEmpty()) {
                continue;
            }
            String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
            if (NO_LOOT_PATHS.contains(path) || block.defaultDestroyTime() < 0.0F) {
                add(block, LootTable.lootTable());
                continue;
            }
            Item oreDrop = oreDrops.get(block);
            if (oreDrop != null) {
                add(block, createOreDrop(block, oreDrop));
                continue;
            }
            Block sapling = leavesToSapling.get(block);
            if (sapling != null) {
                add(block, createLeavesDrops(block, sapling, NORMAL_LEAVES_SAPLING_CHANCES));
                continue;
            }
            if (block.asItem() == Items.AIR) {
                add(block, LootTable.lootTable());
                continue;
            }
            dropSelf(block);
        }
    }
}