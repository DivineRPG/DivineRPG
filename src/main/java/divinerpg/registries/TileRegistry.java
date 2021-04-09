package divinerpg.registries;

import divinerpg.*;
import divinerpg.client.renders.tiles.*;
import divinerpg.tiles.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.client.registry.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.registries.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder("divinerpg")
public class TileRegistry {

    public static TileEntityType<AltarOfCorruptionEntity> ALTAR_OF_CORRUPTION;
    public static TileEntityType<TileEntityNightmareBed> NIGHTMARE_BED;
    public static TileEntityType<TileEntityAyeracoSpawn> AYERACO_SPAWN;
    public static TileEntityType<TileEntityAyeracoBeam> AYERACO_BEAM;
    public static  TileEntityType<TileEntityStatue> STATUE;
    public static  TileEntityType<TileEntitySingleUseSpawner> SINGLE_SPAWNER;
    public static  TileEntityType<TileEntityBoneChest> BONE_CHEST;

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event) {
        ALTAR_OF_CORRUPTION = TileEntityType.Builder.of(() -> new AltarOfCorruptionEntity(ALTAR_OF_CORRUPTION), BlockRegistry.altarOfCorruption).build(null);
        NIGHTMARE_BED = TileEntityType.Builder.of(() -> new TileEntityNightmareBed(NIGHTMARE_BED), BlockRegistry.nightmareBed).build(null);
        AYERACO_SPAWN = TileEntityType.Builder.of(() -> new TileEntityAyeracoSpawn(), BlockRegistry.ayeracoSpawn).build(null);
        AYERACO_BEAM = TileEntityType.Builder.of(() -> new TileEntityAyeracoBeam(), BlockRegistry.ayeracoBeamBlue, BlockRegistry.ayeracoBeamGreen, BlockRegistry.ayeracoBeamPurple, BlockRegistry.ayeracoBeamRed, BlockRegistry.ayeracoBeamYellow).build(null);
        STATUE = TileEntityType.Builder.of(() -> new TileEntityStatue(), BlockRegistry.ancientEntityStatue, BlockRegistry.sunstorm_statue, BlockRegistry.termasect_statue).build(null);
        SINGLE_SPAWNER = TileEntityType.Builder.of(() -> new TileEntitySingleUseSpawner(), BlockRegistry.sunstormSpawner, BlockRegistry.termasectSpawner, BlockRegistry.eternalArcherSpawner, BlockRegistry.experiencedCoriSpawner).build(null);
        BONE_CHEST = TileEntityType.Builder.of(() -> new TileEntityBoneChest(), BlockRegistry.boneChest).build(null);



        event.getRegistry().registerAll(
                ALTAR_OF_CORRUPTION.setRegistryName(DivineRPG.MODID, "altar_of_corruption"),
                NIGHTMARE_BED.setRegistryName(DivineRPG.MODID, "nightmare_bed"),
                AYERACO_SPAWN.setRegistryName(DivineRPG.MODID, "ayeraco_spawn"),
                AYERACO_BEAM.setRegistryName(DivineRPG.MODID, "ayeraco_beam"),
                STATUE.setRegistryName(DivineRPG.MODID, "statue"),
                SINGLE_SPAWNER.setRegistryName(DivineRPG.MODID, "single_spawner"),
                BONE_CHEST.setRegistryName(DivineRPG.MODID, "bone_chest")
        );
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void registerTileModels(final FMLClientSetupEvent event) {
        //TODO - Fix tile entity renderers
        ClientRegistry.bindTileEntityRenderer(ALTAR_OF_CORRUPTION, RenderAltarOfCorruption::new);
        ClientRegistry.bindTileEntityRenderer(NIGHTMARE_BED, RenderNightmareBed::new);
        ClientRegistry.bindTileEntityRenderer(STATUE, RenderStatue::new);
    }
}
