package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.client.renders.tiles.*;
import divinerpg.tiles.*;
import divinerpg.tiles.block.*;
import divinerpg.tiles.bosses.*;
import divinerpg.tiles.chests.*;
import divinerpg.tiles.furnace.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.*;

import java.util.function.*;

import static divinerpg.DivineRPG.MODID;


public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
    public static final RegistryObject<BlockEntityType<AltarOfCorruptionEntity>> ALTAR_OF_CORRUPTION = register("altar_of_corruption", () -> BlockEntityType.Builder.of(AltarOfCorruptionEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "altar_of_corruption"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityNightmareBed>> NIGHTMARE_BED = register("nightmare_bed", () -> BlockEntityType.Builder.of(TileEntityNightmareBed::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "nightmare_bed_block"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityAyeracoSpawn>> AYERACO_SPAWN = register("ayeraco_spawn", () -> BlockEntityType.Builder.of(TileEntityAyeracoSpawn::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_spawn"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityAyeracoBeam>> AYERACO_BEAM = register("ayeraco_beam", () -> BlockEntityType.Builder.of(TileEntityAyeracoBeam::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_blue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_green")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_pink")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_purple")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_red")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_yellow"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityStatue>> STATUE = register("statue", () -> BlockEntityType.Builder.of(TileEntityStatue::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ancient_entity_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "densos_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eternal_archer_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "karot_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "reyvor_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "termasect_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "sunstorm_statue")), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "experienced_cori_statue"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityBoneChest>> BONE_CHEST = register("bone_chest", () -> BlockEntityType.Builder.of(TileEntityBoneChest::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "bone_chest"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityFrostedChest>> FROSTED_CHEST = register("frosted_chest", () -> BlockEntityType.Builder.of(TileEntityFrostedChest::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frosted_chest"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityEdenChest>> EDEN_CHEST = register("eden_chest", () -> BlockEntityType.Builder.of(TileEntityEdenChest::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_chest"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityPresentBox>> PRESENT_BOX = register("present_box", () -> BlockEntityType.Builder.of(TileEntityPresentBox::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "present_box"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityCoalstoneFurnace>> COALSTONE_FURNACE = register("coalstone_furnace", () -> BlockEntityType.Builder.of(TileEntityCoalstoneFurnace::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityDemonFurnace>> DEMON_FURNACE = register("demon_furnace", () -> BlockEntityType.Builder.of(TileEntityDemonFurnace::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "demon_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityGreenlightFurnace>> GREENLIGHT_FURNACE = register("greelight_furnace", () -> BlockEntityType.Builder.of(TileEntityGreenlightFurnace::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "greenlight_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityOceanfireFurnace>> OCEANFIRE_FURNACE = register("oceanfire_furnace", () -> BlockEntityType.Builder.of(TileEntityOceanfireFurnace::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "oceanfire_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityMoltenFurnace>> MOLTEN_FURNACE = register("molten_furnace", () -> BlockEntityType.Builder.of(TileEntityMoltenFurnace::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "molten_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityWhitefireFurnace>> WHITEFIRE_FURNACE = register("whitefire_furnace", () -> BlockEntityType.Builder.of(TileEntityWhitefireFurnace::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "whitefire_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityMoonlightFurnace>> MOONLIGHT_FURNACE = register("moonlight_furnace", () -> BlockEntityType.Builder.of(TileEntityMoonlightFurnace::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonlight_furnace"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityArcaniumExtractor>> ARCANIUM_EXTRACTOR = register("arcanium_extractor", () -> BlockEntityType.Builder.of(TileEntityArcaniumExtractor::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityParasectaAltar>> PARASECTA_ALTAR = register("parasecta_altar", () -> BlockEntityType.Builder.of(TileEntityParasectaAltar::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_altar"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityDramixAltar>> DRAMIX_ALTAR = register("dramix_altar", () -> BlockEntityType.Builder.of(TileEntityDramixAltar::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_altar"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityDreamLamp>> DREAM_LAMP = register("dream_lamp", () -> BlockEntityType.Builder.of(TileEntityDreamLamp::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_lamp"))).build(null));
    public static final RegistryObject<BlockEntityType<TileEntityInfusionTable>> INFUSION_TABLE = register("infusion_table", () -> BlockEntityType.Builder.of(TileEntityInfusionTable::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "infusion_table"))).build(null));
    public static final RegistryObject<BlockEntityType<FrostedAllureBlockEntity>> FROSTED_ALLURE = register("frosted_allure", () -> BlockEntityType.Builder.of(FrostedAllureBlockEntity::new, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frosted_allure"))).build(null));

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
