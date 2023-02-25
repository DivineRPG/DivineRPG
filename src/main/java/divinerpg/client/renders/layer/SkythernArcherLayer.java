package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelTwilightArcher;
import divinerpg.entities.skythern.EntitySkythernArcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(Dist.CLIENT)
public class SkythernArcherLayer extends RenderLayer<EntitySkythernArcher, ModelTwilightArcher<EntitySkythernArcher>> {

    public SkythernArcherLayer(RenderLayerParent<EntitySkythernArcher, ModelTwilightArcher<EntitySkythernArcher>> parent) {
        super(parent);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntitySkythernArcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStackIn.pushPose();
        ModelPart modelrenderer = this.getParentModel().rightarm;
        modelrenderer.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(-0.5F, 0.80F, -0.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(55));
        matrixStackIn.mulPose(Vector3f.YN.rotationDegrees(-20));
        matrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(45));

        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_bow")).getDefaultInstance(), ItemTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 0);

        matrixStackIn.popPose();
    }
}