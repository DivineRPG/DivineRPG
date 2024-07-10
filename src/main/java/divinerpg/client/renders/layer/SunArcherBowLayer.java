package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.twilight.ModelSunArcher;
import divinerpg.entities.eden.EntitySunArcher;
import divinerpg.registries.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class SunArcherBowLayer extends RenderLayer<EntitySunArcher, ModelSunArcher<EntitySunArcher>> {
    public SunArcherBowLayer(RenderLayerParent<EntitySunArcher, ModelSunArcher<EntitySunArcher>> parent) {
        super(parent);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntitySunArcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        ModelPart modelrenderer = this.getParentModel().armRight;
        modelrenderer.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(-0.125F, 0.55F, -0.0F);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(55));
        matrixStackIn.mulPose(Axis.YN.rotationDegrees(-25));
        matrixStackIn.mulPose(Axis.ZN.rotationDegrees(45));
        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.eden_bow.get().getDefaultInstance(), ItemDisplayContext.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 0);

        matrixStackIn.popPose();
    }
}
