package divinerpg.registry;

import divinerpg.api.Reference;
import divinerpg.config.MainConfig;
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
import divinerpg.structure.template.DivineStructureComponentTemplate;
import divinerpg.structure.template.DivineStructureStart;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {
    public static DimensionType edenDimension;
    public static DimensionType wildWoodDimension;
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
        MapGenStructureIO.registerStructure(DivineStructureStart.class, "DrpgSS");
        MapGenStructureIO.registerStructureComponent(DivineStructureComponentTemplate.class, "DrpgCmp");

        MapGenStructureIO.registerStructure(DivineLegacyStructureStart.class, "DrpgLegacySS");
        MapGenStructureIO.registerStructureComponent(DivineStructureComponent.class, "DrpgLegacyCmp");
    }

    private static void registerDimensionTypes() {
        edenDimension = DimensionType.register(Reference.MODID + ":eden", "_eden", MainConfig.dimensionIDs.edenDimensionID,
                WorldProviderEden.class, false);
        wildWoodDimension = DimensionType.register(Reference.MODID + ":wildwood", "_wildwood",
                MainConfig.dimensionIDs.wildwoodDimensionID, WorldProviderWildWood.class, false);
        apalachiaDimension = DimensionType.register(Reference.MODID + ":apalachia", "_apalachia",
                MainConfig.dimensionIDs.apalachiaDimensionID, WorldProviderApalachia.class, false);
        skythernDimension = DimensionType.register(Reference.MODID + ":skythern", "_skythern",
                MainConfig.dimensionIDs.skythernDimensionID, WorldProviderSkythern.class, false);
        mortumDimension = DimensionType.register(Reference.MODID + ":mortum", "_mortum", MainConfig.dimensionIDs.mortumDimensionID,
                WorldProviderMortum.class, false);
        iceikaDimension = DimensionType.register(Reference.MODID + ":iceika", "_iceika", MainConfig.dimensionIDs.iceikaDimensionID,
                WorldProviderIceika.class, false);
        arcanaDimension = DimensionType.register(Reference.MODID + ":arcana", "_arcana", MainConfig.dimensionIDs.arcanaDimensionID,
                WorldProviderArcana.class, false);
        vetheaDimension = DimensionType.register(Reference.MODID + ":vethea", "_vethea", MainConfig.dimensionIDs.vetheaDimensionID, 
        		VetheaWorldProvider.class, false); //VetheaWorldProvider = new, WorldProviderVethea = old
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(MainConfig.dimensionIDs.edenDimensionID, edenDimension);
        DimensionManager.registerDimension(MainConfig.dimensionIDs.wildwoodDimensionID, wildWoodDimension);
        DimensionManager.registerDimension(MainConfig.dimensionIDs.apalachiaDimensionID, apalachiaDimension);
        DimensionManager.registerDimension(MainConfig.dimensionIDs.skythernDimensionID, skythernDimension);
        DimensionManager.registerDimension(MainConfig.dimensionIDs.mortumDimensionID, mortumDimension);
        DimensionManager.registerDimension(MainConfig.dimensionIDs.iceikaDimensionID, iceikaDimension);
        DimensionManager.registerDimension(MainConfig.dimensionIDs.arcanaDimensionID, arcanaDimension);
        DimensionManager.registerDimension(MainConfig.dimensionIDs.vetheaDimensionID, vetheaDimension);
    }
}