package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.FrostedChestMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class FrostedChestScreen extends AbstractContainerScreen<FrostedChestMenu> implements MenuAccess<FrostedChestMenu> {
    private static final Identifier LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/frosted_chest_gui.png");
    public FrostedChestScreen(FrostedChestMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        this.inventoryLabelY -= -2;
    }
    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        graphics.blit(LOCATION, leftPos, topPos, 0, 0, 176, 167, 176, 167);
    }
    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        graphics.text(font, title, titleLabelX, titleLabelY, 2118747, false);
        graphics.text(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, 2118747, false);
    }
}