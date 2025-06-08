package divinerpg.compat.jei.ingredient;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;

import java.util.List;

public class BlockIngredientRenderer implements IIngredientRenderer<Block> {
//    private static final RenderType TEXTURE = RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/block/liquid_tar_still.png"), false);
//    private static void pos(VertexConsumer vertexBuilder, Matrix4f matrix4f, float x, float y, float u, float v) {
//        vertexBuilder.addVertex(matrix4f, x - .5F, y - .25F, 0).setColor(255, 255, 255, 255).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal(0, 1, 0);
//    }
    @Override
    public void render(GuiGraphics guiGraphics, Block ingredient) {
        PoseStack poseStack = guiGraphics.pose();
        BlockState state = ingredient.defaultBlockState();
        if(!state.isAir()) {
            RenderSystem.enableDepthTest();
            Minecraft minecraft = Minecraft.getInstance();

            ItemStack stack = state.getBlock().asItem().getDefaultInstance();
            if(!stack.isEmpty() && !state.is(BlockTags.FIRE)) {
                Font font = getFontRenderer(minecraft, ingredient);
                guiGraphics.renderFakeItem(stack, 0, 0);
                guiGraphics.renderItemDecorations(font, stack, 0, 0);
            } else if(!state.getFluidState().isEmpty()) {
                //TODO: fluid render
//                poseStack.pushPose();
//                VertexConsumer vertexConsumer = guiGraphics.bufferSource().getBuffer(TEXTURE);
//                poseStack.translate(8F, 8F, 0F);
//                poseStack.scale(16F, -16F, 16F);
//                Matrix4f matrix4f = poseStack.last().pose();
//                pos(vertexConsumer, matrix4f, 0, 0, 0, 1);
//                pos(vertexConsumer, matrix4f, 1, 0, 1, 1);
//                pos(vertexConsumer, matrix4f, 1, 1, 1, 0);
//                pos(vertexConsumer, matrix4f, 0, 1, 0, 0);
//                guiGraphics.flush();
//                poseStack.popPose();
            } else {
                poseStack.pushPose();
                poseStack.translate(1F, 12.5F, 15F);
                poseStack.scale(10F, -10F, 10F);
                poseStack.rotateAround(Axis.XP.rotationDegrees(30F), 1F, 0F, 0F);
                poseStack.rotateAround(Axis.YP.rotationDegrees(45F), 0F, 1F, 0F);
                //rendertype gui no
                //rendertype translucent yes
                //rendertype translucent_moving_block yes
                minecraft.getBlockRenderer().renderSingleBlock(state, poseStack, guiGraphics.bufferSource(), 15728880, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.translucent());

                guiGraphics.flush();
                Lighting.setupFor3DItems();
                poseStack.popPose();
            } RenderSystem.disableBlend();
        }
    }
    @Override @SuppressWarnings({"deprecated", "removal"})
    public List<Component> getTooltip(Block ingredient, TooltipFlag tooltipFlag) {
        return List.of(ingredient.getName());
    }
}