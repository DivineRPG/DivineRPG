package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.block_entities.block.RobbinNestBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;


public class RenderRobbinNest implements BlockEntityRenderer<RobbinNestBlockEntity> {
	public RenderRobbinNest(BlockEntityRendererProvider.Context context) {}
	@Override
	public void render(RobbinNestBlockEntity blockEntity, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		if(!blockEntity.getItem().isEmpty()) {
			matrixStackIn.pushPose();
			matrixStackIn.translate(.5F, .25F, .5F);
			Minecraft.getInstance().getItemRenderer().renderStatic(blockEntity.getItem(), ItemDisplayContext.GROUND, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, null, 0);
			matrixStackIn.popPose();
		}
	}
}
