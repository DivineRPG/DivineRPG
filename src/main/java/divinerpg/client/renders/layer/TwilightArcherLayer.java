package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.twilight.ModelTwilightArcher;
import divinerpg.entities.mortum.EntityTwilightArcher;
import divinerpg.registries.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class TwilightArcherLayer extends RenderLayer<EntityTwilightArcher, ModelTwilightArcher<EntityTwilightArcher>> {

    public TwilightArcherLayer(RenderLayerParent<EntityTwilightArcher, ModelTwilightArcher<EntityTwilightArcher>> parent) {
        super(parent);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityTwilightArcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStackIn.pushPose();
        ModelPart modelrenderer = this.getParentModel().rightarm;
        modelrenderer.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(-0.5F, 0.80F, -0.0F);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(55));
        matrixStackIn.mulPose(Axis.YN.rotationDegrees(-20));
        matrixStackIn.mulPose(Axis.ZN.rotationDegrees(45));

        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.twilight_bow.get().getDefaultInstance(), ItemDisplayContext.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 0);

        matrixStackIn.popPose();
    }
}