package divinerpg.data;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.DivineRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.TagRegistry.MINEABLE_SHICKAXE;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(commonTag("ores/arlemite")).add(BlockRegistry.arlemiteOre.getKey(), BlockRegistry.arlemiteOreDeepslate.getKey());
        tag(commonTag("ores/rupee")).add(BlockRegistry.rupeeOre.getKey(), BlockRegistry.rupeeOreDeepslate.getKey());
        tag(commonTag("ores/realmite")).add(BlockRegistry.realmiteOre.getKey(), BlockRegistry.realmiteOreDeepslate.getKey());
        tag(commonTag("ores/torridite")).add(BlockRegistry.torriditeOre.getKey());
        tag(commonTag("ores/bloodgem")).add(BlockRegistry.bloodgemOre.getKey());
        tag(commonTag("ores")).addTags(commonTag("ores/arlemite"), commonTag("ores/rupee"), commonTag("ores/realmite"), commonTag("ores/torridite"), commonTag("ores/bloodgem"));

        tag(commonTag("storage_blocks/realmite")).add(BlockRegistry.realmiteBlock.getKey());
        tag(commonTag("storage_blocks/arlemite")).add(BlockRegistry.arlemiteBlock.getKey());
        tag(commonTag("storage_blocks/rupee")).add(BlockRegistry.rupeeBlock.getKey());
        tag(commonTag("storage_blocks/bloodgem")).add(BlockRegistry.bloodgemBlock.getKey());
        tag(commonTag("storage_blocks/torridite")).add(BlockRegistry.torriditeBlock.getKey());
        tag(commonTag("storage_blocks/olivine")).add(BlockRegistry.olivineBlock.getKey());
        tag(commonTag("storage_blocks")).addTags(commonTag("storage_blocks/realmite"), commonTag("storage_blocks/arlemite"), commonTag("storage_blocks/rupee"), commonTag("storage_blocks/bloodgem"), commonTag("storage_blocks/torridite"), commonTag("storage_blocks/olivine"));

        tag(commonTag("stones/frozen")).add(BlockRegistry.frozenStone.getKey());
        tag(commonTag("stones/cobaltite")).add(BlockRegistry.cobaltite.getKey());
        tag(commonTag("stones/coalstone")).add(BlockRegistry.coalstone.getKey());
        tag(commonTag("stones/arcanite")).add(BlockRegistry.arcaniteStone.getKey());
        tag(commonTag("stones")).addTags(commonTag("stones/frozen"), commonTag("stones/cobaltite"), commonTag("stones/coalstone"), commonTag("stones/arcanite"));

        tag(commonTag("cobblestones/frozen")).add(BlockRegistry.frozenStone.getKey());
        tag(commonTag("cobblestones/cobaltite")).add(BlockRegistry.cobaltite.getKey());
        tag(commonTag("cobblestones/coalstone")).add(BlockRegistry.coalstone.getKey());
        tag(commonTag("cobblestones")).addTags(commonTag("cobblestones/frozen"), commonTag("cobblestones/cobaltite"), commonTag("cobblestones/coalstone"));

        tag(commonTag("ores_in_ground/netherrack")).add(BlockRegistry.torriditeOre.getKey(), BlockRegistry.bloodgemOre.getKey());
        tag(commonTag("ores_in_ground/stone")).add(BlockRegistry.realmiteOre.getKey(), BlockRegistry.rupeeOre.getKey(), BlockRegistry.arlemiteOre.getKey());
        tag(commonTag("ores_in_ground/deepslate")).add(BlockRegistry.realmiteOreDeepslate.getKey(), BlockRegistry.rupeeOreDeepslate.getKey(), BlockRegistry.arlemiteOreDeepslate.getKey());

        tag(customTag("replaceable_by_trees/iceika")).addTags(BlockTags.SNOW);

        tag(MINEABLE_SHICKAXE).addTags(BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_HOE, BlockTags.MINEABLE_WITH_SHOVEL);

        for (var entry : DivineRegistries.BLOCKS.getEntries()) {
            Block b = entry.get();
            var key = b.builtInRegistryHolder().getKey();
            String path = entry.getId().getPath();

            if (path.contains("ore") || path.contains("stone") || path.contains("cobble") || path.contains("block")) {
                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(key);
            }
            if (path.contains("plank") || path.contains("log") || path.contains("fence") || path.contains("door") || path.contains("trapdoor")) {
                tag(BlockTags.MINEABLE_WITH_AXE).add(key);
            }

            if (path.contains("_planks")) tag(BlockTags.PLANKS).add(key);
            if (path.contains("_log")) {
                tag(BlockTags.LOGS).add(key);
                tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(key);
                tag(minecraftTag("logs_that_burn")).add(key);
            }
            if (b instanceof LeavesBlock) tag(BlockTags.LEAVES).add(key);
            if (b instanceof SaplingBlock) tag(minecraftTag("saplings")).add(key);
            if (b instanceof FenceBlock) tag(BlockTags.FENCES).add(key);
            if (b instanceof FenceGateBlock) tag(BlockTags.FENCE_GATES).add(key);
            if (b instanceof StairBlock) tag(BlockTags.STAIRS).add(key);
            if (b instanceof SlabBlock) tag(BlockTags.SLABS).add(key);
            if (b instanceof ButtonBlock) tag(BlockTags.BUTTONS).add(key);
            if (b instanceof PressurePlateBlock) tag(BlockTags.PRESSURE_PLATES).add(key);
            if (b instanceof WallBlock) tag(BlockTags.WALLS).add(key);
            if (b instanceof DoorBlock) tag(BlockTags.DOORS).add(key);
            if (b instanceof TrapDoorBlock) tag(BlockTags.TRAPDOORS).add(key);
        }
    }

    private TagKey<Block> commonTag(String name){
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", name));
    }
    private TagKey<Block> minecraftTag(String name){
        return TagKey.create(Registries.BLOCK, Identifier.withDefaultNamespace(name));
    }
    private TagKey<Block> customTag(String name){
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name));
    }
}