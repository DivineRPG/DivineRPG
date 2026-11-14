package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.DreamLampMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class DreamLampScreen extends AbstractContainerScreen<DreamLampMenu> {
    private final Identifier texture = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/dream_lamp.png");
    public DreamLampScreen(DreamLampMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        titleLabelY -= 2;
    }
    @Override public void extractRenderState(GuiGraphicsExtractor matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.extractRenderState(matrixStack, mouseX, mouseY, partialTicks);
        extractTooltip(matrixStack, mouseX, mouseY);
    }
    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        graphics.text(font, title, 12, 7, 13563562);
        graphics.text(font, playerInventoryTitle, 12, 71, 13563562);
    }
    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        int edgeSpacingX = (width - imageWidth) / 2;
        int edgeSpacingY = (height - imageHeight) / 2;
        graphics.blit(texture, edgeSpacingX, edgeSpacingY, 0, 0, imageWidth, imageHeight, 176, 166);
    }
}