package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelBoneChest;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderBoneChestItem extends BlockEntityWithoutLevelRenderer {
    private final ModelBoneChest<?> model;

    public RenderBoneChestItem(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ModelBoneChest<>(set.bakeLayer(ModelBoneChest.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, transformType, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "bone_chest")).asItem()) {
            matrixStack.pushPose();
            matrixStack.translate(0.0, 1.0, 0.0);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
            matrixStack.mulPose(Axis.XP.rotationDegrees(180));
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/bone_chest.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }

    }

}
