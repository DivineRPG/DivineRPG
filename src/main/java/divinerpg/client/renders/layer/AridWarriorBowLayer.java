package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.client.models.vanilla.ModelAridWarrior;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import divinerpg.registries.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.*;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AridWarriorBowLayer extends LayerRenderer<EntityAridWarrior, ModelAridWarrior<EntityAridWarrior>> {
    public AridWarriorBowLayer(IEntityRenderer<EntityAridWarrior, ModelAridWarrior<EntityAridWarrior>> p_i50935_1_) {
        super(p_i50935_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityAridWarrior entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

            matrixStackIn.pushPose();
            ModelRenderer modelrenderer = this.getParentModel().rightarmBS2;
            modelrenderer.translateAndRotate(matrixStackIn);
            matrixStackIn.translate(-0.0625F, 0.4375F, 0.0625F);
            matrixStackIn.translate(-0.125F, -0.14f, -0.02);
            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
//            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-45.0F));
            Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.shadowBow.getDefaultInstance(), ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F));

            matrixStackIn.popPose();
    }
}