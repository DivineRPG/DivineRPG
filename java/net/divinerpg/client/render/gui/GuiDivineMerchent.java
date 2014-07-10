package net.divinerpg.client.render.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.divinerpg.api.container.ContainerDivineMerchant;
import net.divinerpg.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.IMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDivineMerchent extends GuiContainer {
	
	private static final Logger logger = LogManager.getLogger();
	private IMerchant theIMerchant;
	private GuiDivineMerchent.ModMerchantButton nextRecipeButtonIndex;
	private GuiDivineMerchent.ModMerchantButton previousRecipeButtonIndex;
	private int currentRecipeIndex = 0;
    private String name, texture;

	public GuiDivineMerchent(ContainerDivineMerchant container, IMerchant mer, String name, String tex) {
		super(container);
		this.theIMerchant = mer; 
		this.texture = tex;
		this.name = name;
	}

	public void initGui() {
		super.initGui();
		int var1 = (this.width - this.xSize) / 2;
		int var2 = (this.height - this.ySize) / 2;
		this.buttonList.add(this.nextRecipeButtonIndex = new GuiDivineMerchent.ModMerchantButton(1, var1 + 120 + 27, var2 + 24 - 1, true, texture));
		this.buttonList.add(this.previousRecipeButtonIndex = new GuiDivineMerchent.ModMerchantButton(2, var1 + 36 - 19, var2 + 24 - 1, false, texture));
		this.nextRecipeButtonIndex.enabled = false;
		this.previousRecipeButtonIndex.enabled = false;
	}

	protected void drawGuiContainerForegroundLayer(int var1, int var2) {
		this.fontRendererObj.drawString(name, 56, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
 
	public void updateScreen() {
		super.updateScreen();
		MerchantRecipeList var1 = this.theIMerchant.getRecipes(this.mc.thePlayer);
		if(var1 != null) {
			this.nextRecipeButtonIndex.enabled = this.currentRecipeIndex < var1.size() - 1;
			this.previousRecipeButtonIndex.enabled = this.currentRecipeIndex > 0;
		}
	}
 
	protected void actionPerformed(GuiButton var1) {
		boolean var2 = false;

		if(var1 == this.nextRecipeButtonIndex) {
			++this.currentRecipeIndex;
			var2 = true;
		}
		else if(var1 == this.previousRecipeButtonIndex) {
			--this.currentRecipeIndex;
			var2 = true;
		}

		if(var2) {
			((ContainerDivineMerchant)this.inventorySlots).setCurrentRecipeIndex(this.currentRecipeIndex);
			ByteArrayOutputStream var3 = new ByteArrayOutputStream();
			DataOutputStream var4 = new DataOutputStream(var3);

			try {
				var4.writeInt(this.currentRecipeIndex);
				this.mc.getNetHandler().addToSendQueue(new C17PacketCustomPayload("MC|TrSel", var3.toByteArray()));
			}
			catch (Exception var6) {
				logger.error("Couldn\'t send trade info", var6);
			}
		}
	}

	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/gui/" + texture + ".png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        MerchantRecipeList merchantrecipelist = this.theIMerchant.getRecipes(this.mc.thePlayer);

        if(merchantrecipelist != null && !merchantrecipelist.isEmpty()) {
            int i1 = this.currentRecipeIndex;
            MerchantRecipe merchantrecipe = (MerchantRecipe)merchantrecipelist.get(i1);

            if(merchantrecipe.isRecipeDisabled()) {
                this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/gui/" + texture + ".png"));
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 21, 212, 0, 28, 21);
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 51, 212, 0, 28, 21);
            }
        }
    }
 
    public void drawScreen(int par1, int par2, float par3) {
        super.drawScreen(par1, par2, par3);
        MerchantRecipeList merchantrecipelist = this.theIMerchant.getRecipes(this.mc.thePlayer);

        if (merchantrecipelist != null && !merchantrecipelist.isEmpty()) {
            int k = (this.width - this.xSize) / 2;
            int l = (this.height - this.ySize) / 2;
            int i1 = this.currentRecipeIndex;
            MerchantRecipe merchantrecipe = (MerchantRecipe)merchantrecipelist.get(i1);
            GL11.glPushMatrix();
            ItemStack itemstack = merchantrecipe.getItemToBuy();
            ItemStack itemstack1 = merchantrecipe.getSecondItemToBuy();
            ItemStack itemstack2 = merchantrecipe.getItemToSell();
            RenderHelper.enableGUIStandardItemLighting();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glEnable(GL11.GL_LIGHTING);
            itemRender.zLevel = 100.0F;
            itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack, k + 36, l + 24);
            itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack, k + 36, l + 24);

            if (itemstack1 != null) {
                itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack1, k + 62, l + 24);
                itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack1, k + 62, l + 24);
            }

            itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack2, k + 120, l + 24);
            itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack2, k + 120, l + 24);
            itemRender.zLevel = 0.0F;
            GL11.glDisable(GL11.GL_LIGHTING);

            if (this.func_146978_c(36, 24, 16, 16, par1, par2)) {
                this.renderToolTip(itemstack, par1, par2);
            }
            else if (itemstack1 != null && this.func_146978_c(62, 24, 16, 16, par1, par2)) {
                this.renderToolTip(itemstack1, par1, par2);
            }
            else if (this.func_146978_c(120, 24, 16, 16, par1, par2)) {
                this.renderToolTip(itemstack2, par1, par2);
            }

            GL11.glPopMatrix();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            RenderHelper.enableStandardItemLighting();
        }
    }

	public IMerchant getIMerchant() {
		return this.theIMerchant;
	}

	@SideOnly(Side.CLIENT)
	static class ModMerchantButton extends GuiButton {
		private final boolean rev;
		private static String texture;

		public ModMerchantButton(int par1, int par2, int par3, boolean par4, String tex) {
			super(par1, par2, par3, 12, 19, "");
			this.texture = tex;
			this.rev = par4;
		}

		public void drawButton(Minecraft mc, int x, int y) {
			if(this.visible) {
				mc.getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/gui/" + texture + ".png"));
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				boolean flag = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;
				int k = 0;
				int l = 176;

				if(!this.enabled) {
					l += this.width * 2;
				}
				else if(flag) {
					l += this.width;
				}

				if(!this.rev) {
					k += this.height;
				}
				this.drawTexturedModalRect(this.xPosition, this.yPosition, l, k, this.width, this.height);
			}
		}
	}
}