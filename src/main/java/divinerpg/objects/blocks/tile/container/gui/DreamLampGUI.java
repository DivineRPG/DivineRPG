package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.container.ContainerDreamLamp;
import divinerpg.objects.blocks.tile.entity.TileEntityInfusionTable;
import divinerpg.registry.ItemRegistry;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DreamLampGUI extends GuiContainer {
    private TileEntityInfusionTable TeDreamLamp;

    private ResourceLocation texture = new ResourceLocation(DivineRPG.MODID + ":textures/gui/dream_lamp.png");
    private IInventory blockInv;
    private IInventory playerInv;

    public DreamLampGUI(ContainerDreamLamp container) {
        super(container);
        this.blockInv = container.tileEntity;
        this.playerInv = container.inv;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.blockInv.hasCustomName() ? this.blockInv.getName() : I18n.format(this.blockInv.getName()), 12, 8, 0x6FA940);
        this.fontRenderer.drawString(this.playerInv.hasCustomName() ? this.playerInv.getName() : I18n.format(this.playerInv.getName()), 12, this.ySize - 96, 0x6FA940);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if(this.blockInv.getStackInSlot(0) != ItemStack.EMPTY && this.blockInv.getStackInSlot(0).getItem() == ItemRegistry.acid) this.drawTexturedModalRect(k+81, l+31, 176, 0, 13, 13);
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        super.drawScreen(par1, par2, par3);
        this.renderHoveredToolTip(par1, par2);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void keyTyped(char par1, int par2) {
        if (par2 == 1 || par2 == mc.gameSettings.keyBindInventory.getKeyCode()) {
            mc.player.closeScreen();
        }
    }
}