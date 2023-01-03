package divinerpg.client.containers.screen;

import com.mojang.blaze3d.systems.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.containers.*;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.entity.player.*;

public class DreamLampScreen extends AbstractContainerScreen<DreamLampContainer> {
    private ResourceLocation texture = new ResourceLocation(DivineRPG.MODID + ":textures/gui/dream_lamp.png");

    public DreamLampScreen(DreamLampContainer container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

        this.titleLabelY -= 2;
    }
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, texture);

        int edgeSpacingX = (this.width - this.getXSize()) / 2;
        int edgeSpacingY = (this.height - this.getYSize()) / 2;
        this.blit(matrixStack, edgeSpacingX, edgeSpacingY, 0, 0, this.getXSize(), this.getYSize());
    }
    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, 12, 8, 4210752);
        this.font.draw(matrixStack, playerInventoryTitle, 12, 70, 4210752);
    }
}