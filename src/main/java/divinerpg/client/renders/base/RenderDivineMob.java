package divinerpg.client.renders.base;


import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.base.EntityDivineMob;
import divinerpg.entities.vanilla.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineMob extends MobRenderer<MobEntity, SegmentedModel<MobEntity>> {
    private ResourceLocation TEXTURE;
    private float scaleFactor;

    public RenderDivineMob(EntityRendererManager renderManagerIn, SegmentedModel model, ResourceLocation TEXTURE) {
        super(renderManagerIn, model, 0.8F);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=1f;
    }
    public RenderDivineMob(EntityRendererManager renderManagerIn, SegmentedModel model, ResourceLocation TEXTURE, float shadowSize) {
        super(renderManagerIn, model, shadowSize);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=1f;
    }
    public RenderDivineMob(EntityRendererManager renderManagerIn, SegmentedModel model, float scaleFactor, ResourceLocation TEXTURE) {
        super(renderManagerIn, model, 0.8F);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=scaleFactor;
    }
    public RenderDivineMob(EntityRendererManager renderManagerIn, SegmentedModel model, float scaleFactor, ResourceLocation TEXTURE, float shadowSize) {
        super(renderManagerIn, model, shadowSize);
        this.TEXTURE = TEXTURE;
        this.scaleFactor=scaleFactor;
    }
    protected void preRenderCallback(MobEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(scaleFactor, scaleFactor, scaleFactor);
    }
    @Override
    public ResourceLocation getEntityTexture(MobEntity entity) {
        return TEXTURE;
    }
}