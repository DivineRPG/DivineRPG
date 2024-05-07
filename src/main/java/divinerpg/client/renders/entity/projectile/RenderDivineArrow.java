package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.EntityDivineArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineArrow extends ArrowRenderer<EntityDivineArrow> {
    public RenderDivineArrow(Context context) {super(context);}
    @Override public ResourceLocation getTextureLocation(EntityDivineArrow arrow) {return arrow.getTexture();}
}