package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.client.renders.tiles.*;
import divinerpg.block_entities.*;
import divinerpg.block_entities.block.*;
import divinerpg.block_entities.bosses.*;
import divinerpg.block_entities.chests.*;
import divinerpg.block_entities.furnace.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.*;

import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;


public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
    public static final RegistryObject<BlockEntityType<AltarOfCorruptionBlockEntity>> ALTAR_OF_CORRUPTION = register("altar_of_corruption", () -> BlockEntityType.Builder.of(AltarOfCorruptionBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "altar_of_corruption"))).build(null));
    public static final RegistryObject<BlockEntityType<NightmareBedBlockEntity>> NIGHTMARE_BED = register("nightmare_bed", () -> BlockEntityType.Builder.of(NightmareBedBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "nightmare_bed_block"))).build(null));
    public static final RegistryObject<BlockEntityType<AyeracoSpawnBlockEntity>> AYERACO_SPAWN = register("ayeraco_spawn", () -> BlockEntityType.Builder.of(AyeracoSpawnBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_spawn"))).build(null));
    public static final RegistryObject<BlockEntityType<AyeracoBeamBlockEntity>> AYERACO_BEAM = register("ayeraco_beam", () -> BlockEntityType.Builder.of(AyeracoBeamBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_blue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_green")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_pink")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_purple")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_red")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_yellow"))).build(null));
    public static final RegistryObject<BlockEntityType<StatueBlockEntity>> STATUE = register("statue", () -> BlockEntityType.Builder.of(StatueBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_entity_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "densos_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eternal_archer_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karot_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "reyvor_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "termasect_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "sunstorm_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "experienced_cori_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "kitra_statue"))).build(null));
   public static final RegistryObject<BlockEntityType<BoneChestBlockEntity>> BONE_CHEST = register("bone_chest", () -> BlockEntityType.Builder.of(BoneChestBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "bone_chest"))).build(null));
    public static final RegistryObject<BlockEntityType<FrostedChestBlockEntity>> FROSTED_CHEST = register("frosted_chest", () -> BlockEntityType.Builder.of(FrostedChestBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frosted_chest"))).build(null));
    public static final RegistryObject<BlockEntityType<EdenChestBlockEntity>> EDEN_CHEST = register("eden_chest", () -> BlockEntityType.Builder.of(EdenChestBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_chest"))).build(null));
    public static final RegistryObject<BlockEntityType<PresentBoxBlockEntity>> PRESENT_BOX = register("present_box", () -> BlockEntityType.Builder.of(PresentBoxBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "present_box"))).build(null));
    public static final RegistryObject<BlockEntityType<CoalstoneFurnaceBlockEntity>> COALSTONE_FURNACE = register("coalstone_furnace", () -> BlockEntityType.Builder.of(CoalstoneFurnaceBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<DemonFurnaceBlockEntity>> DEMON_FURNACE = register("demon_furnace", () -> BlockEntityType.Builder.of(DemonFurnaceBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "demon_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<GreenlightFurnaceBlockEntity>> GREENLIGHT_FURNACE = register("greelight_furnace", () -> BlockEntityType.Builder.of(GreenlightFurnaceBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "greenlight_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<OceanfireFurnaceBlockEntity>> OCEANFIRE_FURNACE = register("oceanfire_furnace", () -> BlockEntityType.Builder.of(OceanfireFurnaceBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "oceanfire_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<MoltenFurnaceBlockEntity>> MOLTEN_FURNACE = register("molten_furnace", () -> BlockEntityType.Builder.of(MoltenFurnaceBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "molten_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<WhitefireFurnaceBlockEntity>> WHITEFIRE_FURNACE = register("whitefire_furnace", () -> BlockEntityType.Builder.of(WhitefireFurnaceBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "whitefire_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<MoonlightFurnaceBlockEntity>> MOONLIGHT_FURNACE = register("moonlight_furnace", () -> BlockEntityType.Builder.of(MoonlightFurnaceBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonlight_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<ArcaniumExtractorBlockEntity>> ARCANIUM_EXTRACTOR = register("arcanium_extractor", () -> BlockEntityType.Builder.of(ArcaniumExtractorBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor"))).build(null));
    public static final RegistryObject<BlockEntityType<ParasectaAltarBlockEntity>> PARASECTA_ALTAR = register("parasecta_altar", () -> BlockEntityType.Builder.of(ParasectaAltarBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_altar"))).build(null));
    public static final RegistryObject<BlockEntityType<DramixAltarBlockEntity>> DRAMIX_ALTAR = register("dramix_altar", () -> BlockEntityType.Builder.of(DramixAltarBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_altar"))).build(null));
    public static final RegistryObject<BlockEntityType<DreamLampBlockEntity>> DREAM_LAMP = register("dream_lamp", () -> BlockEntityType.Builder.of(DreamLampBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_lamp"))).build(null));
    public static final RegistryObject<BlockEntityType<InfusionTableBlockEntity>> INFUSION_TABLE = register("infusion_table", () -> BlockEntityType.Builder.of(InfusionTableBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "infusion_table"))).build(null));
    public static final RegistryObject<BlockEntityType<FrostedAllureBlockEntity>> FROSTED_ALLURE = register("frosted_allure", () -> BlockEntityType.Builder.of(FrostedAllureBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frosted_allure"))).build(null));
    public static final RegistryObject<BlockEntityType<ProximitySpawnerBlockEntity>> PROXIMITY_SPAWNER = register("proximity_spawner", () -> BlockEntityType.Builder.of(ProximitySpawnerBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "proximity_spawner"))).build(null));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String registryName, Supplier<BlockEntityType<T>> tile) {
        return BLOCK_ENTITIES.register(registryName, tile);
    }

    @OnlyIn(Dist.CLIENT)
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
    }

}
