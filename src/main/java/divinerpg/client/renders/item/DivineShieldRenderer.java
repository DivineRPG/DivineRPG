package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import divinerpg.items.base.ItemDivineShield;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.*;

import static net.minecraft.client.model.geom.ModelLayers.SHIELD;

public class DivineShieldRenderer extends BlockEntityWithoutLevelRenderer {
    //TODO: to add custom models for non-rectangular shields
    private final ShieldModel model;
    public DivineShieldRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ShieldModel(set.bakeLayer(SHIELD));
    }
    @Override public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        super.renderByItem(stack, context, poseStack, buffer, packedLight, packedOverlay);
        Item item = stack.getItem();
        if(item instanceof ItemDivineShield) {
            poseStack.pushPose();
            poseStack.scale(1, -1, -1);
            Material material = new Material(Sheets.SHIELD_SHEET, ((ItemDivineShield)item).resource);
            VertexConsumer vertexConsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(buffer,  RenderType.entityCutout(material.atlasLocation()), true, stack.hasFoil()));
            model.handle().render(poseStack, vertexConsumer, packedLight, packedOverlay);
            model.plate().render(poseStack, vertexConsumer, packedLight, packedOverlay);
            poseStack.popPose();
        }
    }
}