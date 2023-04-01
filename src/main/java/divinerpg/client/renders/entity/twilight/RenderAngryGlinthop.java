package divinerpg.client.renders.entity.twilight;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelAngryGlinthop;
import divinerpg.entities.mortum.EntityAngryGlinthop;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderAngryGlinthop extends MobRenderer<EntityAngryGlinthop, ModelAngryGlinthop<EntityAngryGlinthop>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop_angry.png");

    public RenderAngryGlinthop(EntityRendererProvider.Context context) {
        super(context, new ModelAngryGlinthop<>(context), 0.3F);
    }
    @Override
    public void render(EntityAngryGlinthop glinthop, float p_115456_, float p_115457_, PoseStack poseStack, MultiBufferSource bufferSource, int p_115460_) {
        poseStack.translate(0, -0.05, 0);
        super.render(glinthop, p_115456_, p_115457_, poseStack, bufferSource, p_115460_);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityAngryGlinthop entity) {
        return TEXTURE;
    }

}