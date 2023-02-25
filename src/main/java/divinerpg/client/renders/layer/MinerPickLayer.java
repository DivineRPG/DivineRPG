package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.renders.entity.vanilla.RenderMiner;
import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.Items;
import com.mojang.math.Vector3f;
import net.minecraftforge.api.distmarker.*;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.block.model.ItemTransforms;

@OnlyIn(Dist.CLIENT)
public class MinerPickLayer extends RenderLayer<EntityMiner, HumanoidModel<EntityMiner>> {
    public MinerPickLayer(RenderMiner p_i50935_1_) {
        super(p_i50935_1_);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityMiner entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStackIn.pushPose();
        ModelPart modelrenderer = this.getParentModel().rightArm;
        modelrenderer.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(-0.0625F, 0.55F, -0.4F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(55));
        matrixStackIn.mulPose(Vector3f.YN.rotationDegrees(-25));
        matrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(45));
        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, Items.GOLDEN_PICKAXE.getDefaultInstance(), ItemTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), packedLightIn);

        matrixStackIn.popPose();
    }
}