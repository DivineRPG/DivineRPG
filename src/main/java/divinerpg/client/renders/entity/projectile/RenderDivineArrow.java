package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineArrow<T extends EntityDivineArrow> extends ArrowRenderer<T> {
    public RenderDivineArrow(Context context) {
        super(context);
    }
    @Override
    public ResourceLocation getTextureLocation(T arrow) {
    	return arrow.getTexture();
    }
}
