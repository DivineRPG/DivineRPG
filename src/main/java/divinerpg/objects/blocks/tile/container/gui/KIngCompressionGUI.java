package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.container.KingCompressorContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Set;

public class KIngCompressionGUI extends GuiContainer {
    private final ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/gui/king_compression_gui.png");
    private KingCompressorContainer container;

    public KIngCompressionGUI(KingCompressorContainer inventorySlotsIn) {
        super(inventorySlotsIn);
        container = inventorySlotsIn;

        this.xSize = 176;
        this.ySize = 193;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        int k = (int) Math.floor(container.getCookTimePercentage() / 100.0 * 13);
        this.drawTexturedModalRect(this.guiLeft + 81, this.guiTop + 69 + 14 - k, 176, 14 - k, 14, k + 1);

        Set<String> sets = container.getAbsorbedSets();
        String text = "King compressor";

        int stringWidth = this.fontRenderer.getStringWidth(text);

        int topX = this.guiLeft + (this.xSize / 2 - stringWidth / 2);
        int topY = guiTop + 6;
        this.fontRenderer.drawString(text, topX, topY, 16777215);


        String numbers = String.format("%s / %s", sets.size(), container.getLimit());
        this.fontRenderer.drawString(numbers, this.guiLeft + (this.xSize / 2 - fontRenderer.getStringWidth(numbers) / 2), topY + fontRenderer.FONT_HEIGHT + 5, 16777215);

        drawToolTip(sets, mouseX, mouseY, topX, topY, stringWidth, fontRenderer.FONT_HEIGHT);
    }

    private void drawToolTip(Set<String> sets, int mouseX, int mouseY, int topX, int topY, int strWidth, int fontHeight) {
        if (topX <= mouseX && mouseX <= topX + strWidth) {
            if (topY <= mouseY && mouseY <= topY + fontHeight) {
                drawHoveringText(new ArrayList<>(sets), mouseX, mouseY);
            }
        }
    }
}
