package divinerpg.util;

import divinerpg.DivineRPG;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ClientUtils {
    public static final ModelLayerLocation createLocation(String name) {
        return new ModelLayerLocation(new ResourceLocation(DivineRPG.MODID, name), "main");
    }
    public static final ModelLayerLocation
            layerHumanoid = createLocation("humanoid"),
            layerBat = createLocation("bat"),
            layerPig = createLocation("pig"),
            layerSpider = createLocation("spider");
}
