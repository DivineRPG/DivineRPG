package divinerpg.registry;

import divinerpg.api.Reference;
import divinerpg.config.Config;
import divinerpg.dimensions.apalachia.WorldProviderApalachia;
import divinerpg.dimensions.arcana.WorldProviderArcana;
import divinerpg.dimensions.eden.WorldProviderEden;
import divinerpg.dimensions.iceika.WorldProviderIceika;
import divinerpg.dimensions.mortum.WorldProviderMortum;
import divinerpg.dimensions.skythern.WorldProviderSkythern;
import divinerpg.dimensions.vethea.WorldProviderVethea;
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
        edenDimension = DimensionType.register(Reference.MODID + ":eden", "_eden", Config.edenDimensionId,
                WorldProviderEden.class, false);
        wildWoodDimension = DimensionType.register(Reference.MODID + ":wildwood", "_wildwood",
                Config.wildWoodDimensionId, WorldProviderWildWood.class, false);
        apalachiaDimension = DimensionType.register(Reference.MODID + ":apalachia", "_apalachia",
                Config.apalachiaDimensionId, WorldProviderApalachia.class, false);
        skythernDimension = DimensionType.register(Reference.MODID + ":skythern", "_skythern",
                Config.skythernDimensionId, WorldProviderSkythern.class, false);
        mortumDimension = DimensionType.register(Reference.MODID + ":mortum", "_mortum", Config.mortumDimensionId,
                WorldProviderMortum.class, false);
        iceikaDimension = DimensionType.register(Reference.MODID + ":iceika", "_iceika", Config.iceikaDimensionId,
                WorldProviderIceika.class, false);
        arcanaDimension = DimensionType.register(Reference.MODID + ":arcana", "_arcana", Config.arcanaDimensionId,
                WorldProviderArcana.class, false);
        vetheaDimension = DimensionType.register(Reference.MODID + ":vethea", "_vethea", Config.vetheaDimensionId, 
        		WorldProviderVethea.class, false);
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(Config.edenDimensionId, edenDimension);
        DimensionManager.registerDimension(Config.wildWoodDimensionId, wildWoodDimension);
        DimensionManager.registerDimension(Config.apalachiaDimensionId, apalachiaDimension);
        DimensionManager.registerDimension(Config.skythernDimensionId, skythernDimension);
        DimensionManager.registerDimension(Config.mortumDimensionId, mortumDimension);
        DimensionManager.registerDimension(Config.iceikaDimensionId, iceikaDimension);
        DimensionManager.registerDimension(Config.arcanaDimensionId, arcanaDimension);
        DimensionManager.registerDimension(Config.vetheaDimensionId, vetheaDimension);
    }
}