package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.config.GeneralConfig;
import divinerpg.dimensions.apalachia.WorldProviderApalachia;
import divinerpg.dimensions.arcana.WorldProviderArcana;
import divinerpg.dimensions.eden.WorldProviderEden;
import divinerpg.dimensions.iceika.WorldProviderIceika;
import divinerpg.dimensions.mortum.WorldProviderMortum;
import divinerpg.dimensions.skythern.WorldProviderSkythern;
import divinerpg.dimensions.vethea.VetheaWorldProvider;
import divinerpg.dimensions.wildwood.WorldProviderWildWood;
import divinerpg.structure.legacy.DivineLegacyStructureStart;
import divinerpg.structure.legacy.DivineStructureComponent;
import divinerpg.structure.base.DivineStructureComponentTemplate;
import divinerpg.structure.base.DivineStructureStart;
import divinerpg.structure.vethea.crypt1.Crypt1Component;
import divinerpg.structure.vethea.crypt1.Crypt1Start;
import divinerpg.structure.vethea.crypt2.Crypt2Component;
import divinerpg.structure.vethea.crypt2.Crypt2Start;
import divinerpg.structure.vethea.evergarden.EvergardenComponent;
import divinerpg.structure.vethea.evergarden.EvergardenStart;
import divinerpg.structure.vethea.karosmadhouse.KarosMadhouse;
import divinerpg.structure.vethea.karosmadhouse.KarosMadhouseComponent;
import divinerpg.structure.vethea.karosmadhouse.KarosMadhouseStart;
import divinerpg.structure.vethea.quadroticpost.QuadroticPostComponent;
import divinerpg.structure.vethea.quadroticpost.QuadroticPostStart;
import divinerpg.structure.vethea.raglokchamber.RaglokChamberComponent;
import divinerpg.structure.vethea.raglokchamber.RaglokChamberStart;
import divinerpg.structure.vethea.wreckhall.WreckHallComponent;
import divinerpg.structure.vethea.wreckhall.WreckHallStart;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry {
    public static DimensionType edenDimension;
    public static DimensionType wildwoodDimension;
    public static DimensionType apalachiaDimension;
    public static DimensionType skythernDimension;
    public static DimensionType mortumDimension;
    public static DimensionType iceikaDimension;
    public static DimensionType arcanaDimension;
    public static DimensionType vetheaDimension;

    public static void init() {
        registerStructures();
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerStructures() {

        MapGenStructureIO.registerStructure(Crypt1Start.class, "DRPGCrypt1");
        MapGenStructureIO.registerStructureComponent(Crypt1Component.class, "DRPGCrypt1Component");
        MapGenStructureIO.registerStructure(Crypt2Start.class, "DRPGCrypt2");
        MapGenStructureIO.registerStructureComponent(Crypt2Component.class, "DRPGCrypt2Component");
        MapGenStructureIO.registerStructure(QuadroticPostStart.class, "DRPGQuadroticPost");
        MapGenStructureIO.registerStructureComponent(QuadroticPostComponent.class, "DRPGQuadroticPostComponent");
        MapGenStructureIO.registerStructure(KarosMadhouseStart.class, "DRPGKarosMadhouse");
        MapGenStructureIO.registerStructureComponent(KarosMadhouseComponent.class, "DRPGKarosMadhouseComponent");
        MapGenStructureIO.registerStructure(WreckHallStart.class, "DRPGWreckHall");
        MapGenStructureIO.registerStructureComponent(WreckHallComponent.class, "DRPGWreckHallComponent");
        MapGenStructureIO.registerStructure(RaglokChamberStart.class, "DRPGRaglokChamber");
        MapGenStructureIO.registerStructureComponent(RaglokChamberComponent.class, "DRPGRaglokChamberComponent");
        MapGenStructureIO.registerStructure(EvergardenStart.class, "DRPGEvergarden");
        MapGenStructureIO.registerStructureComponent(EvergardenComponent.class, "DRPGEvergardenComponent");
        MapGenStructureIO.registerStructure(DivineLegacyStructureStart.class, "DrpgLegacySS");
        MapGenStructureIO.registerStructureComponent(DivineStructureComponent.class, "DrpgLegacyCmp");
    }

    private static void registerDimensionTypes() {
        edenDimension = DimensionType.register(DivineRPG.MODID + ":eden", "_eden", GeneralConfig.dimensionIDs.edenDimensionID,
                WorldProviderEden.class, false);
        wildwoodDimension = DimensionType.register(DivineRPG.MODID + ":wildwood", "_wildwood",
                GeneralConfig.dimensionIDs.wildwoodDimensionID, WorldProviderWildWood.class, false);
        apalachiaDimension = DimensionType.register(DivineRPG.MODID + ":apalachia", "_apalachia",
                GeneralConfig.dimensionIDs.apalachiaDimensionID, WorldProviderApalachia.class, false);
        skythernDimension = DimensionType.register(DivineRPG.MODID + ":skythern", "_skythern",
                GeneralConfig.dimensionIDs.skythernDimensionID, WorldProviderSkythern.class, false);
        mortumDimension = DimensionType.register(DivineRPG.MODID + ":mortum", "_mortum", GeneralConfig.dimensionIDs.mortumDimensionID,
                WorldProviderMortum.class, false);
        iceikaDimension = DimensionType.register(DivineRPG.MODID + ":iceika", "_iceika", GeneralConfig.dimensionIDs.iceikaDimensionID,
                WorldProviderIceika.class, false);
        arcanaDimension = DimensionType.register(DivineRPG.MODID + ":arcana", "_arcana", GeneralConfig.dimensionIDs.arcanaDimensionID,
                WorldProviderArcana.class, false);
        vetheaDimension = DimensionType.register(DivineRPG.MODID + ":vethea", "_vethea", GeneralConfig.dimensionIDs.vetheaDimensionID,
        		VetheaWorldProvider.class, false); //VetheaWorldProvider = new, WorldProviderVethea = old
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.edenDimensionID, edenDimension);
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.wildwoodDimensionID, wildwoodDimension);
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.apalachiaDimensionID, apalachiaDimension);
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.skythernDimensionID, skythernDimension);
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.mortumDimensionID, mortumDimension);
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.iceikaDimensionID, iceikaDimension);
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.arcanaDimensionID, arcanaDimension);
        DimensionManager.registerDimension(GeneralConfig.dimensionIDs.vetheaDimensionID, vetheaDimension);
    }
}