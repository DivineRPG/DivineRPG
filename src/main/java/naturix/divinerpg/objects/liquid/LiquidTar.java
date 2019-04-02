package naturix.divinerpg.objects.liquid;

import naturix.divinerpg.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class LiquidTar extends Fluid {
    public static final ResourceLocation TAR = new ResourceLocation(Reference.MODID, "blocks/tar");

    public LiquidTar() {
	super("tar", TAR, TAR);
    }
}
