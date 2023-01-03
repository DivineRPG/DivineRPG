package divinerpg.events;


import com.mojang.blaze3d.systems.RenderSystem;
import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.config.ClientConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
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

    @SubscribeEvent
    public void renderGameOverlayEvent(RenderGuiOverlayEvent.Post event) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        Gui ui = mc.gui;

        int windowWidth = this.mc.getWindow().getGuiScaledWidth();
        int windowHeight = this.mc.getWindow().getGuiScaledHeight();
        int yLocation = windowHeight - ClientConfig.arcanaY.get();
        int xLocation = windowWidth - ClientConfig.arcanaX.get();

            mc.player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                if(ClientConfig.hideArcanaBar.get() != false) {
                    if (Mth.clamp(Math.floor(arcana.getArcana() / arcana.getMaxArcana() * 100), 0, 100) != 100) {
                        ui.blit(event.getPoseStack(), xLocation, yLocation, 0, 0, 100, 9);
                        ui.blit(event.getPoseStack(), xLocation, yLocation, 0, 9, (int) Math.floor(arcana.getArcana() / arcana.getMaxArcana() * 100), 18);
                    }
                } else {
                        ui.blit(event.getPoseStack(), xLocation, yLocation, 0, 0, 100, 9);
                        ui.blit(event.getPoseStack(), xLocation, yLocation, 0, 9, (int) Math.floor(arcana.getArcana() / arcana.getMaxArcana() * 100), 18);
                    }
            });
        }

}
