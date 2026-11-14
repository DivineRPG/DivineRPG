package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.PresentBoxMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class PresentBoxScreen extends AbstractContainerScreen<PresentBoxMenu> implements MenuAccess<PresentBoxMenu> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/present_box_gui.png");
    public PresentBoxScreen(PresentBoxMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        this.inventoryLabelY -= -2;
    }
    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        graphics.blit(TEXTURE, leftPos, topPos, 0, 0, 176, 167, 176, 167);
    }
    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        graphics.text(font, title, titleLabelX, titleLabelY, 704255, false);
        graphics.text(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, 704255, false);
    }
}