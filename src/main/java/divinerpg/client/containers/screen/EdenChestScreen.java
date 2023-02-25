package divinerpg.client.containers.screen;

import com.mojang.blaze3d.systems.*;
import divinerpg.*;
import divinerpg.client.containers.*;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class EdenChestScreen extends AbstractContainerScreen<ModChestContainer> implements MenuAccess<ModChestContainer> {
    private static final ResourceLocation GUI_EDEN_CHEST = new ResourceLocation(
            DivineRPG.MODID + ":textures/gui/eden_chest_gui.png");
//    private final int containerRows;
//    private final Inventory playerInventory;

    public EdenChestScreen(ModChestContainer container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

//        this.containerRows = container.slots.size()/9;
        this.imageWidth = 256;
        this.imageHeight = 256;
//        this.playerInventory = playerInventory;

        this.passEvents = false;
    }

    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }


    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_EDEN_CHEST);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        blit(matrixStack, i, j, 0, 0, 256, 256, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, (float)this.titleLabelX, (float)this.titleLabelY, 4210752);
        this.font.draw(matrixStack, this.playerInventoryTitle, (float)this.inventoryLabelX, 128F, 4210752);
    }

}
