package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelAridWarrior;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(Dist.CLIENT)
public class AridWarriorBowLayer extends RenderLayer<EntityAridWarrior, ModelAridWarrior<EntityAridWarrior>> {
    public AridWarriorBowLayer(RenderLayerParent<EntityAridWarrior, ModelAridWarrior<EntityAridWarrior>> p_i50935_1_) {
        super(p_i50935_1_);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityAridWarrior entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

            matrixStackIn.pushPose();
            ModelPart modelrenderer = this.getParentModel().rightarm2;
            modelrenderer.translateAndRotate(matrixStackIn);
            matrixStackIn.translate(-0.125F, 0.25F, -0.0F);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(55));
            matrixStackIn.mulPose(Axis.YN.rotationDegrees(-25));
            matrixStackIn.mulPose(Axis.ZN.rotationDegrees(45));
            Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_bow")).getDefaultInstance(), ItemDisplayContext.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level, packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 0);

            matrixStackIn.popPose();
    }
}