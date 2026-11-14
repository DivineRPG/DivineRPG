package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.BoneChestMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class BoneChestScreen extends AbstractContainerScreen<BoneChestMenu> implements MenuAccess<BoneChestMenu> {
    private static final Identifier LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/bone_chest_gui.png");
    public BoneChestScreen(BoneChestMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        inventoryLabelY -= -2;
    }
    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        int i = leftPos, j = topPos;
        graphics.blit(LOCATION, i, j, 0, 0, 176, 167, 176, 167);
    }
    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        graphics.text(font, title, titleLabelX, titleLabelY, 16777215, false);
        graphics.text(font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, 16777215, false);
    }
}