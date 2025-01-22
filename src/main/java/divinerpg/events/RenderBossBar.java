package divinerpg.events;

import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.boss.EntityAyeraco;
import divinerpg.entities.boss.EntitySunstorm;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.BossHealthOverlay;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

@EventBusSubscriber(modid = DivineRPG.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderBossBar implements LayeredDraw.Layer {
    private static final String KEY = "textures/gui/boss_bar/";

    @SubscribeEvent
    public static void registerGUI(RegisterGuiLayersEvent event) {
        event.registerBelowAll(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "boss_bar"), new RenderBossBar());
    }

    @Override
    public void render(GuiGraphics gui, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        if (!mc.options.hideGui && mc.gameMode.getPlayerMode() != GameType.SPECTATOR) {
            // Check if there are any vanilla boss bars being rendered
            BossHealthOverlay bossHealthOverlay = mc.gui.getBossOverlay();
            if (bossHealthOverlay.events.size() > 0) {
                // If more than one boss bar is present, do not render DivineRPG boss bar
                if (bossHealthOverlay.events.size() > 1) {
                    return;
                }
                // Otherwise, render the DivineRPG boss bar below the vanilla boss bar
                gui.pose().pushPose();
                gui.pose().translate(0, 30, 0); // Move DivineRPG boss bar below vanilla boss bar
                renderDivineRPGBossBar(gui);
                gui.pose().popPose();
            } else {
                // If no vanilla boss bar exists, render the DivineRPG boss bar normally
                renderDivineRPGBossBar(gui);
            }
        }
    }

    private void renderDivineRPGBossBar(GuiGraphics gui) {
        Minecraft mc = Minecraft.getInstance();
        LivingEntity boss = getBossEntity();
        if (boss != null) {
            mc.getProfiler().push("divinerpg_boss_bar");
            ResourceLocation bossTexture = getBossTexture(boss);
            if (bossTexture != null) {
                RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
                RenderSystem.setShaderTexture(0, bossTexture);
                renderBossHealthBar(gui, boss);
            }
            mc.getProfiler().pop();
        }
    }

    private LivingEntity getBossEntity() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return null;
        return mc.level.getEntitiesOfClass(EntityDivineBoss.class, mc.player.getBoundingBox().inflate(50)).stream().findFirst().orElse(null);
    }

    private ResourceLocation getBossTexture(LivingEntity boss) {
        String registryName = BuiltInRegistries.ENTITY_TYPE.getKey(boss.getType()).getPath();

        if (boss instanceof EntityAyeraco) {
            byte variant = ((EntityAyeraco) boss).getVariant();
            String color = getAyeracoColor(variant);
            registryName = color + "_ayeraco";
        } else if (boss instanceof EntitySunstorm) {
            registryName = "sunstorm";
        }
        return ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, KEY + registryName + ".png");
    }

    private String getAyeracoColor(byte variant) {
        return switch (variant) {
            case 0 -> "blue";
            case 1 -> "green";
            case 2 -> "pink";
            case 3 -> "purple";
            case 4 -> "red";
            case 5 -> "yellow";
            default -> "white";
        };
    }

    private void renderBossHealthBar(GuiGraphics gui, LivingEntity boss) {
        Minecraft mc = Minecraft.getInstance();
        int windowWidth = mc.getWindow().getGuiScaledWidth();
        int barLength = boss instanceof EntitySunstorm ? 210 : 182;
        int barHeight = boss instanceof EntitySunstorm ? 32 : 10;
        int barDisX = (windowWidth - barLength) / 2;
        int barDisY = 12;
        float healthPercentage = boss.getHealth() / boss.getMaxHealth();
        int healthWidth = (int) (healthPercentage * barLength);

        if (boss instanceof EntitySunstorm) {
            gui.blit(getBossTexture(boss), barDisX, barDisY, 0, barHeight + 1, barLength, barHeight);
            gui.blit(getBossTexture(boss), barDisX, barDisY, 0, 1, healthWidth, barHeight);
        } else {
            gui.blit(getBossTexture(boss), barDisX, barDisY, 0, barHeight, barLength, barHeight);
            gui.blit(getBossTexture(boss), barDisX, barDisY, 0, 0, healthWidth, barHeight);
        }
    }
}
