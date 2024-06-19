package divinerpg.events;


import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.capability.Arcana;
import divinerpg.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class ArcanaRenderer extends Gui {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/gui/arcana_bar.png");
	Minecraft mc;
    public ArcanaRenderer() {
        super(Minecraft.getInstance(), Minecraft.getInstance().getItemRenderer());
        this.mc = Minecraft.getInstance();
    }
    static long counter = 180;
    static float previousAmount = 0F;
    @SubscribeEvent
    public void renderGameOverlayEvent(RenderGuiOverlayEvent.Post event) {
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        GuiGraphics gui = event.getGuiGraphics();

        int windowWidth = mc.getWindow().getGuiScaledWidth();
        int windowHeight = mc.getWindow().getGuiScaledHeight();
        int yLocation = windowHeight - ClientConfig.arcanaY.get();
        int xLocation = windowWidth - ClientConfig.arcanaX.get();

        if(ClientConfig.hideArcanaBar.get()) {
        	if(previousAmount != Arcana.clientAmount) {
        		previousAmount = Arcana.clientAmount;
        		counter = mc.level.getGameTime() + 40L;
        	}
            if(counter - mc.level.getGameTime() > 0) {
                gui.blit(TEXTURE, xLocation, yLocation, 0, 0, 100, 9);
                gui.blit(TEXTURE, xLocation, yLocation, 0, 9, (int) (Arcana.clientAmount / Arcana.clientMax * 100), 18);
            }
        } else {
            gui.blit(TEXTURE, xLocation, yLocation, 0, 0, 100, 9);
            gui.blit(TEXTURE, xLocation, yLocation, 0, 9, (int) (Arcana.clientAmount / Arcana.clientMax * 100), 18);
        }
    }
}