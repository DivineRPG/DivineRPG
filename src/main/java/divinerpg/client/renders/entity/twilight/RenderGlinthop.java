package divinerpg.client.renders.entity.twilight;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelGlinthop;
import divinerpg.entities.eden.EntityGlinthop;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGlinthop extends MobRenderer<EntityGlinthop, ModelGlinthop> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop.png");
    private static final ResourceLocation TEXTURE_ALT = new ResourceLocation(DivineRPG.MODID, "textures/entity/glinthop_alt.png");

    public RenderGlinthop(EntityRendererProvider.Context context) {
        super(context, new ModelGlinthop(context), 0.3F);
    }
    @Override
    public void render(EntityGlinthop glinthop, float p_115456_, float p_115457_, PoseStack poseStack, MultiBufferSource bufferSource, int p_115460_) {
        poseStack.translate(0, -0.1, 0);
        super.render(glinthop, p_115456_, p_115457_, poseStack, bufferSource, p_115460_);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityGlinthop entity) {
        if (entity.isSpecialAlt()) {
            return TEXTURE_ALT;
        } else {
            return TEXTURE;
        }
    }

}