package divinerpg.client.screen;

import divinerpg.client.menu.InfiniFurnaceMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.*;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public abstract class InfiniFurnaceScreen<T extends InfiniFurnaceMenu> extends AbstractRecipeBookScreen<T> {
    private boolean widthTooNarrow;
    private final Identifier texture, flame;
    private final int titleColor;
    private final int invColor;
    public InfiniFurnaceScreen(T container, Inventory inv, Component c, Identifier location, int titleColor, int invColor) {
        super(container, new InfiniFurnaceRecipeBook(container), inv, c);
        texture = location;
        this.flame = DivineFurnaceScreen.FLAME_SPRITE;
        this.titleColor = titleColor;
        this.invColor = invColor;
    }
    public InfiniFurnaceScreen(T container, Inventory inv, Component c, Identifier location, int titleColor, int invColor, Identifier flame) {
        super(container, new InfiniFurnaceRecipeBook(container), inv, c);
        texture = location;
        this.flame = flame;
        this.titleColor = titleColor;
        this.invColor = invColor;
    }
    protected ScreenPosition getRecipeBookButtonPosition() {
        return new ScreenPosition(this.leftPos + 20, this.height / 2 - 49);
    }
    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int i = leftPos;
        int j = topPos;
        graphics.blit(texture, i, j, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        if(menu.isLit()) graphics.blitSprite(RenderPipelines.GUI_TEXTURED, flame, 14, 14, 0, 0, i + 56, j + 36, 14, 14);
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, DivineFurnaceScreen.PROGRESS_ARROW_SPRITE, 24, 16, 0, 0, i + 79, j + 34, Mth.ceil(menu.getBurnProgress() * 24F), 16);
    }
}