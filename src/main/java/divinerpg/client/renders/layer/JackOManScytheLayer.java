package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.entity.vanilla.*;
import divinerpg.entities.vanilla.overworld.*;
import divinerpg.registries.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.util.math.vector.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class JackOManScytheLayer extends LayerRenderer<EntityJackOMan, ModelJackOMan<EntityJackOMan>> {
    public JackOManScytheLayer(RenderJackOMan p_i50935_1_) {
        super(p_i50935_1_);
    }

    //TODO - jack o man scythe not perfect and could be better rotated but i think its ok
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityJackOMan entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        ModelRenderer parentModel = this.getParentModel().RightArm;
        parentModel.translateAndRotate(matrixStackIn);
        matrixStackIn.mulPose(Vector3f.XP.rotation(0));
        matrixStackIn.mulPose(Vector3f.YP.rotation(45));
        matrixStackIn.mulPose(Vector3f.ZP.rotation(-25));
        matrixStackIn.translate(0.2F, 0.4375F, 0);
        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.scythe.getDefaultInstance(), ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F));

        matrixStackIn.popPose();
    }
}