package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.EntityDivineArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

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
