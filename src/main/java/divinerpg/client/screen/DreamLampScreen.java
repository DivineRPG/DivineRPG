package divinerpg.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.client.menu.DreamLampMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DreamLampScreen extends AbstractContainerScreen<DreamLampMenu> {
    private ResourceLocation texture = new ResourceLocation(DivineRPG.MODID + ":textures/gui/dream_lamp.png");

    public DreamLampScreen(DreamLampMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

        this.titleLabelY -= 2;
    }
    public void render(GuiGraphics matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
    @Override
    protected void renderBg(GuiGraphics matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, texture);

        int edgeSpacingX = (this.width - this.getXSize()) / 2;
        int edgeSpacingY = (this.height - this.getYSize()) / 2;
        matrixStack.blit(texture, edgeSpacingX, edgeSpacingY, 0, 0, this.getXSize(), this.getYSize());
    }
    @Override
    protected void renderLabels(GuiGraphics matrixStack, int mouseX, int mouseY) {
        matrixStack.drawString(font, this.title, 12, 8, 4210752);
        matrixStack.drawString(font, playerInventoryTitle, 12, 70, 4210752);
    }
}