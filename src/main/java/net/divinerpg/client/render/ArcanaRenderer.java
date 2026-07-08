package net.divinerpg.client.render;

import net.divinerpg.config.Config;
import net.divinerpg.registries.AttachmentRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import static net.divinerpg.DivineRPG.MODID;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@EventBusSubscriber(modid = MODID, value = CLIENT)
public class ArcanaRenderer {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/gui/arcana_bar.png");
    private static final Identifier LOC = Identifier.fromNamespaceAndPath(MODID, "arcana_bar");

    private static long counter = 180;
    private static float previousAmount = 0F;

    @SubscribeEvent
    public static void registerGUI(RegisterGuiLayersEvent event) {
        event.registerAboveAll(LOC, (gui, delta) -> renderArcana(gui));
    }

    private static void renderArcana(GuiGraphicsExtractor gui) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        var arcanaData = mc.player.getData(AttachmentRegistry.ARCANA);
        float arcana = arcanaData.getValue();
        float max = arcanaData.getMaxValue();

        int x = mc.getWindow().getGuiScaledWidth() - Config.Values.ARCANA_BAR_POS_X;
        int y = mc.getWindow().getGuiScaledHeight() - Config.Values.ARCANA_BAR_POS_Y;

        if (Config.Values.HIDE_ARCANA_BAR) {
            if (previousAmount != arcana) {
                previousAmount = arcana;
                counter = mc.level.getGameTime() + 40L;
            }
            if (counter - mc.level.getGameTime() > 0) {
                draw(gui, x, y, arcana, max);
            }
        } else {
            draw(gui, x, y, arcana, max);
        }
    }

    private static void draw(GuiGraphicsExtractor gui, int x, int y, float arcana, float max) {
        gui.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, 100, 9, 256, 256);
        int progress = (int)((arcana / max) * 100);
        gui.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 9, progress, 9, 256, 256);
    }
}