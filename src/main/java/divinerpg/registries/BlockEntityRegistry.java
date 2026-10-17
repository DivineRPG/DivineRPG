package divinerpg.registries;

import divinerpg.block_entities.block.*;
import divinerpg.block_entities.bosses.DramixAltarBlockEntity;
import divinerpg.block_entities.bosses.ParasectaAltarBlockEntity;
import divinerpg.block_entities.furnace.ArcaniumExtractorBlockEntity;
import divinerpg.client.renders.block_entities.RenderArcaniumExtractor;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;
import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InserterBlockEntity>> INSERTER = register("inserter", () -> new BlockEntityType<>(InserterBlockEntity::new, BlockRegistry.inserter.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KarosDispenser>> KAROS_DISPENSER = register("karos_dispenser", () -> new BlockEntityType<>(KarosDispenser::new, BlockRegistry.karosDispenser.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RobbinNestBlockEntity>> ROBBIN_NEST = register("robbin_nest", () -> new BlockEntityType<>(RobbinNestBlockEntity::new, BlockRegistry.robbinNest.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RobbinHutBlockEntity>> ROBBIN_HUT = register("robbin_hut", () -> new BlockEntityType<>(RobbinHutBlockEntity::new, BlockRegistry.robbinHut.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NightmareBedBlockEntity>> NIGHTMARE_BED = register("nightmare_bed", () -> new BlockEntityType<>(NightmareBedBlockEntity::new, BlockRegistry.nightmareBed.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DramixAltarBlockEntity>> DRAMIX_ALTAR = register("dramix_altar", () -> new BlockEntityType<>(DramixAltarBlockEntity::new, BlockRegistry.dramixAltar.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ParasectaAltarBlockEntity>> PARASECTA_ALTAR = register("parasecta_altar", () -> new BlockEntityType<>(ParasectaAltarBlockEntity::new, BlockRegistry.parasectaAltar.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PortalBlockEntity>> PORTAL = register("portal", () -> new BlockEntityType<PortalBlockEntity>((pos, state) -> new PortalBlockEntity(pos, state), Set.of(BlockRegistry.arcanaPortal.get(), BlockRegistry.edenPortal.get(), BlockRegistry.wildwoodPortal.get(), BlockRegistry.apalachiaPortal.get(), BlockRegistry.skythernPortal.get(), BlockRegistry.mortumPortal.get(), BlockRegistry.iceikaPortal.get(), BlockRegistry.vetheaPortal.get())));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ArcaniumExtractorBlockEntity>> ARCANIUM_EXTRACTOR = register("arcanium_extractor", () -> new BlockEntityType<>(ArcaniumExtractorBlockEntity::new, BlockRegistry.arcaniumExtractor.get()));


    static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryName, Supplier<BlockEntityType<T>> tile) {
        return DivineRegistries.BLOCK_ENTITIES.register(registryName, tile);
    }
    public static void load() {}

    public static void renderTiles() {
//        //Work Stations
//        BlockEntityRenderers.register(ALTAR_OF_CORRUPTION.get(), RenderAltarOfCorruption::new);
        BlockEntityRenderers.register(ARCANIUM_EXTRACTOR.get(), RenderArcaniumExtractor::new);
//        BlockEntityRenderers.register(DEMON_FURNACE.get(), RenderDemonFurnace::new);
//        //Signs
//        BlockEntityRenderers.register(DIVINE_SIGN.get(), SignRenderer::new);
//        BlockEntityRenderers.register(DIVINE_HANGING_SIGN.get(), HangingSignRenderer::new);
//        //Chests
//        BlockEntityRenderers.register(BONE_CHEST.get(), RenderBoneChest::new);
//        BlockEntityRenderers.register(ROBBIN_NEST.get(), RenderRobbinNest::new);
//        BlockEntityRenderers.register(PRESENT_BOX.get(), RenderPresentBox::new);
//        BlockEntityRenderers.register(FROSTED_CHEST.get(), RenderFrostedChest::new);
//        BlockEntityRenderers.register(EDEN_CHEST.get(), RenderEdenChest::new);
//        //Boss
//        BlockEntityRenderers.register(STATUE.get(), RenderStatue::new);
//        BlockEntityRenderers.register(AYERACO_BEAM.get(), RenderAyeracoBeam::new);
//        BlockEntityRenderers.register(DRAMIX_ALTAR.get(), RenderDramixAltar::new);
//        BlockEntityRenderers.register(PARASECTA_ALTAR.get(), RenderParasectaAltar::new);
//        //Dimension
//        BlockEntityRenderers.register(RIFT.get(), RenderRift::new);
//        BlockEntityRenderers.register(NIGHTMARE_BED.get(), RenderNightmareBed::new);
    }
}
