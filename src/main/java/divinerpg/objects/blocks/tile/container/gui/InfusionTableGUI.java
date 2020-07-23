package divinerpg.objects.blocks.tile.container.gui;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.container.ContainerInfusionTable;
import divinerpg.objects.blocks.tile.entity.TileEntityInfusionTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class InfusionTableGUI extends GuiContainer {
    private TileEntityInfusionTable TeInfusionTable;

    private ResourceLocation texture = new ResourceLocation(DivineRPG.MODID + ":textures/gui/infusion_table.png");

    public InfusionTableGUI(ContainerInfusionTable container) {
        super(container);
        this.TeInfusionTable = container.tileentity;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)  {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(texture);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        super.drawScreen(par1, par2, par3);
        ItemStack inputStack = null;
        String s = null;
        inputStack = TeInfusionTable.getStackInSlot(2);
        if(inputStack != null && inputStack.getItem() != Item.getItemFromBlock(Blocks.AIR)) {
            s = inputStack.getDisplayName();
            this.fontRenderer.drawString(s, this.width / 2 - 50, height / 2 - 65, Color.blue.getRGB());
        }
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