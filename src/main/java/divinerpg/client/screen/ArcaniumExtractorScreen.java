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
    @Override public void render(GuiGraphics stack, int x, int y, float partialTicks) {
        renderBackground(stack);
        super.render(stack, x, y, partialTicks);
        renderTooltip(stack, x, y);
    }
    @Override protected void renderBg(GuiGraphics stack, float p_282530_, int p_281621_, int p_283333_) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        int i = leftPos;
        int j = topPos;
        stack.blit(GUI_TEXTURE, i, j, 0, 0, imageWidth, imageHeight);
        if(menu.isLit()) {
            int k = menu.getLitProgress();
            stack.blit(GUI_TEXTURE, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        } int l = menu.getBurnProgress();
        stack.blit(GUI_TEXTURE, i + 79, j + 34, 176, 14, l + 1, 16);
    }
}