package divinerpg.events;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.attachments.Arcana;
import divinerpg.config.ClientConfig;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.GameType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import static divinerpg.DivineRPG.MODID;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = CLIENT)
public class ArcanaRenderer implements LayeredDraw.Layer {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/gui/arcana_bar.png"), LOC = ResourceLocation.fromNamespaceAndPath(MODID, "arcana_bar");
	static long counter = 180;
    static float previousAmount = 0F;
    @SubscribeEvent
    public static void registerGUI(RegisterGuiLayersEvent event) {event.registerBelowAll(LOC, new ArcanaRenderer());}
    @Override public void render(GuiGraphics gui, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        if(!mc.options.hideGui && mc.gameMode.getPlayerMode() != GameType.SPECTATOR) {
            mc.getProfiler().push("arcBar");
            //TODO: to fix it slowly becoming bright after joining the world (supposed to be always bright)
            RenderSystem.setShaderColor(1, 1, 1, 1);
            RenderSystem.setShaderTexture(0, TEXTURE);
            int windowWidth = mc.getWindow().getGuiScaledWidth();
            int windowHeight = mc.getWindow().getGuiScaledHeight();
            int xLocation = windowWidth - ClientConfig.Values.ARCANA_BAR_POS_X;
            int yLocation = windowHeight - ClientConfig.Values.ARCANA_BAR_POS_Y;
            if(ClientConfig.Values.HIDE_ARCANA_BAR) {
                float arcana = Arcana.getAmount(mc.player);
                if(previousAmount != arcana) {
                    previousAmount = arcana;
                    counter = mc.level.getGameTime() + 40L;
                } if(counter - mc.level.getGameTime() > 0) {
                    gui.blit(TEXTURE, xLocation, yLocation, 0, 0, 100, 9);
                    gui.blit(TEXTURE, xLocation, yLocation, 0, 9, (int)(arcana / Arcana.getMaxArcana(mc.player) * 100), 18);
                }
            } else {
                gui.blit(TEXTURE, xLocation, yLocation, 0, 0, 100, 9);
                gui.blit(TEXTURE, xLocation, yLocation, 0, 9, (int)(Arcana.getAmount(mc.player) / Arcana.getMaxArcana(mc.player) * 100), 18);
            } mc.getProfiler().pop();
        }
    }
}