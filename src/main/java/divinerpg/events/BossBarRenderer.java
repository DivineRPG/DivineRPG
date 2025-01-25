package divinerpg.events;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.boss.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class BossBarRenderer {
    private static final String KEY = "boss_bar/";
    public static final ResourceLocation
        SUNSTORM = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, KEY + "sunstorm"),
        SUNSTORM_BACKGROUND = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, KEY + "sunstorm_background");
    @SubscribeEvent
    public void renderGameOverlayEvent(CustomizeGuiOverlayEvent.BossEventProgress event) {
        Minecraft mc = Minecraft.getInstance();
        Component component = event.getBossEvent().getName();
        String name = component.getString();
        List<Entity> bosses = mc.level.getEntities(mc.player, mc.player.getBoundingBox().inflate(256, 64, 256), (e) -> e.getName().getString().equals(name));
        if(bosses != null) for(Entity e : bosses) if(e instanceof EntityDivineBoss || e instanceof EntityTheWatcher) {
            event.setCanceled(true);
            ResourceLocation[] bossTextures = getBossTextures(e);
            drawBar(event, bossTextures[0], bossTextures[1]);
            ((MutableComponent) component).setStyle(component.getStyle().withBold(true));
            event.getGuiGraphics().drawString(mc.font, component, (event.getGuiGraphics().guiWidth() >> 1) - (mc.font.width(component) >> 1), event.getY() + 1, 16777215);
            return;
        }
    }
    private ResourceLocation[] getBossTextures(Entity boss) {
        String registryName = BuiltInRegistries.ENTITY_TYPE.getKey(boss.getType()).getPath();
        if(boss instanceof EntityAyeraco a) registryName = getAyeracoColor(a.getVariant());
        else if(boss instanceof EntitySunstorm) return new ResourceLocation[] {SUNSTORM, SUNSTORM_BACKGROUND};
        return new ResourceLocation[] {ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, KEY + registryName), ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, KEY + registryName + "_background")};
    }
    private String getAyeracoColor(byte variant) {
        return switch(variant) {
            case 6 -> "blue_ayeraco";
            case 1 -> "green_ayeraco";
            case 2 -> "pink_ayeraco";
            case 3 -> "purple_ayeraco";
            case 4 -> "red_ayeraco";
            case 5 -> "yellow_ayeraco";
            default -> "white_ayeraco";
        };
    }
    private void drawBar(CustomizeGuiOverlayEvent.BossEventProgress event, ResourceLocation texture, ResourceLocation background) {
        drawBar(event, 1F, background);
        float progress = event.getBossEvent().getProgress();
        if(progress > 0F) drawBar(event, progress, texture);
    }
    private void drawBar(CustomizeGuiOverlayEvent.BossEventProgress event, float progress, ResourceLocation texture) {
        RenderSystem.enableBlend();
        if(texture == SUNSTORM || texture == SUNSTORM_BACKGROUND) event.getGuiGraphics().blitSprite(texture, 210, 32, 0, 0, event.getX() - 14, event.getY() - 11, Mth.lerpDiscrete(progress, 0, 210), 32);
        else event.getGuiGraphics().blitSprite(texture, 182, 10, 0, 0, event.getX(), event.getY(), Mth.lerpDiscrete(progress, 0, 182), 10);
        RenderSystem.disableBlend();
    }
}
