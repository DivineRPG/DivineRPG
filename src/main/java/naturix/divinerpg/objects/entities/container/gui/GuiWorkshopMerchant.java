package naturix.divinerpg.objects.entities.container.gui;

import io.netty.buffer.Unpooled;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.container.ContainerWorkshopMerchant;
import naturix.divinerpg.objects.entities.entity.iceika.WorkshopMerchant;
import naturix.divinerpg.utils.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

/**
 * Created by LiteWolf101 on Feb
 * /19/2019
 */
public class GuiWorkshopMerchant extends GuiContainer {
    private static final ResourceLocation MERCHANT_GUI_TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/workshop_worker.png");
    private final IMerchant merchant;
    private GuiWorkshopMerchant.MerchantButton nextButton;
    private GuiWorkshopMerchant.MerchantButton previousButton;
    private int selectedMerchantRecipe;
    private final ITextComponent chatComponent;

    public GuiWorkshopMerchant(InventoryPlayer playerInventory, IMerchant merchant, World world) {
        super(new ContainerWorkshopMerchant(playerInventory, merchant, world));
        this.merchant = merchant;
        this.chatComponent = merchant.getDisplayName();
    }

    @Override
    public void initGui()
    {
        super.initGui();
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.nextButton = (GuiWorkshopMerchant.MerchantButton)this.addButton(new GuiWorkshopMerchant.MerchantButton(1, i + 120 + 27, j + 24 - 1, true));
        this.previousButton = (GuiWorkshopMerchant.MerchantButton)this.addButton(new GuiWorkshopMerchant.MerchantButton(2, i + 36 - 19, j + 24 - 1, false));
        this.nextButton.enabled = false;
        this.previousButton.enabled = false;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String s = this.chatComponent.getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
        MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);

        if (merchantrecipelist != null)
        {
            this.nextButton.enabled = this.selectedMerchantRecipe < merchantrecipelist.size() - 1;
            this.previousButton.enabled = this.selectedMerchantRecipe > 0;
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        boolean flag = false;

        if (button == this.nextButton)
        {
            ++this.selectedMerchantRecipe;
            MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);

            if (merchantrecipelist != null && this.selectedMerchantRecipe >= merchantrecipelist.size())
            {
                this.selectedMerchantRecipe = merchantrecipelist.size() - 1;
            }

            flag = true;
        }
        else if (button == this.previousButton)
        {
            --this.selectedMerchantRecipe;

            if (this.selectedMerchantRecipe < 0)
            {
                this.selectedMerchantRecipe = 0;
            }

            flag = true;
        }

        if (flag)
        {
            ((ContainerWorkshopMerchant)this.inventorySlots).setCurrentRecipeIndex(this.selectedMerchantRecipe);
            PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
            packetbuffer.writeInt(this.selectedMerchantRecipe);
            this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|TrSel", packetbuffer));
        }
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(MERCHANT_GUI_TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);

        if (merchantrecipelist != null && !merchantrecipelist.isEmpty())
        {
            int k = this.selectedMerchantRecipe;

            if (k < 0 || k >= merchantrecipelist.size())
            {
                return;
            }

            MerchantRecipe merchantrecipe = (MerchantRecipe)merchantrecipelist.get(k);

            if (merchantrecipe.isRecipeDisabled())
            {
                this.mc.getTextureManager().bindTexture(MERCHANT_GUI_TEXTURE);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.disableLighting();
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 21, 212, 0, 28, 21);
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 51, 212, 0, 28, 21);
            }
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        MerchantRecipeList merchantrecipelist = this.merchant.getRecipes(this.mc.player);

        if (merchantrecipelist != null && !merchantrecipelist.isEmpty())
        {
            int i = (this.width - this.xSize) / 2;
            int j = (this.height - this.ySize) / 2;
            int k = this.selectedMerchantRecipe;
            MerchantRecipe merchantrecipe = (MerchantRecipe)merchantrecipelist.get(k);
            ItemStack itemstack = merchantrecipe.getItemToBuy();
            ItemStack itemstack1 = merchantrecipe.getSecondItemToBuy();
            ItemStack itemstack2 = merchantrecipe.getItemToSell();
            GlStateManager.pushMatrix();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();
            GlStateManager.enableLighting();
            this.itemRender.zLevel = 100.0F;
            this.itemRender.renderItemAndEffectIntoGUI(itemstack, i + 36, j + 24);
            this.itemRender.renderItemOverlays(this.fontRenderer, itemstack, i + 36, j + 24);

            if (!itemstack1.isEmpty())
            {
                this.itemRender.renderItemAndEffectIntoGUI(itemstack1, i + 62, j + 24);
                this.itemRender.renderItemOverlays(this.fontRenderer, itemstack1, i + 62, j + 24);
            }

            this.itemRender.renderItemAndEffectIntoGUI(itemstack2, i + 120, j + 24);
            this.itemRender.renderItemOverlays(this.fontRenderer, itemstack2, i + 120, j + 24);
            this.itemRender.zLevel = 0.0F;
            GlStateManager.disableLighting();

            if (this.isPointInRegion(36, 24, 16, 16, mouseX, mouseY) && !itemstack.isEmpty())
            {
                this.renderToolTip(itemstack, mouseX, mouseY);
            }
            else if (!itemstack1.isEmpty() && this.isPointInRegion(62, 24, 16, 16, mouseX, mouseY) && !itemstack1.isEmpty())
            {
                this.renderToolTip(itemstack1, mouseX, mouseY);
            }
            else if (!itemstack2.isEmpty() && this.isPointInRegion(120, 24, 16, 16, mouseX, mouseY) && !itemstack2.isEmpty())
            {
                this.renderToolTip(itemstack2, mouseX, mouseY);
            }
            else if (merchantrecipe.isRecipeDisabled() && (this.isPointInRegion(83, 21, 28, 21, mouseX, mouseY) || this.isPointInRegion(83, 51, 28, 21, mouseX, mouseY)))
            {
                this.drawHoveringText(I18n.format("merchant.deprecated"), mouseX, mouseY);
            }

            GlStateManager.popMatrix();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
        }

        this.renderHoveredToolTip(mouseX, mouseY);
    }

    public IMerchant getMerchant()
    {
        return this.merchant;
    }

    @SideOnly(Side.CLIENT)
    static class MerchantButton extends GuiButton
    {
        private final boolean forward;

        public MerchantButton(int buttonID, int x, int y, boolean p_i1095_4_)
        {
            super(buttonID, x, y, 12, 19, "");
            this.forward = p_i1095_4_;
        }

        /**
         * Draws this button to the screen.
         */
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
        {
            if (this.visible)
            {
                mc.getTextureManager().bindTexture(GuiWorkshopMerchant.MERCHANT_GUI_TEXTURE);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                int i = 0;
                int j = 176;

                if (!this.enabled)
                {
                    j += this.width * 2;
                }
                else if (flag)
                {
                    j += this.width;
                }

                if (!this.forward)
                {
                    i += this.height;
                }

                this.drawTexturedModalRect(this.x, this.y, j, i, this.width, this.height);
            }
        }
    }
}
