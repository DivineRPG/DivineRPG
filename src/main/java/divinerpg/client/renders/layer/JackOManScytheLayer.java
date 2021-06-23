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


    //TODO - fix rotation on jack o mans scythe
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityJackOMan entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(-0.0625F, 0.4375F, 0.0625F);
        matrixStackIn.translate(0, 0, -0.3);
        matrixStackIn.mulPose(Vector3f.XP.rotation(-90));
        matrixStackIn.mulPose(Vector3f.ZN.rotation(45));
        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.scythe.getDefaultInstance(), ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F));

        matrixStackIn.popPose();
    }
}