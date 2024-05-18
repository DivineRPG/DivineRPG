package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.EntityDivineArrow;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineArrow extends ArrowRenderer<EntityDivineArrow> {
    public RenderDivineArrow(EntityRendererProvider.Context context) {super(context);}
    @Override public ResourceLocation getTextureLocation(EntityDivineArrow arrow) {return arrow.getTexture();}
}