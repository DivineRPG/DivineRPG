package divinerpg.client.containers.screen;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.systems.*;
import divinerpg.*;
import divinerpg.client.containers.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.screen.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class PresentBoxScreen extends ContainerScreen<PresentBoxContainer> implements IHasContainer<PresentBoxContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(
            DivineRPG.MODID + ":textures/gui/present_box_gui.png");
    public PresentBoxScreen(PresentBoxContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);

    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }


    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(TEXTURE);

        int edgeSpacingX = (this.width - this.getXSize()) / 2;
        int edgeSpacingY = (this.height - this.getYSize()) / 2;
        this.blit(matrixStack, edgeSpacingX, edgeSpacingY, 0, 0, this.getXSize(), this.getYSize());
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, (this.getXSize() / 2 - this.font.width(title) / 2) + 0, 6, 704255);
        this.font.draw(matrixStack, this.inventory.getDisplayName(), 8, this.getYSize() - 94, 704255);
    }

}