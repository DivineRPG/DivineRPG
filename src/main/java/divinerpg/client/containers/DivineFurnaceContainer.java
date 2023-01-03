package divinerpg.client.containers;

import com.mojang.blaze3d.systems.*;
import net.minecraftforge.api.distmarker.*;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;

@OnlyIn(Dist.CLIENT)
public abstract class DivineFurnaceContainer<T extends AbstractFurnaceMenu> extends AbstractContainerScreen<T> {
    private final ResourceLocation guiTexture;

    public DivineFurnaceContainer(T screenContainer, Inventory inv, Component titleIn, ResourceLocation guiTexture) {
        super(screenContainer, inv, titleIn);
        this.guiTexture = guiTexture;
    }

    @Override
    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.clearColor(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().getTexture(this.guiTexture);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            this.blit(matrixStack, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.menu.getBurnProgress();
        this.blit(matrixStack, i + 79, j + 34, 176, 14, l + 1, 16);
    }
}