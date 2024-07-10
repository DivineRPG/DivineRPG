package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.renders.entity.vanilla.RenderJackOMan;
import divinerpg.entities.vanilla.overworld.EntityJackOMan;
import divinerpg.registries.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class JackOManScytheLayer extends RenderLayer<EntityJackOMan, HumanoidModel<EntityJackOMan>> {
    public JackOManScytheLayer(RenderJackOMan render) {
        super(render);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityJackOMan entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        ModelPart parentModel = this.getParentModel().rightArm;
        parentModel.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(-0.0625F, 0.55F, -0.4F);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(55));
        matrixStackIn.mulPose(Axis.YN.rotationDegrees(-25));
        matrixStackIn.mulPose(Axis.ZN.rotationDegrees(45));
        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ItemRegistry.scythe.get().getDefaultInstance(), ItemDisplayContext.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 0);

        matrixStackIn.popPose();
    }
}