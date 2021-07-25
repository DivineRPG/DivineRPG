package divinerpg.client.containers.screen;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.systems.*;
import divinerpg.*;
import divinerpg.client.containers.*;
import net.minecraft.client.gui.screen.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class DreamLampScreen extends ContainerScreen<DreamLampContainer> {
    private ResourceLocation texture = new ResourceLocation(DivineRPG.MODID + ":textures/gui/dream_lamp.png");

    //TODO - fix lamp screen
    public DreamLampScreen(DreamLampContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);

        this.imageWidth = 256;
        this.imageHeight = 256;

        this.passEvents = false;
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.minecraft.getTextureManager().bind(texture);

        int x = (this.width - 256) / 2;
        int y = (this.height - 256) / 2;

        blit(matrixStack, x, y, 0, 0, 256, 256, this.imageWidth, this.imageHeight);
    }
}