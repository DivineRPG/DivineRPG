package divinerpg.client.containers.screen;

import com.mojang.blaze3d.systems.*;
import divinerpg.*;
import divinerpg.client.containers.*;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
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

    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }


    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.leftPos;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, (this.getXSize() / 2 - this.font.width(title) / 2) + 0, 6, 704255);
        this.font.draw(matrixStack, playerInventoryTitle, 8, this.getYSize() - 94, 704255);
    }

}