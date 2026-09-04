package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.ArcaniumExtractorMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ArcaniumExtractorScreen extends AbstractContainerScreen<ArcaniumExtractorMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/arcanium_extractor.png");
    public static final Identifier FLAME_SPRITE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "extractor_flame");
    public ArcaniumExtractorScreen(ArcaniumExtractorMenu screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
    }
    @Override public void extractRenderState(GuiGraphicsExtractor stack, int x, int y, float partialTicks) {
        super.extractRenderState(stack, x, y, partialTicks);
        extractTooltip(stack, x, y);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        int i = leftPos;
        int j = topPos;
        graphics.blit(GUI_TEXTURE, i, j, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        if(menu.isLit()) {
            int l = Mth.ceil(menu.getLitProgress() * 13F) + 1;
            graphics.blit(FLAME_SPRITE, 14, 14, 0, 14 - l, i + 57, j + 50 - l, 14, l);
        } graphics.blit(DivineFurnaceScreen.PROGRESS_ARROW_SPRITE, 24, 16, 0, 0, i + 79, j + 34, Mth.ceil(menu.getBurnProgress() * 24F), 16);
    }
}