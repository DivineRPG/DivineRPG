package divinerpg.registries;

import divinerpg.block_entities.*;
import divinerpg.block_entities.block.*;
import divinerpg.block_entities.bosses.*;
import divinerpg.block_entities.chests.*;
import divinerpg.block_entities.furnace.*;
import divinerpg.client.renders.tiles.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.*;
import net.neoforged.api.distmarker.*;
import net.neoforged.neoforge.registries.*;

import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;


public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarOfCorruptionBlockEntity>> ALTAR_OF_CORRUPTION = register("altar_of_corruption", () -> BlockEntityType.Builder.of(AltarOfCorruptionBlockEntity::new, BlockRegistry.altarOfCorruption.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NightmareBedBlockEntity>> NIGHTMARE_BED = register("nightmare_bed", () -> BlockEntityType.Builder.of(NightmareBedBlockEntity::new, BlockRegistry.nightmareBed.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AyeracoSpawnBlockEntity>> AYERACO_SPAWN = register("ayeraco_spawn", () -> BlockEntityType.Builder.of(AyeracoSpawnBlockEntity::new, BlockRegistry.ayeracoSpawn.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AyeracoBeamBlockEntity>> AYERACO_BEAM = register("ayeraco_beam", () -> BlockEntityType.Builder.of(AyeracoBeamBlockEntity::new, BlockRegistry.ayeracoBeamBlue.get(), BlockRegistry.ayeracoBeamGreen.get(), BlockRegistry.ayeracoBeamPink.get(), BlockRegistry.ayeracoBeamPurple.get(), BlockRegistry.ayeracoBeamRed.get(), BlockRegistry.ayeracoBeamYellow.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StatueBlockEntity>> STATUE = register("statue", () -> BlockEntityType.Builder.of(StatueBlockEntity::new, BlockRegistry.ancientEntityStatue.get(), BlockRegistry.ayeracoStatue.get(), BlockRegistry.densosStatue.get(), BlockRegistry.dramixStatue.get(), BlockRegistry.eternalArcherStatue.get(), BlockRegistry.karotStatue.get(), BlockRegistry.kingOfScorchersStatue.get(), BlockRegistry.parasectaStatue.get(), BlockRegistry.reyvorStatue.get(), BlockRegistry.soulFiendStatue.get(), BlockRegistry.theWatcherStatue.get(), BlockRegistry.twilightDemonStatue.get(), BlockRegistry.vamacheronStatue.get(), BlockRegistry.termasectStatue.get(), BlockRegistry.sunstormStatue.get(), BlockRegistry.experiencedCoriStatue.get(), BlockRegistry.kitraStatue.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoneChestBlockEntity>> BONE_CHEST = register("bone_chest", () -> BlockEntityType.Builder.of(BoneChestBlockEntity::new, BlockRegistry.boneChest.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FrostedChestBlockEntity>> FROSTED_CHEST = register("frosted_chest", () -> BlockEntityType.Builder.of(FrostedChestBlockEntity::new, BlockRegistry.frostedChest.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EdenChestBlockEntity>> EDEN_CHEST = register("eden_chest", () -> BlockEntityType.Builder.of(EdenChestBlockEntity::new, BlockRegistry.edenChest.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PresentBoxBlockEntity>> PRESENT_BOX = register("present_box", () -> BlockEntityType.Builder.of(PresentBoxBlockEntity::new, BlockRegistry.presentBox.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CoalstoneFurnaceBlockEntity>> COALSTONE_FURNACE = register("coalstone_furnace", () -> BlockEntityType.Builder.of(CoalstoneFurnaceBlockEntity::new, BlockRegistry.coalstoneFurnace.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DemonFurnaceBlockEntity>> DEMON_FURNACE = register("demon_furnace", () -> BlockEntityType.Builder.of(DemonFurnaceBlockEntity::new, BlockRegistry.demonFurnace.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GreenlightFurnaceBlockEntity>> GREENLIGHT_FURNACE = register("greelight_furnace", () -> BlockEntityType.Builder.of(GreenlightFurnaceBlockEntity::new, BlockRegistry.greenlightFurnace.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OceanfireFurnaceBlockEntity>> OCEANFIRE_FURNACE = register("oceanfire_furnace", () -> BlockEntityType.Builder.of(OceanfireFurnaceBlockEntity::new, BlockRegistry.oceanfireFurnace.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MoltenFurnaceBlockEntity>> MOLTEN_FURNACE = register("molten_furnace", () -> BlockEntityType.Builder.of(MoltenFurnaceBlockEntity::new, BlockRegistry.moltenFurnace.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhitefireFurnaceBlockEntity>> WHITEFIRE_FURNACE = register("whitefire_furnace", () -> BlockEntityType.Builder.of(WhitefireFurnaceBlockEntity::new, BlockRegistry.whitefireFurnace.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MoonlightFurnaceBlockEntity>> MOONLIGHT_FURNACE = register("moonlight_furnace", () -> BlockEntityType.Builder.of(MoonlightFurnaceBlockEntity::new, BlockRegistry.moonlightFurnace.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ArcaniumExtractorBlockEntity>> ARCANIUM_EXTRACTOR = register("arcanium_extractor", () -> BlockEntityType.Builder.of(ArcaniumExtractorBlockEntity::new, BlockRegistry.arcaniumExtractor.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ParasectaAltarBlockEntity>> PARASECTA_ALTAR = register("parasecta_altar", () -> BlockEntityType.Builder.of(ParasectaAltarBlockEntity::new, BlockRegistry.parasectaAltar.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DramixAltarBlockEntity>> DRAMIX_ALTAR = register("dramix_altar", () -> BlockEntityType.Builder.of(DramixAltarBlockEntity::new, BlockRegistry.dramixAltar.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DreamLampBlockEntity>> DREAM_LAMP = register("dream_lamp", () -> BlockEntityType.Builder.of(DreamLampBlockEntity::new, BlockRegistry.dreamLamp.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InfusionTableBlockEntity>> INFUSION_TABLE = register("infusion_table", () -> BlockEntityType.Builder.of(InfusionTableBlockEntity::new, BlockRegistry.infusionTable.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FrostedAllureBlockEntity>> FROSTED_ALLURE = register("frosted_allure", () -> BlockEntityType.Builder.of(FrostedAllureBlockEntity::new, BlockRegistry.frostedAllure.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ProximitySpawnerBlockEntity>> PROXIMITY_SPAWNER = register("proximity_spawner", () -> BlockEntityType.Builder.of(ProximitySpawnerBlockEntity::new, BlockRegistry.proximitySpawner.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RobbinNestBlockEntity>> ROBBIN_NEST = register("robbin_nest", () -> BlockEntityType.Builder.of(RobbinNestBlockEntity::new, BlockRegistry.robbinNest.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RobbinHutBlockEntity>> ROBBIN_HUT = register("robbin_hut", () -> BlockEntityType.Builder.of(RobbinHutBlockEntity::new, BlockRegistry.robbinHut.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrateBlockEntity>> CRATE = register("crate", () -> BlockEntityType.Builder.of(CrateBlockEntity::new, BlockRegistry.crate.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PortalBlockEntity>> PORTAL = register("portal", () -> BlockEntityType.Builder.of(PortalBlockEntity::new, BlockRegistry.arcanaPortal.get(), BlockRegistry.iceikaPortal.get(), BlockRegistry.edenPortal.get(), BlockRegistry.wildwoodPortal.get(), BlockRegistry.apalachiaPortal.get(), BlockRegistry.skythernPortal.get(), BlockRegistry.mortumPortal.get(), BlockRegistry.vetheaPortal.get()).build(null));
    
    private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryName, Supplier<BlockEntityType<T>> tile) {
        return BLOCK_ENTITIES.register(registryName, tile);
    }
    public static void renderTiles(){
        BlockEntityRenderers.register(ALTAR_OF_CORRUPTION.get(), RenderAltarOfCorruption::new);
        BlockEntityRenderers.register(NIGHTMARE_BED.get(), RenderNightmareBed::new);
        BlockEntityRenderers.register(STATUE.get(), RenderStatue::new);
        BlockEntityRenderers.register(BONE_CHEST.get(), RenderBoneChest::new);
        BlockEntityRenderers.register(DEMON_FURNACE.get(), RenderDemonFurnace::new);
        BlockEntityRenderers.register(ARCANIUM_EXTRACTOR.get(), RenderArcaniumExtractor::new);
        BlockEntityRenderers.register(EDEN_CHEST.get(), RenderEdenChest::new);
        BlockEntityRenderers.register(DRAMIX_ALTAR.get(), RenderDramixAltar::new);
        BlockEntityRenderers.register(PARASECTA_ALTAR.get(), RenderParasectaAltar::new);
        BlockEntityRenderers.register(AYERACO_BEAM.get(), RenderAyeracoBeam::new);
        BlockEntityRenderers.register(PRESENT_BOX.get(), RenderPresentBox::new);
        BlockEntityRenderers.register(FROSTED_CHEST.get(), RenderFrostedChest::new);
        BlockEntityRenderers.register(ROBBIN_NEST.get(), RenderRobbinNest::new);
    }
}