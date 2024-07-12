package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.entities.vanilla.overworld.EntityJackOMan;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class JackOManHeadLayer extends RenderLayer<EntityJackOMan, HumanoidModel<EntityJackOMan>> {
    public JackOManHeadLayer(RenderLayerParent<EntityJackOMan, HumanoidModel<EntityJackOMan>> p_i50922_1_) {
        super(p_i50922_1_);
    }

    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityJackOMan entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.isInvisible()) {
            matrixStackIn.pushPose();
//            float f = 0.625F;
            matrixStackIn.translate(0.0D, -0.34375D, 0.0D);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0F));
            matrixStackIn.scale(0.625F, -0.625F, -0.625F);
            ItemStack itemstack = new ItemStack(Blocks.CARVED_PUMPKIN);
            Minecraft.getInstance().getItemRenderer().renderStatic(entitylivingbaseIn, itemstack, ItemDisplayContext.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.level(), packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), 0);
            matrixStackIn.popPose();
        }
    }
}
