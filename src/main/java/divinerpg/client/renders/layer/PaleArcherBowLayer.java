package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelPaleArcher;
import divinerpg.entities.iceika.EntityPaleArcher;
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
public class PaleArcherBowLayer extends RenderLayer<EntityPaleArcher, ModelPaleArcher<EntityPaleArcher>> {

    public PaleArcherBowLayer(RenderLayerParent<EntityPaleArcher, ModelPaleArcher<EntityPaleArcher>> parent) {
        super(parent);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityPaleArcher entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();
        ModelPart modelrenderer = this.getParentModel().RightArm;
        modelrenderer.translateAndRotate(matrixStackIn);
        matrixStackIn.translate(0.0F, 0.58F, -0.0625F);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(55));
        matrixStackIn.mulPose(Axis.YN.rotationDegrees(-25));
        matrixStackIn.mulPose(Axis.ZN.rotationDegrees(45));
        matrixStackIn.scale(0.8F, 0.8F, 0.8F);
        Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle_bow")).getDefaultInstance(), ItemDisplayContext.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.5F), 0);

        matrixStackIn.popPose();
    }
}