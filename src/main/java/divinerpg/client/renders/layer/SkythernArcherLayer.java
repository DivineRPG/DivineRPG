package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.*;
import divinerpg.client.models.twilight.*;
import divinerpg.entities.skythern.*;
import divinerpg.registries.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.util.math.vector.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class SkythernArcherLayer extends LayerRenderer<EntitySkythernArcher, ModelTwilightArcher<EntitySkythernArcher>> {

    public SkythernArcherLayer(IEntityRenderer<EntitySkythernArcher, ModelTwilightArcher<EntitySkythernArcher>> p_i50926_1_) {
        super(p_i50926_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntitySkythernArcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStackIn.pushPose();
        ModelRenderer modelrenderer = this.getParentModel().rightarm;
        modelrenderer.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(-0.5F, 0.80F, -0.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(55));
        matrixStackIn.mulPose(Vector3f.YN.rotationDegrees(-20));
        matrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(45));

        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.twilightBow.getDefaultInstance(), ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F));

        matrixStackIn.popPose();
    }
}