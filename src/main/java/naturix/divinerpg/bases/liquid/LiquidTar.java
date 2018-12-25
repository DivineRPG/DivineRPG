package naturix.divinerpg.bases.liquid;

import naturix.divinerpg.DivineRPG;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class LiquidTar extends Fluid {

    public LiquidTar() {
        super("tar",
                new ResourceLocation(DivineRPG.modId, "blocks/tar_still"),
                new ResourceLocation(DivineRPG.modId, "blocks/tar_flow"));
    }

}