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

public class EdenChestScreen extends ContainerScreen<ModChestContainer> implements IHasContainer<ModChestContainer> {
    private static final ResourceLocation GUI_EDEN_CHEST = new ResourceLocation(
            DivineRPG.MODID + ":textures/gui/eden_chest_gui.png");
    private final int containerRows;
    private final PlayerInventory playerInventory;

    public EdenChestScreen(ModChestContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);

        this.containerRows = container.slots.size()/9;
        this.imageWidth = 256;
        this.imageHeight = 256;
        this.playerInventory = playerInventory;

        this.passEvents = false;
    }

    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }


    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.minecraft.getTextureManager().bind(GUI_EDEN_CHEST);

        int x = (this.width - 256) / 2;
        int y = (this.height - 256) / 2;

        blit(matrixStack, x, y, 0, 0, 256, 256, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, (float)this.titleLabelX, (float)this.titleLabelY, 4210752);
        this.font.draw(matrixStack, this.inventory.getDisplayName(), (float)this.inventoryLabelX, 128F, 4210752);
    }

}