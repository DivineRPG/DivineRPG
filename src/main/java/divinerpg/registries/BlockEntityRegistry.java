package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.block_entities.*;
import divinerpg.block_entities.block.*;
import divinerpg.block_entities.bosses.*;
import divinerpg.block_entities.chests.*;
import divinerpg.block_entities.furnace.*;
import divinerpg.client.renders.tiles.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.*;
import net.neoforged.api.distmarker.*;
import net.neoforged.neoforge.registries.*;

import java.util.Arrays;
import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;


public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MODID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarOfCorruptionBlockEntity>> ALTAR_OF_CORRUPTION = register("altar_of_corruption", AltarOfCorruptionBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "altar_of_corruption")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NightmareBedBlockEntity>> NIGHTMARE_BED = register("nightmare_bed", NightmareBedBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "nightmare_bed")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AyeracoSpawnBlockEntity>> AYERACO_SPAWN = register("ayeraco_spawn", AyeracoSpawnBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_spawn")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AyeracoBeamBlockEntity>> AYERACO_BEAM = register("ayeraco_beam", AyeracoBeamBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_blue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_green")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_pink")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_purple")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_red")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_beam_yellow")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StatueBlockEntity>> STATUE = register("statue", StatueBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ancient_entity_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "densos_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "dramix_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "eternal_archer_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "karot_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "king_of_scorchers_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "parasecta_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "reyvor_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "termasect_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "sunstorm_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "experienced_cori_statue")), () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "kitra_statue")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoneChestBlockEntity>> BONE_CHEST = register("bone_chest", BoneChestBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "bone_chest")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FrostedChestBlockEntity>> FROSTED_CHEST = register("frosted_chest", FrostedChestBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "frosted_chest")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EdenChestBlockEntity>> EDEN_CHEST = register("eden_chest", EdenChestBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "eden_chest")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PresentBoxBlockEntity>> PRESENT_BOX = register("present_box", PresentBoxBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "present_box")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CoalstoneFurnaceBlockEntity>> COALSTONE_FURNACE = register("coalstone_furnace", CoalstoneFurnaceBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "coalstone_furnace")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DemonFurnaceBlockEntity>> DEMON_FURNACE = register("demon_furnace", DemonFurnaceBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "demon_furnace")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GreenlightFurnaceBlockEntity>> GREENLIGHT_FURNACE = register("greelight_furnace", GreenlightFurnaceBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "greenlight_furnace")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OceanfireFurnaceBlockEntity>> OCEANFIRE_FURNACE = register("oceanfire_furnace", OceanfireFurnaceBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "oceanfire_furnace")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MoltenFurnaceBlockEntity>> MOLTEN_FURNACE = register("molten_furnace", MoltenFurnaceBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "molten_furnace")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhitefireFurnaceBlockEntity>> WHITEFIRE_FURNACE = register("whitefire_furnace", WhitefireFurnaceBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "whitefire_furnace")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MoonlightFurnaceBlockEntity>> MOONLIGHT_FURNACE = register("moonlight_furnace", MoonlightFurnaceBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "moonlight_furnace")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ArcaniumExtractorBlockEntity>> ARCANIUM_EXTRACTOR = register("arcanium_extractor", ArcaniumExtractorBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ParasectaAltarBlockEntity>> PARASECTA_ALTAR = register("parasecta_altar", ParasectaAltarBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "parasecta_altar")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DramixAltarBlockEntity>> DRAMIX_ALTAR = register("dramix_altar", DramixAltarBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "dramix_altar")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DreamLampBlockEntity>> DREAM_LAMP = register("dream_lamp", DreamLampBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "dream_lamp")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InfusionTableBlockEntity>> INFUSION_TABLE = register("infusion_table", InfusionTableBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "infusion_table")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FrostedAllureBlockEntity>> FROSTED_ALLURE = register("frosted_allure", FrostedAllureBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "frosted_allure")));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ProximitySpawnerBlockEntity>> PROXIMITY_SPAWNER = register("proximity_spawner", ProximitySpawnerBlockEntity::new, () -> BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "proximity_spawner")));

    private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> factory, Supplier<Block>... block) {
        while(Arrays.stream(block).iterator().hasNext()){
            return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(factory, Arrays.stream(block).iterator().next().get()).build(null));
        }
        return null;
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
