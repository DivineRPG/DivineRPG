package divinerpg.data;

import divinerpg.registries.BlockRegistry;
import divinerpg.registries.DivineRegistries;
import divinerpg.registries.TagRegistry;
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
import static divinerpg.registries.TagRegistry.*;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(APALACHIA_ORE).add(BlockRegistry.apalachiaOre.key());
        tag(ARLEMITE_ORE).add(BlockRegistry.arlemiteOre.key(), BlockRegistry.arlemiteOreDeepslate.key());
        tag(BLOODGEM_ORE).add(BlockRegistry.bloodgemOre.key());
        tag(EDEN_ORE).add(BlockRegistry.twilightEdenOre.key(), BlockRegistry.scorchaltEdenOre.key());
        tag(MORTUM_ORE).add(BlockRegistry.mortumOre.key());
        tag(OXDRITE_ORE).add(BlockRegistry.oxdriteOre.key());
        tag(REALMITE_ORE).add(BlockRegistry.realmiteOre.key(), BlockRegistry.realmiteOreDeepslate.key());
        tag(RUPEE_ORE).add(BlockRegistry.rupeeOre.key(), BlockRegistry.rupeeOreDeepslate.key());
        tag(SKYTHERN_ORE).add(BlockRegistry.skythernOre.key());
        tag(TORRIDITE_ORE).add(BlockRegistry.torriditeOre.key());
        tag(WILDWOOD_ORE).add(BlockRegistry.wildwoodOre.key());
        tag(ORES).addTags(APALACHIA_ORE, ARLEMITE_ORE, BLOODGEM_ORE, EDEN_ORE, MORTUM_ORE, OXDRITE_ORE, REALMITE_ORE, RUPEE_ORE, SKYTHERN_ORE, TORRIDITE_ORE, WILDWOOD_ORE);

        tag(commonTag("storage_blocks/realmite")).add(BlockRegistry.realmiteBlock.key());
        tag(commonTag("storage_blocks/arlemite")).add(BlockRegistry.arlemiteBlock.key());
        tag(commonTag("storage_blocks/rupee")).add(BlockRegistry.rupeeBlock.key());
        tag(commonTag("storage_blocks/bloodgem")).add(BlockRegistry.bloodgemBlock.key());
        tag(commonTag("storage_blocks/torridite")).add(BlockRegistry.torriditeBlock.key());
        tag(commonTag("storage_blocks/olivine")).add(BlockRegistry.olivineBlock.key());
        tag(commonTag("storage_blocks")).addTags(commonTag("storage_blocks/realmite"), commonTag("storage_blocks/arlemite"), commonTag("storage_blocks/rupee"), commonTag("storage_blocks/bloodgem"), commonTag("storage_blocks/torridite"), commonTag("storage_blocks/olivine"));

        tag(commonTag("stones/frozen")).add(BlockRegistry.frozenStone.key());
        tag(commonTag("stones/cobaltite")).add(BlockRegistry.cobaltite.key());
        tag(commonTag("stones/coalstone")).add(BlockRegistry.coalstone.key());
        tag(commonTag("stones/arcanite")).add(BlockRegistry.arcaniteStone.key());
        tag(commonTag("stones")).addTags(commonTag("stones/frozen"), commonTag("stones/cobaltite"), commonTag("stones/coalstone"), commonTag("stones/arcanite"));

        tag(commonTag("cobblestones/frozen")).add(BlockRegistry.frozenStone.key());
        tag(commonTag("cobblestones/cobaltite")).add(BlockRegistry.cobaltite.key());
        tag(commonTag("cobblestones/coalstone")).add(BlockRegistry.coalstone.key());
        tag(commonTag("cobblestones")).addTags(commonTag("cobblestones/frozen"), commonTag("cobblestones/cobaltite"), commonTag("cobblestones/coalstone"));

        tag(commonTag("ores_in_ground/netherrack")).add(BlockRegistry.torriditeOre.key(), BlockRegistry.bloodgemOre.key());
        tag(commonTag("ores_in_ground/stone")).add(BlockRegistry.realmiteOre.key(), BlockRegistry.rupeeOre.key(), BlockRegistry.arlemiteOre.key());
        tag(commonTag("ores_in_ground/deepslate")).add(BlockRegistry.realmiteOreDeepslate.key(), BlockRegistry.rupeeOreDeepslate.key(), BlockRegistry.arlemiteOreDeepslate.key());

        tag(customTag("replaceable_by_trees/iceika")).addTags(BlockTags.SNOW);
        tag(BASE_ICY_FIRE).addTags(BlockTags.SNOW, BlockTags.ICE).add(BlockRegistry.snowBricks.key(), BlockRegistry.icyStone.key());
        tag(BEDROCK_GRINDING_BASE).add(Blocks.BEDROCK.builtInRegistryHolder().key(), BlockRegistry.bedrockMinibricks.key());

        tag(MINEABLE_SHICKAXE).addTags(BlockTags.MINEABLE_WITH_AXE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_HOE, BlockTags.MINEABLE_WITH_SHOVEL);

        tag(EDEN_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());
        tag(WILDWOOD_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());
        tag(APALACHIA_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());
        tag(SKYTHERN_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());
        tag(MORTUM_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());
        tag(ICEIKA_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());
        tag(ARCANA_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());
        tag(VETHEA_INFINIBURN).add(Blocks.OBSIDIAN.builtInRegistryHolder().key(), Blocks.NETHERRACK.builtInRegistryHolder().key());

        for (var entry : DivineRegistries.BLOCKS.getEntries()) {
            Block b = entry.get();
            var key = b.builtInRegistryHolder().key();
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
            if (b instanceof GrassBlock) tag(BlockTags.GRASS_BLOCKS).add(key);
            if (b instanceof LadderBlock) tag(BlockTags.CLIMBABLE).add(key);
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