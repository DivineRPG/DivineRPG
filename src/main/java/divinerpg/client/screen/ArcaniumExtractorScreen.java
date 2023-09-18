package divinerpg.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.client.menu.ArcaniumExtractorMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ArcaniumExtractorScreen extends AbstractContainerScreen<ArcaniumExtractorMenu> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/arcanium_extractor.png");

    public ArcaniumExtractorScreen(ArcaniumExtractorMenu screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }




    @Override
    public void render(GuiGraphics matrixStack, int x, int y, float partialTicks) {
        super.render(matrixStack, x, y, partialTicks);
        renderTooltip(matrixStack, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics p_282430_, float p_282530_, int p_281621_, int p_283333_) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        p_282430_.blit(GUI_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            p_282430_.blit(GUI_TEXTURE, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.menu.getBurnProgress();
        p_282430_.blit(GUI_TEXTURE, i + 79, j + 34, 176, 14, l + 1, 16);
    }

}