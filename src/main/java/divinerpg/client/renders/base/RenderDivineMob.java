package divinerpg.client.renders.base;


import com.mojang.blaze3d.matrix.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineMob extends MobRenderer<MobEntity, EntityModel<MobEntity>> {
    private ResourceLocation TEXTURE;
    private float scaleFactor;

    public RenderDivineMob(EntityRendererManager renderManagerIn, EntityModel model, ResourceLocation TEXTURE) {
        super(renderManagerIn, model, 0.8F);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=1f;
    }
    public RenderDivineMob(EntityRendererManager renderManagerIn, EntityModel model, ResourceLocation TEXTURE, float shadowSize) {
        super(renderManagerIn, model, shadowSize);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=1f;
    }
    public RenderDivineMob(EntityRendererManager renderManagerIn, EntityModel model, float scaleFactor, ResourceLocation TEXTURE) {
        super(renderManagerIn, model, 0.8F);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=scaleFactor;
    }
    public RenderDivineMob(EntityRendererManager renderManagerIn, EntityModel model, float scaleFactor, ResourceLocation TEXTURE, float shadowSize) {
        super(renderManagerIn, model, shadowSize);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=scaleFactor;
    }

    protected void scale(MobEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(scaleFactor, scaleFactor, scaleFactor);
    }


    @Override
    public ResourceLocation getTextureLocation(MobEntity entity) {
        return TEXTURE;
    }
}