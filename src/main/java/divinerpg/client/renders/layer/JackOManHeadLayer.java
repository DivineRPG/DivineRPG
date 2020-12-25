package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.client.renders.entity.vanilla.ModelJackOMan;
import divinerpg.entities.vanilla.overworld.EntityJackOMan;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class JackOManHeadLayer extends LayerRenderer<EntityJackOMan, ModelJackOMan<EntityJackOMan>> {
    public JackOManHeadLayer(IEntityRenderer<EntityJackOMan, ModelJackOMan<EntityJackOMan>> p_i50922_1_) {
        super(p_i50922_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityJackOMan entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entitylivingbaseIn.isInvisible()) {
            matrixStackIn.push();
            float f = 0.625F;
            matrixStackIn.translate(0.0D, -0.34375D, 0.0D);
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
            matrixStackIn.scale(0.625F, -0.625F, -0.625F);
            ItemStack itemstack = new ItemStack(Blocks.CARVED_PUMPKIN);
            Minecraft.getInstance().getItemRenderer().renderItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.HEAD, false, matrixStackIn, bufferIn, entitylivingbaseIn.world, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F));
            matrixStackIn.pop();
        }
    }
}
