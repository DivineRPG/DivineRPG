package divinerpg.api.arcana;

import divinerpg.api.JavaHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Works with Arcana capability.
 */
public class ArcanaHelper {
    private static Capability<IArcana> capability;

    private static Capability<IArcana> getCapability() {
        if (capability == null) {
            capability = JavaHelper.getPublicStaticField("divinerpg.capabilities.ArcanaProvider", "ARCANA_CAP");
        }

        return capability;
    }

    public static IArcana getArcana(EntityPlayer player) {
        return player.getCapability(getCapability(), null);
    }
}
