package divinerpg.client.containers.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.client.containers.PresentBoxContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PresentBoxScreen extends AbstractContainerScreen<PresentBoxContainer> implements MenuAccess<PresentBoxContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(
            DivineRPG.MODID + ":textures/gui/present_box_gui.png");
    public PresentBoxScreen(PresentBoxContainer container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

    }

    public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }


    @Override
    protected void renderBg(GuiGraphics matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.leftPos;
        int j = (this.height - this.imageHeight) / 2;
        matrixStack.blit(TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics matrixStack, int mouseX, int mouseY) {
        matrixStack.drawString(font, this.title, (this.getXSize() / 2 - this.font.width(title) / 2) + 0, 6, 704255);
        matrixStack.drawString(font, playerInventoryTitle, 8, this.getYSize() - 94, 704255);
    }

}