package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.dimensions.apalachia.WorldProviderApalachia;
import naturix.divinerpg.dimensions.eden.WorldProviderEden;
import naturix.divinerpg.dimensions.wildwood.WorldProviderWildWood;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {
	public static DimensionType edenDimension;
	public static DimensionType wildWoodDimension;
	public static DimensionType apalachiaDimension;

	    public static void init() {
	        registerDimensionTypes();
	        registerDimensions();
	    }

	    private static void registerDimensionTypes() {
	    	edenDimension = DimensionType.register(DivineRPG.modId + ":eden", "_eden", Config.edenDimensionId, WorldProviderEden.class, false);
	    	wildWoodDimension = DimensionType.register(DivineRPG.modId + ":wildwood", "_wildwood", Config.wildWoodDimensionId, WorldProviderWildWood.class, false);
	    	apalachiaDimension = DimensionType.register(DivineRPG.modId + ":apalachia", "_apalachia", Config.apalachiaDimensionId, WorldProviderApalachia.class, false);
		    }

	    private static void registerDimensions() {
	        DimensionManager.registerDimension(Config.edenDimensionId, edenDimension);
	        DimensionManager.registerDimension(Config.wildWoodDimensionId, wildWoodDimension);
	        DimensionManager.registerDimension(Config.apalachiaDimensionId, apalachiaDimension);
		    }
	}