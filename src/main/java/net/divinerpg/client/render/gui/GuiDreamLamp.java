package net.divinerpg.client.render.gui;

import net.divinerpg.blocks.vethea.container.ContainerDreamLamp;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDreamLamp extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation(Reference.PREFIX + "textures/gui/dreamLamp.png");
    private IInventory playerInv;
    private IInventory blockInv;

    public GuiDreamLamp(IInventory player, IInventory block) {
        super(new ContainerDreamLamp(player, block));
        this.playerInv = player;
        this.blockInv = block;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRendererObj.drawString(this.blockInv.isCustomInventoryName() ? this.blockInv.getInventoryName() : I18n.format(this.blockInv.getInventoryName(), new Object[0]), 12, 8, 0x6FA940);
        this.fontRendererObj.drawString(this.playerInv.isCustomInventoryName() ? this.playerInv.getInventoryName() : I18n.format(this.playerInv.getInventoryName(), new Object[0]), 12, this.ySize - 96, 0x6FA940);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/gui/dreamLamp.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if(this.blockInv.getStackInSlot(0) != null && this.blockInv.getStackInSlot(0).getItem() == VetheaItems.acid) this.drawTexturedModalRect(k+81, l+31, 176, 0, 13, 13);
    }
}