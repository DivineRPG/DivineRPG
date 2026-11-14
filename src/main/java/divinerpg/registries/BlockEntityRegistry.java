package divinerpg.registries;

import divinerpg.block_entities.block.*;
import divinerpg.block_entities.bosses.*;
import divinerpg.block_entities.chest.*;
import divinerpg.block_entities.furnace.*;
import divinerpg.client.renders.block_entities.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.*;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InserterBlockEntity>> INSERTER = register("inserter", () -> new BlockEntityType<>(InserterBlockEntity::new, BlockRegistry.inserter.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KarosDispenser>> KAROS_DISPENSER = register("karos_dispenser", () -> new BlockEntityType<>(KarosDispenser::new, BlockRegistry.karosDispenser.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RobbinNestBlockEntity>> ROBBIN_NEST = register("robbin_nest", () -> new BlockEntityType<>(RobbinNestBlockEntity::new, BlockRegistry.robbinNest.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RobbinHutBlockEntity>> ROBBIN_HUT = register("robbin_hut", () -> new BlockEntityType<>(RobbinHutBlockEntity::new, BlockRegistry.robbinHut.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DramixAltarBlockEntity>> DRAMIX_ALTAR = register("dramix_altar", () -> new BlockEntityType<>(DramixAltarBlockEntity::new, BlockRegistry.dramixAltar.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ParasectaAltarBlockEntity>> PARASECTA_ALTAR = register("parasecta_altar", () -> new BlockEntityType<>(ParasectaAltarBlockEntity::new, BlockRegistry.parasectaAltar.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PortalBlockEntity>> PORTAL = register("portal", () -> new BlockEntityType<>(PortalBlockEntity::new, BlockRegistry.gateway.get(), BlockRegistry.divinePortal.get(), BlockRegistry.arcanaPortal.get(), BlockRegistry.edenPortal.get(), BlockRegistry.wildwoodPortal.get(), BlockRegistry.apalachiaPortal.get(), BlockRegistry.skythernPortal.get(), BlockRegistry.mortumPortal.get(), BlockRegistry.iceikaPortal.get(), BlockRegistry.vetheaPortal.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ArcaniumExtractorBlockEntity>> ARCANIUM_EXTRACTOR = register("arcanium_extractor", () -> new BlockEntityType<>(ArcaniumExtractorBlockEntity::new, BlockRegistry.arcaniumExtractor.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ProximitySpawnerBlockEntity>> PROXIMITY_SPAWNER = register("proximity_spawner", () -> new BlockEntityType<>(ProximitySpawnerBlockEntity::new, BlockRegistry.proximitySpawner.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KobblinBurrowBlockEntity>> KOBBLIN_BURROW = register("kobblin_burrow", () -> new BlockEntityType<>(KobblinBurrowBlockEntity::new, BlockRegistry.kobblinBurrow.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DreamLampBlockEntity>> DREAM_LAMP = register("dream_lamp", () -> new BlockEntityType<>(DreamLampBlockEntity::new, BlockRegistry.dreamLamp.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AyeracoSpawnBlockEntity>> AYERACO_SPAWN = register("ayeraco_spawn", () -> new BlockEntityType<>(AyeracoSpawnBlockEntity::new, BlockRegistry.ayeracoSpawn.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UpdatableBlockEntity>> AYERACO_BEAM = register("ayeraco_beam", () -> new BlockEntityType<>(AyeracoBeamBlockEntity::new, BlockRegistry.ayeracoBeamBlue.get(), BlockRegistry.ayeracoBeamGreen.get(), BlockRegistry.ayeracoBeamPink.get(), BlockRegistry.ayeracoBeamPurple.get(), BlockRegistry.ayeracoBeamRed.get(), BlockRegistry.ayeracoBeamYellow.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarOfCorruptionBlockEntity>> ALTAR_OF_CORRUPTION = register("altar_of_corruption", () -> new BlockEntityType<>(AltarOfCorruptionBlockEntity::new, BlockRegistry.altarOfCorruption.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CoalstoneFurnaceBlockEntity>> COALSTONE_FURNACE = register("coalstone_furnace", () -> new BlockEntityType<>(CoalstoneFurnaceBlockEntity::new, BlockRegistry.coalstoneFurnace.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MoltenFurnaceBlockEntity>> MOLTEN_FURNACE = register("molten_furnace", () -> new BlockEntityType<>(MoltenFurnaceBlockEntity::new, BlockRegistry.moltenFurnace.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GreenlightFurnaceBlockEntity>> GREENLIGHT_FURNACE = register("greenlight_furnace", () -> new BlockEntityType<>(GreenlightFurnaceBlockEntity::new, BlockRegistry.greenlightFurnace.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OceanfireFurnaceBlockEntity>> OCEANFIRE_FURNACE = register("oceanfire_furnace", () -> new BlockEntityType<>(OceanfireFurnaceBlockEntity::new, BlockRegistry.oceanfireFurnace.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MoonlightFurnaceBlockEntity>> MOONLIGHT_FURNACE = register("moonlight_furnace", () -> new BlockEntityType<>(MoonlightFurnaceBlockEntity::new, BlockRegistry.moonlightFurnace.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhitefireFurnaceBlockEntity>> WHITEFIRE_FURNACE = register("whitefire_furnace", () -> new BlockEntityType<>(WhitefireFurnaceBlockEntity::new, BlockRegistry.whitefireFurnace.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DemonFurnaceBlockEntity>> DEMON_FURNACE = register("demon_furnace", () -> new BlockEntityType<>(DemonFurnaceBlockEntity::new, BlockRegistry.demonFurnace.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoneChestBlockEntity>> BONE_CHEST = register("bone_chest", () -> new BlockEntityType<>(BoneChestBlockEntity::new, BlockRegistry.boneChest.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FrostedChestBlockEntity>> FROSTED_CHEST = register("frosted_chest", () -> new BlockEntityType<>(FrostedChestBlockEntity::new, BlockRegistry.frostedChest.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PresentBoxBlockEntity>> PRESENT_BOX = register("present_box", () -> new BlockEntityType<>(PresentBoxBlockEntity::new, BlockRegistry.presentBox.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EdenChestBlockEntity>> EDEN_CHEST = register("eden_chest", () -> new BlockEntityType<>(EdenChestBlockEntity::new, BlockRegistry.edenChest.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrateBlockEntity>> CRATE = register("crate", () -> new BlockEntityType<>(CrateBlockEntity::new, BlockRegistry.crate.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OxcrateBlockEntity>> OXCRATE = register("oxcrate", () -> new BlockEntityType<>(OxcrateBlockEntity::new, BlockRegistry.oxcrate.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DistributorBlockEntity>> DISTRIBUTOR = register("distributor", () -> new BlockEntityType<>(DistributorBlockEntity::new, BlockRegistry.distributor.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FrostedAllureBlockEntity>> FROSTED_ALLURE = register("frosted_allure", () -> new BlockEntityType<>(FrostedAllureBlockEntity::new, BlockRegistry.frostedAllure.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BonfireBlockEntity>> BONFIRE = register("bonfire", () -> new BlockEntityType<>(BonfireBlockEntity::new, BlockRegistry.bonfire.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RiftBlockEntity>> RIFT = register("rift", () -> new BlockEntityType<>(RiftBlockEntity::new, BlockRegistry.edenRift.get(), BlockRegistry.wildwoodRift.get(), BlockRegistry.apalachiaRift.get(), BlockRegistry.skythernRift.get(), BlockRegistry.mortumRift.get(), BlockRegistry.overworldRift.get()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TerranGhostBlockEntity>> TERRAN_GHOST = register("terran_ghost", () -> new BlockEntityType<>(TerranGhostBlockEntity::new, BlockRegistry.terranGhostBlock.get()));

    static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryName, Supplier<BlockEntityType<T>> tile) {
        return DivineRegistries.BLOCK_ENTITIES.register(registryName, tile);
    }
    public static void load() {}

    public static void renderTiles() {
        //Work Stations
        BlockEntityRenderers.register(ALTAR_OF_CORRUPTION.get(), RenderAltarOfCorruption::new);
        BlockEntityRenderers.register(ARCANIUM_EXTRACTOR.get(), RenderArcaniumExtractor::new);
        BlockEntityRenderers.register(DEMON_FURNACE.get(), RenderDemonFurnace::new);
//        //Signs
//        BlockEntityRenderers.register(DIVINE_SIGN.get(), SignRenderer::new);
//        BlockEntityRenderers.register(DIVINE_HANGING_SIGN.get(), HangingSignRenderer::new);
        //Chests
        BlockEntityRenderers.register(BONE_CHEST.get(), RenderBoneChest::new);
//        BlockEntityRenderers.register(ROBBIN_NEST.get(), RenderRobbinNest::new);
        BlockEntityRenderers.register(PRESENT_BOX.get(), RenderPresentBox::new);
        BlockEntityRenderers.register(FROSTED_CHEST.get(), RenderFrostedChest::new);
        BlockEntityRenderers.register(EDEN_CHEST.get(), RenderEdenChest::new);
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
