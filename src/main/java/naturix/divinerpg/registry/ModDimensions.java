package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.dimensions.WorldProviderEden;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {
	 public static DimensionType edenDimension;

	    public static void init() {
	        registerDimensionTypes();
	        registerDimensions();
	    }

	    private static void registerDimensionTypes() {
	        edenDimension = DimensionType.register(DivineRPG.modId, "_eden", Config.dimensionId, WorldProviderEden.class, false);
	    }

	    private static void registerDimensions() {
	        DimensionManager.registerDimension(Config.dimensionId, edenDimension);
	    }
	}