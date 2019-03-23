package naturix.divinerpg.objects.liquid;

import naturix.divinerpg.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class LiquidTar extends Fluid {

	public LiquidTar() {
		super("tar", new ResourceLocation(Reference.MODID, "blocks/tar_still"),
		        new ResourceLocation(Reference.MODID, "blocks/tar_flow"));
	}

}