package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import divinerpg.*;
import divinerpg.client.models.block.*;
import divinerpg.block_entities.furnace.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.*;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.state.properties.*;

public class RenderDemonFurnace implements BlockEntityRenderer<DemonFurnaceBlockEntity> {
    private ResourceLocation off = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/demon_furnace.png");
    private ResourceLocation on = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/demon_furnace_on.png");
    private final ModelDemonFurnace<?> model;
    public RenderDemonFurnace(BlockEntityRendererProvider.Context context) {
        model = new ModelDemonFurnace<>(context.bakeLayer(ModelDemonFurnace.LAYER_LOCATION));
    }
    @Override
    public void render(DemonFurnaceBlockEntity te, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        matrixStack.pushPose();
        matrixStack.translate(0.5D, 0.5D, 0.5D);
        matrixStack.mulPose(Axis.YP.rotationDegrees(-te.getBlockState().getValue(AbstractFurnaceBlock.FACING).toYRot()));
        matrixStack.mulPose(Axis.YN.rotationDegrees(180));
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(te.getBlockState().getValue(BlockStateProperties.LIT) ? on : off));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay);
        matrixStack.popPose();
    }
}
