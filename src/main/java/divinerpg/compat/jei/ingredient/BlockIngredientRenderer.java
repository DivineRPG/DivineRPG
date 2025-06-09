package divinerpg.compat.jei.ingredient;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import mezz.jei.api.ingredients.IIngredientRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;

import java.util.List;

public class BlockIngredientRenderer implements IIngredientRenderer<Block> {
    @Override
    public void render(GuiGraphics guiGraphics, Block ingredient) {
        BlockState state = ingredient.defaultBlockState();
        if(!state.isAir() && state.getFluidState().isEmpty()) {
            RenderSystem.enableDepthTest();
            Minecraft minecraft = Minecraft.getInstance();

            ItemStack stack = state.getBlock().asItem().getDefaultInstance();
            if(!stack.isEmpty() && !state.is(BlockTags.FIRE)) {
                Font font = getFontRenderer(minecraft, ingredient);
                guiGraphics.renderFakeItem(stack, 0, 0);
                guiGraphics.renderItemDecorations(font, stack, 0, 0);
            } else {
                PoseStack poseStack = guiGraphics.pose();
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
        return List.of(ingredient.getName(), Component.literal(BuiltInRegistries.BLOCK.getKey(ingredient).toString()).withStyle(ChatFormatting.DARK_GRAY));
    }
}