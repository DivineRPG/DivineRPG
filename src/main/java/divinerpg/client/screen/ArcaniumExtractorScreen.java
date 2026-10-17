package divinerpg.client.screen;

import divinerpg.DivineRPG;
import divinerpg.client.menu.ArcaniumExtractorMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ArcaniumExtractorScreen extends AbstractContainerScreen<ArcaniumExtractorMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/arcanium_extractor.png");
    private static final Identifier PROGRESS_ARROW = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/sprites/progress_arrow.png");
    private static final Identifier EXTRACTOR_FLAME = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/sprites/extractor_flame.png");

    public ArcaniumExtractorScreen(ArcaniumExtractorMenu screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn, 176, 166);
    }

    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        int i = this.leftPos;
        int j = this.topPos;
        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, i, j, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 176, 166);
        if (this.menu.isLit()) {
            int l = Mth.ceil(this.menu.getLitProgress() * 13.0F) + 1;
            graphics.blit(RenderPipelines.GUI_TEXTURED, EXTRACTOR_FLAME, i + 56, j + 36 + (14 - l), 0.0F, (float)(14 - l), 14, l, 14, 14);
        }
        int progressWidth = Mth.ceil(this.menu.getBurnProgress() * 24.0F);
        if (progressWidth > 0) {
            graphics.blit(RenderPipelines.GUI_TEXTURED, PROGRESS_ARROW, i + 79, j + 34, 0.0F, 0.0F, progressWidth, 16, 24, 16);
        }
        super.extractContents(graphics, mouseX, mouseY, partialTicks);
    }
}