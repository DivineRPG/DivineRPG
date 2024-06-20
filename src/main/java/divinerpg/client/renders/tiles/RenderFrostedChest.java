package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.client.models.block.ModelFrostedChest;
import divinerpg.block_entities.chests.FrostedChestBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.data.ModelData;

public class RenderFrostedChest implements BlockEntityRenderer<FrostedChestBlockEntity> {
    private final ModelFrostedChest<?> model;
    public RenderFrostedChest(BlockEntityRendererProvider.Context context) {
        model = new ModelFrostedChest<>(context.bakeLayer(ModelFrostedChest.LAYER_LOCATION));
    }

    @Override
    public void render(FrostedChestBlockEntity tile, float partialTick, PoseStack matrix, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
    	matrix.pushPose();
    	if(tile.getBlockState().getValue(BlockStateProperties.WATERLOGGED)) {
        	Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.ICE.defaultBlockState(), matrix, buffer, combinedLight, combinedOverlay, ModelData.EMPTY, null);
        }
        matrix.translate(0.5D, 0.5D, 0.5D);
        matrix.mulPose(Axis.YP.rotationDegrees(-tile.getBlockState().getValue(BlockModChest.FACING).toYRot()));
        matrix.mulPose(Axis.XN.rotationDegrees(180));
        matrix.translate(-0.5D, -0.5D, -0.5D);
        
        
        float lidAngle = tile.getOpenNess(partialTick);
        lidAngle = 1.0F - lidAngle;
        lidAngle = 1.0F - lidAngle * lidAngle * lidAngle;
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/frosted_chest.png")));
        model.lid.xRot = -(lidAngle * ((float) Math.PI / 2F));
        model.handle.xRot = model.lid.xRot;
        model.renderToBuffer(matrix, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrix.popPose();
    }
}