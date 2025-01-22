package divinerpg.events;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.boss.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
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
        String name = event.getBossEvent().getName().getString();
        List<Entity> bosses = mc.level.getEntities(mc.player, mc.player.getBoundingBox().inflate(256, 32, 256), (e) -> e.getName().getString().equals(name));
        if(bosses != null) for(Entity e : bosses) if(e instanceof EntityDivineBoss) {
            event.setCanceled(true);
            mc.getProfiler().push("divineBossHealth");
            ResourceLocation[] bossTexture = getBossTextures(e);
            drawBar(event, bossTexture[0], bossTexture[1]);
            mc.getProfiler().pop();
            return;
        }
    }
    private ResourceLocation[] getBossTextures(Entity boss) {
        String registryName = BuiltInRegistries.ENTITY_TYPE.getKey(boss.getType()).getPath();
        if(boss instanceof EntityAyeraco) {
            String color = getAyeracoColor(((EntityAyeraco) boss).getVariant());
            registryName = color + "_ayeraco";
        } else if(boss instanceof EntitySunstorm) return new ResourceLocation[] {SUNSTORM, SUNSTORM_BACKGROUND};
        return new ResourceLocation[] {ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, KEY + registryName), ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, KEY + registryName + "_background")};
    }
    private String getAyeracoColor(byte variant) {
        return switch(variant) {
            case 0 -> "blue";
            case 1 -> "green";
            case 2 -> "pink";
            case 3 -> "purple";
            case 4 -> "red";
            case 5 -> "yellow";
            default -> "white";
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
