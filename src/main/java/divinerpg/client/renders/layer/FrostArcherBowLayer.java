package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.client.models.vanilla.ModelAridWarrior;
import divinerpg.entities.iceika.EntityFrostArcher;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import divinerpg.registries.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.*;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FrostArcherBowLayer extends LayerRenderer<EntityFrostArcher, BipedModel<EntityFrostArcher>> {

    public FrostArcherBowLayer(IEntityRenderer<EntityFrostArcher, BipedModel<EntityFrostArcher>> entityRendererIn) {
        super(entityRendererIn);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityFrostArcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
    //TODO - lower bow
        matrixStackIn.push();
        ModelRenderer modelrenderer = this.getEntityModel().bipedRightArm;
        modelrenderer.translateRotate(matrixStackIn);
        matrixStackIn.translate(-0.0625F, 0.4375F, 0.0625F);
        matrixStackIn.translate(-0.125F, -0.14f, -0.02);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-90.0F));
//            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-45.0F));
        Minecraft.getInstance().getItemRenderer().renderItem(entitylivingbaseIn, ItemRegistry.icicleBow.getDefaultInstance(), ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.world, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F));

        matrixStackIn.pop();
    }
}