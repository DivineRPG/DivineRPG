package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.entity.vanilla.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.registries.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.*;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class JackOManScytheLayer extends LayerRenderer<EntityJackOMan, ModelJackOMan<EntityJackOMan>> {
    public JackOManScytheLayer(RenderJackOMan p_i50935_1_) {
        super(p_i50935_1_);
    }


    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityJackOMan entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        ModelRenderer modelrenderer = getParentModel().LeftArm;
        ModelRenderer modelrenderer1 = getParentModel().RightArm;
        modelrenderer.translateAndRotate(matrixStackIn);
        modelrenderer1.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(-0.4625F, 0.8375F, -0.2F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-270.0F));
        matrixStackIn.translate(0, -0.25, 0.0675);
        boolean leftHanded = false;
        if(entitylivingbaseIn.level.random.nextInt(10)>9){
            leftHanded=true;
        }
        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.scythe.getDefaultInstance(), ItemCameraTransforms.TransformType.NONE, leftHanded, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F));

        matrixStackIn.popPose();
    }
}