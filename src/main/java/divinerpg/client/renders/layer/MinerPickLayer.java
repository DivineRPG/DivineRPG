package divinerpg.client.renders.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.entity.vanilla.RenderMiner;
import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.*;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MinerPickLayer extends LayerRenderer<EntityMiner, ModelMiner<EntityMiner>> {
    public MinerPickLayer(RenderMiner p_i50935_1_) {
        super(p_i50935_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityMiner entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        matrixStackIn.push();
        ModelRenderer modelrenderer = this.getEntityModel().RightArm;
        modelrenderer.translateRotate(matrixStackIn);
        matrixStackIn.translate(-0.0625F, 0.8375F, -0.2F);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-270.0F));
        Minecraft.getInstance().getItemRenderer().renderItem(entitylivingbaseIn, Items.GOLDEN_PICKAXE.getDefaultInstance(), ItemCameraTransforms.TransformType.NONE, false, matrixStackIn, bufferIn, entitylivingbaseIn.world, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F));

        matrixStackIn.pop();
    }
}