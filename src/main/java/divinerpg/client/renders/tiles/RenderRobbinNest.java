package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.PoseStack;

import divinerpg.block_entities.block.RobbinNestBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderRobbinNest implements BlockEntityRenderer<RobbinNestBlockEntity> {
	public RenderRobbinNest(BlockEntityRendererProvider.Context context) {}
	@Override
	public void render(RobbinNestBlockEntity blockEntity, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.pushPose();
		matrixStackIn.translate(.5F, .25F, .5F);
		if(partialTicks % 20F == 0F) blockEntity = (RobbinNestBlockEntity) Minecraft.getInstance().level.getBlockEntity(blockEntity.getBlockPos());
		Minecraft.getInstance().getItemRenderer().renderStatic(blockEntity.getItem(), ItemDisplayContext.GROUND, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, blockEntity.getLevel(), 0);
		matrixStackIn.popPose();
	}
}
