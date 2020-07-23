package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.objects.blocks.tile.container.ContainerModFurnace;
import divinerpg.objects.blocks.tile.entity.TileEntityModFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public abstract class ModFurnaceGUI extends GuiContainer {
    private final InventoryPlayer player;
    private final TileEntityModFurnace tileEntity;

    public ModFurnaceGUI(InventoryPlayer player, TileEntityModFurnace tileEntity) {
        super(new ContainerModFurnace(player, tileEntity));
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

        if (this.tileEntity.needsFuel()) {
            if (this.tileEntity.getField(0) > 0) {
                int k = this.getBurnLeftScaled(13);
                this.drawTexturedModalRect(this.guiLeft + 56, this.guiTop + 36 + 12 - k, 176, 12 - k, 14, k + 1);
            }
        } else {
            if (l > 0) {
                this.drawTexturedModalRect(this.guiLeft + 56, this.guiTop + 36, 176, 0, 15, 15);
            }
        }
    }

    private int getCookProgressScaled(int pixels) {
        int i = this.tileEntity.getField(2);
        int j = this.tileEntity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels) {
        int i = this.tileEntity.getField(1);
        if (i == 0) {
            i = 200;
        }
        return this.tileEntity.getField(0) * pixels / i;
    }
}