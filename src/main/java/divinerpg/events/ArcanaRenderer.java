package divinerpg.events;


import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.attachments.Arcana;
import divinerpg.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent;

@OnlyIn(Dist.CLIENT)
public class ArcanaRenderer extends Gui {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/gui/arcana_bar.png");
	Minecraft mc;
    public ArcanaRenderer() {
        super(Minecraft.getInstance());
        this.mc = Minecraft.getInstance();
    }
    static long counter = 180;
    static float previousAmount = 0F;
    @SubscribeEvent
    public void renderGameOverlayEvent(CustomizeGuiOverlayEvent.BossEventProgress event) {
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        GuiGraphics gui = event.getGuiGraphics();

        int windowWidth = mc.getWindow().getGuiScaledWidth();
        int windowHeight = mc.getWindow().getGuiScaledHeight();
        int yLocation = windowHeight - ClientConfig.ARCANAY;
        int xLocation = windowWidth - ClientConfig.ARCANAX;

        if(ClientConfig.HIDE_ARCANA_BAR) {
        	float arcana = Arcana.getAmount(mc.player);
        	if(previousAmount != arcana) {
        		previousAmount = arcana;
        		counter = mc.level.getGameTime() + 40L;
        	}
            if(counter - mc.level.getGameTime() > 0) {
                gui.blit(TEXTURE, xLocation, yLocation, 0, 0, 100, 9);
                gui.blit(TEXTURE, xLocation, yLocation, 0, 9, (int) (arcana / Arcana.getMaxArcana(mc.player) * 100), 18);
            }
        } else {
            gui.blit(TEXTURE, xLocation, yLocation, 0, 0, 100, 9);
            gui.blit(TEXTURE, xLocation, yLocation, 0, 9, (int) (Arcana.getAmount(mc.player) / Arcana.getMaxArcana(mc.player) * 100), 18);
        }
    }
}