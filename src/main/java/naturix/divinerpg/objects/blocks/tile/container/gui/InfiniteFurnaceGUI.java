package naturix.divinerpg.objects.blocks.tile.container.gui;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityInfiniteFurnace;
import naturix.divinerpg.objects.blocks.tile.container.ContainerInfiniteFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public abstract class InfiniteFurnaceGUI extends GuiContainer {
    private final InventoryPlayer player;
    private final TileEntityInfiniteFurnace tileEntity;

    public InfiniteFurnaceGUI(InventoryPlayer player, TileEntityInfiniteFurnace tileEntity) {
        super(new ContainerInfiniteFurnace(player, tileEntity));
        this.player = player;
        this.tileEntity = tileEntity;
    }

    abstract ResourceLocation getTexture();

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileEntity.getDisplayName().getUnformattedComponentText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 0, 6,
                16777215);
        this.fontRenderer.drawString(this.player.getDisplayName().getFormattedText(), 8, this.ySize - 96 + 2, 16777215);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(getTexture());
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(this.guiLeft + 79, this.guiTop + 34, 176, 14, l + 1, 16);

        if (l > 0) {
            this.drawTexturedModalRect(this.guiLeft + 56, this.guiTop + 36, 176, 0, 15, 15);
        }
    }

    private int getCookProgressScaled(int pixels) {
        int i = this.tileEntity.getField(0);
        int j = this.tileEntity.getField(1);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}