package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelDemonFurnace;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderDemonFurnaceItem extends BlockEntityWithoutLevelRenderer {
    private final ModelDemonFurnace<?> model;

    public RenderDemonFurnaceItem(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ModelDemonFurnace<>(set.bakeLayer(ModelDemonFurnace.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, transformType, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "demon_furnace")).asItem()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5, 0.5, 0.5);
            matrixStack.mulPose(Axis.YP.rotationDegrees(270));
            matrixStack.mulPose(Axis.YN.rotationDegrees(270));
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/demon_furnace.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }

    }

}
