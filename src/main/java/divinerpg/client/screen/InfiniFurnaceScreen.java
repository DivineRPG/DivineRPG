package divinerpg.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.client.menu.InfiniFurnaceMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;

public abstract class InfiniFurnaceScreen<T extends InfiniFurnaceMenu> extends AbstractContainerScreen<T> implements RecipeUpdateListener {
	public static final ResourceLocation RECIPE_BUTTON_LOCATION = new ResourceLocation("textures/gui/recipe_button.png");
	public final AbstractFurnaceRecipeBookComponent recipeBookComponent = new SmeltingRecipeBookComponent();
	private boolean widthTooNarrow;
	private final ResourceLocation texture;
	private final int titleColor;
	private final int invColor;

	public InfiniFurnaceScreen(T container, Inventory inv, Component c, ResourceLocation location, int titleColor, int invColor) {
		super(container, inv, c);
		this.texture = location;
		this.titleColor = titleColor;
		this.invColor = invColor;
	}

	@Override public RecipeBookComponent getRecipeBookComponent() {
		return recipeBookComponent;
	}

	@Override public void recipesUpdated() {
		recipeBookComponent.recipesUpdated();
	}

	@Override
	public void removed() {
		if (this.minecraft.player != null) {
			this.menu.removed(this.minecraft.player);
		}
	      super.removed();
	}

	@Override
	protected void renderLabels(GuiGraphics p_281635_, int p_282681_, int p_283686_) {
		p_281635_.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, titleColor, false);
		p_281635_.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, invColor, false);
	}

	@Override
	protected void renderBg(GuiGraphics stack, float f, int ii, int jj) {
	      RenderSystem.setShader(GameRenderer::getPositionTexShader);
	      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	      RenderSystem.setShaderTexture(0, texture);
	      int i = leftPos, j = topPos;
		stack.blit(texture, i, j, 0, 0, imageWidth, imageHeight);
	      if (menu.isLit()) stack.blit(texture, i + 56, j + 36, 176, 0, 14, 13);
	      int l = menu.getBurnProgress();
		stack.blit(texture, i + 79, j + 34, 176, 14, l + 1, 16);
	}

	@Override
	protected void init() {
		super.init();
		widthTooNarrow = width < 379;
	    recipeBookComponent.init(width, height, minecraft, widthTooNarrow, menu);
	    leftPos = recipeBookComponent.updateScreenPosition(width, imageWidth);
	    addRenderableWidget(new ImageButton(leftPos + 20, height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_LOCATION, (p_97863_) -> {
	         recipeBookComponent.toggleVisibility();
	         leftPos = recipeBookComponent.updateScreenPosition(width, imageWidth);
	         p_97863_.setPosition(leftPos + 20, height / 2 - 49);
	    }));
	    titleLabelX = (imageWidth - font.width(title)) / 2;
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		recipeBookComponent.tick();
	}

	@Override
	public void render(GuiGraphics stack, int i, int j, float f) {
	      renderBackground(stack);
	      if (recipeBookComponent.isVisible() && widthTooNarrow) {
	         renderBg(stack, f, i, j);
	         recipeBookComponent.render(stack, i, j, f);
	      } else {
	         recipeBookComponent.render(stack, i, j, f);
	         super.render(stack, i, j, f);
	         recipeBookComponent.renderGhostRecipe(stack, leftPos, topPos, true, f);
	      }
	      renderTooltip(stack, i, j);
	      recipeBookComponent.renderTooltip(stack, leftPos, topPos, i, j);
	}

	@Override
	public boolean mouseClicked(double p_97834_, double p_97835_, int p_97836_) {
		if (recipeBookComponent.mouseClicked(p_97834_, p_97835_, p_97836_)) return true;
	    else return widthTooNarrow && recipeBookComponent.isVisible() || super.mouseClicked(p_97834_, p_97835_, p_97836_);
	}

	@Override
	protected void slotClicked(Slot p_97848_, int p_97849_, int p_97850_, ClickType p_97851_) {
	      super.slotClicked(p_97848_, p_97849_, p_97850_, p_97851_);
	      recipeBookComponent.slotClicked(p_97848_);
	}

	@Override
	public boolean keyPressed(int p_97844_, int p_97845_, int p_97846_) {
	      return !recipeBookComponent.keyPressed(p_97844_, p_97845_, p_97846_) && super.keyPressed(p_97844_, p_97845_, p_97846_);
	}

	@Override
	protected boolean hasClickedOutside(double p_97838_, double p_97839_, int p_97840_, int p_97841_, int p_97842_) {
	      boolean flag = p_97838_ < (double)p_97840_ || p_97839_ < (double)p_97841_ || p_97838_ >= (double)(p_97840_ + imageWidth) || p_97839_ >= (double)(p_97841_ + this.imageHeight);
	      return recipeBookComponent.hasClickedOutside(p_97838_, p_97839_, leftPos, topPos, imageWidth, imageHeight, p_97842_) && flag;
	}

	@Override
	public boolean charTyped(char p_97831_, int p_97832_) {
	      return recipeBookComponent.charTyped(p_97831_, p_97832_) || super.charTyped(p_97831_, p_97832_);
	}
}
