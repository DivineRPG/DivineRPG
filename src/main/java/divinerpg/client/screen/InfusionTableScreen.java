package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.InfusionTableMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class InfusionTableScreen extends AbstractContainerScreen<InfusionTableMenu> implements MenuAccess<InfusionTableMenu> {
    private static final Identifier LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/infusion_table.png");
    public InfusionTableScreen(InfusionTableMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

        this.titleLabelY -= 2;
    }

    @Override public void extractRenderState(GuiGraphicsExtractor matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.extractRenderState(matrixStack, mouseX, mouseY, partialTicks);
        extractTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        int edgeSpacingX = (this.width - this.getXSize()) / 2;
        int edgeSpacingY = (this.height - this.getYSize()) / 2;
        graphics.blit(LOCATION, edgeSpacingX, edgeSpacingY, 0, 0, this.getXSize(), this.getYSize(), 176, 166);
    }


    @Override
    protected void extractLabels(GuiGraphicsExtractor matrixStack, int mouseX, int mouseY) {
        matrixStack.text(font, this.title, 50, 18, 4210752);
    }

}