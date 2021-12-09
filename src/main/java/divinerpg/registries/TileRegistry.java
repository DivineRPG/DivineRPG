package divinerpg.registries;

import divinerpg.*;
import divinerpg.tiles.*;
import divinerpg.tiles.block.*;
import divinerpg.tiles.bosses.*;
import divinerpg.tiles.chests.*;
import divinerpg.tiles.furnace.*;
import divinerpg.tiles.spawner.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DivineRPG.MODID)
public class TileRegistry {

    public static TileEntityType<AltarOfCorruptionEntity> ALTAR_OF_CORRUPTION;
    public static TileEntityType<TileEntityNightmareBed> NIGHTMARE_BED;
    public static TileEntityType<TileEntityAyeracoSpawn> AYERACO_SPAWN;
    public static TileEntityType<TileEntityAyeracoBeam> AYERACO_BEAM;
    public static  TileEntityType<TileEntityStatue> STATUE;
    public static  TileEntityType<TileEntitySingleUseSpawner> SINGLE_SPAWNER;
    public static  TileEntityType<TileEntitySpawner> SPAWNER;
    public static  TileEntityType<TileEntityBoneChest> BONE_CHEST;
    public static  TileEntityType<TileEntityFrostedChest> FROSTED_CHEST;
    public static  TileEntityType<TileEntityEdenChest> EDEN_CHEST;
    public static  TileEntityType<TileEntityPresentBox> PRESENT_BOX;
//    public static  TileEntityType<PortalEntity> ARCANA_PORTAL;
    public static  TileEntityType<TileEntityCoalstoneFurnace> COALSTONE_FURNACE;
    public static  TileEntityType<TileEntityDemonFurnace> DEMON_FURNACE;
    public static  TileEntityType<TileEntityGreenlightFurnace> GREENLIGHT_FURNACE;
    public static  TileEntityType<TileEntityOceanfireFurnace> OCEANFIRE_FURNACE;
    public static  TileEntityType<TileEntityMoltenFurnace> MOLTEN_FURNACE;
    public static  TileEntityType<TileEntityWhitefireFurnace> WHITEFIRE_FURNACE;
    public static  TileEntityType<TileEntityMoonlightFurnace> MOONLIGHT_FURNACE;
    public static  TileEntityType<TileEntityArcaniumExtractor> ARCANIUM_EXTRACTOR;
    public static  TileEntityType<TileEntityParasectaAltar> PARASECTA_ALTAR;
    public static  TileEntityType<TileEntityDramixAltar> DRAMIX_ALTAR;
    public static  TileEntityType<TileEntityDreamLamp> DREAM_LAMP;
    public static  TileEntityType<TileEntityInfusionTable> INFUSION_TABLE;
    public static  TileEntityType<TileEntitySingleMobSpawner> ARCANA_SPAWNER;
    public static  TileEntityType<TileEntityStructureAir> STRUCTURE_AIR;

    @SubscribeEvent
    public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event) {
        DivineRPG.LOGGER.info("[DivineRPG] Registered tile entities");
        ALTAR_OF_CORRUPTION = TileEntityType.Builder.of(() -> new AltarOfCorruptionEntity(ALTAR_OF_CORRUPTION), BlockRegistry.altarOfCorruption).build(null);
        NIGHTMARE_BED = TileEntityType.Builder.of(() -> new TileEntityNightmareBed(NIGHTMARE_BED), BlockRegistry.nightmareBed).build(null);
        AYERACO_SPAWN = TileEntityType.Builder.of(() -> new TileEntityAyeracoSpawn(), BlockRegistry.ayeracoSpawn).build(null);
        AYERACO_BEAM = TileEntityType.Builder.of(() -> new TileEntityAyeracoBeam(), BlockRegistry.ayeracoBeamBlue, BlockRegistry.ayeracoBeamGreen, BlockRegistry.ayeracoBeamPurple, BlockRegistry.ayeracoBeamRed, BlockRegistry.ayeracoBeamYellow).build(null);
        STATUE = TileEntityType.Builder.of(() -> new TileEntityStatue(), BlockRegistry.ancientEntityStatue, BlockRegistry.ayeracoBlueStatue, BlockRegistry.ayeracoRedStatue, BlockRegistry.ayeracoYellowStatue, BlockRegistry.ayeracoGreenStatue, BlockRegistry.ayeracoPurpleStatue, BlockRegistry.densosStatue, BlockRegistry.dramixStatue, BlockRegistry.eternalArcherStatue, BlockRegistry.karotStatue, BlockRegistry.kingOfScorchersStatue, BlockRegistry.parasectaStatue, BlockRegistry.reyvorStatue, BlockRegistry.soulFiendStatue, BlockRegistry.theWatcherStatue, BlockRegistry.twilightDemonStatue, BlockRegistry.vamacheronStatue, BlockRegistry.termasect_statue, BlockRegistry.sunstorm_statue, BlockRegistry.experienced_cori_statue).build(null);
        SINGLE_SPAWNER = TileEntityType.Builder.of(() -> new TileEntitySingleUseSpawner(), BlockRegistry.sunstormSpawner, BlockRegistry.termasectSpawner, BlockRegistry.eternalArcherSpawner, BlockRegistry.experiencedCoriSpawner).build(null);
        SPAWNER = TileEntityType.Builder.of(() -> new TileEntitySpawner(), BlockRegistry.frostArcherSpawner, BlockRegistry.rollumSpawner, BlockRegistry.gorgosionSpawner, BlockRegistry.twinsSpawner, BlockRegistry.vermenousSpawner, BlockRegistry.twinsSpawner, BlockRegistry.dreamwreckerSpawner, BlockRegistry.biphronSpawner).build(null);
        BONE_CHEST = TileEntityType.Builder.of(() -> new TileEntityBoneChest(), BlockRegistry.boneChest).build(null);
        FROSTED_CHEST = TileEntityType.Builder.of(() -> new TileEntityFrostedChest(), BlockRegistry.frostedChest).build(null);
        EDEN_CHEST = TileEntityType.Builder.of(() -> new TileEntityEdenChest(), BlockRegistry.edenChest).build(null);
        PRESENT_BOX = TileEntityType.Builder.of(() -> new TileEntityPresentBox(), BlockRegistry.presentBox).build(null);
        COALSTONE_FURNACE = TileEntityType.Builder.of(() -> new TileEntityCoalstoneFurnace(), BlockRegistry.coalstoneFurnace).build(null);
        DEMON_FURNACE = TileEntityType.Builder.of(() -> new TileEntityDemonFurnace(), BlockRegistry.demonFurnace).build(null);
        GREENLIGHT_FURNACE = TileEntityType.Builder.of(() -> new TileEntityGreenlightFurnace(), BlockRegistry.greenlightFurnace).build(null);
        OCEANFIRE_FURNACE = TileEntityType.Builder.of(() -> new TileEntityOceanfireFurnace(), BlockRegistry.oceanfireFurnace).build(null);
        MOLTEN_FURNACE = TileEntityType.Builder.of(() -> new TileEntityMoltenFurnace(), BlockRegistry.moltenFurnace).build(null);
        WHITEFIRE_FURNACE = TileEntityType.Builder.of(() -> new TileEntityWhitefireFurnace(), BlockRegistry.whitefireFurnace).build(null);
        MOONLIGHT_FURNACE = TileEntityType.Builder.of(() -> new TileEntityMoonlightFurnace(), BlockRegistry.moonlightFurnace).build(null);
        ARCANIUM_EXTRACTOR = TileEntityType.Builder.of(() -> new TileEntityArcaniumExtractor(), BlockRegistry.arcaniumExtractor).build(null);
        PARASECTA_ALTAR = TileEntityType.Builder.of(() -> new TileEntityParasectaAltar(), BlockRegistry.parasectaAltar).build(null);
        DRAMIX_ALTAR = TileEntityType.Builder.of(() -> new TileEntityDramixAltar(), BlockRegistry.dramixAltar).build(null);
        DREAM_LAMP = TileEntityType.Builder.of(() -> new TileEntityDreamLamp(), BlockRegistry.dreamLamp).build(null);
        INFUSION_TABLE = TileEntityType.Builder.of(() -> new TileEntityInfusionTable(), BlockRegistry.infusionTable).build(null);
        ARCANA_SPAWNER = TileEntityType.Builder.of(() -> new TileEntitySingleMobSpawner(), BlockRegistry.captainMerikSpawner, BlockRegistry.datticonSpawner, BlockRegistry.kazariSpawner, BlockRegistry.leornaSpawner, BlockRegistry.lordVatticusSpawner, BlockRegistry.warGeneralSpawner, BlockRegistry.zelusSpawner, BlockRegistry.hungerSpawnerLS, BlockRegistry.hungerSpawnerSG).build(null);
        STRUCTURE_AIR = TileEntityType.Builder.of(() -> new TileEntityStructureAir(), BlockRegistry.structureAir).build(null);



        event.getRegistry().registerAll(
                ALTAR_OF_CORRUPTION.setRegistryName(DivineRPG.MODID, "altar_of_corruption"),
                NIGHTMARE_BED.setRegistryName(DivineRPG.MODID, "nightmare_bed"),
                AYERACO_SPAWN.setRegistryName(DivineRPG.MODID, "ayeraco_spawn"),
                AYERACO_BEAM.setRegistryName(DivineRPG.MODID, "ayeraco_beam"),
                STATUE.setRegistryName(DivineRPG.MODID, "statue"),
                SINGLE_SPAWNER.setRegistryName(DivineRPG.MODID, "single_spawner"),
                SPAWNER.setRegistryName(DivineRPG.MODID, "spawner"),
                BONE_CHEST.setRegistryName(DivineRPG.MODID, "bone_chest"),
                FROSTED_CHEST.setRegistryName(DivineRPG.MODID, "frosted_chest"),
                EDEN_CHEST.setRegistryName(DivineRPG.MODID, "eden_chest"),
                PRESENT_BOX.setRegistryName(DivineRPG.MODID, "present_box"),
                COALSTONE_FURNACE.setRegistryName(DivineRPG.MODID, "coalstone_furnace"),
                DEMON_FURNACE.setRegistryName(DivineRPG.MODID, "demon_furnace"),
                GREENLIGHT_FURNACE.setRegistryName(DivineRPG.MODID, "greenlight_furnace"),
                OCEANFIRE_FURNACE.setRegistryName(DivineRPG.MODID, "oceanfire_furnace"),
                MOLTEN_FURNACE.setRegistryName(DivineRPG.MODID, "molten_furnace"),
                WHITEFIRE_FURNACE.setRegistryName(DivineRPG.MODID, "whitefire_furnace"),
                MOONLIGHT_FURNACE.setRegistryName(DivineRPG.MODID, "moonlight_furnace"),
                ARCANIUM_EXTRACTOR.setRegistryName(DivineRPG.MODID, "arcanium_extractor"),
                PARASECTA_ALTAR.setRegistryName(DivineRPG.MODID, "parasecta_altar"),
                DRAMIX_ALTAR.setRegistryName(DivineRPG.MODID, "dramix_altar"),
                DREAM_LAMP.setRegistryName(DivineRPG.MODID, "dream_lamp"),
                INFUSION_TABLE.setRegistryName(DivineRPG.MODID, "infusion_table"),
                ARCANA_SPAWNER.setRegistryName(DivineRPG.MODID, "arcana_spawner"),
                STRUCTURE_AIR.setRegistryName(DivineRPG.MODID, "structure_air")
        );
    }

}
