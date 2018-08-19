package naturix.divinerpg.utils.entity;

import naturix.divinerpg.DivineRPG;
import net.minecraft.util.ResourceLocation;

public class DRPGEntityNames {
	public static final ResourceLocation DRAMCRYX_JUNGLE = name("dramcryx_jungle");

    private static ResourceLocation name(String entityName) {
        return new ResourceLocation(DivineRPG.modId, entityName);
    }
}