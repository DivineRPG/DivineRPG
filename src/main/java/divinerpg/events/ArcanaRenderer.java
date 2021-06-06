package divinerpg.events;

import com.mojang.blaze3d.platform.GlStateManager;

import divinerpg.DivineRPG;
import divinerpg.capability.*;
import divinerpg.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ArcanaRenderer {
	
	Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            onTickRender(event);
        }
    }

    @SuppressWarnings("deprecation")
	private void onTickRender(RenderGameOverlayEvent.Post event) {
        if (mc.screen == null) {
            GlStateManager._color4f(1.0F, 1.0F, 1.0F, 1.0F);//resets color

            IngameGui gig = mc.gui;
            int i = this.mc.getWindow().getGuiScaledWidth();
            int k = this.mc.getWindow().getGuiScaledHeight();
            this.mc.getTextureManager().bind(new ResourceLocation(DivineRPG.MODID, "textures/gui/arcana_bar.png"));
            int y = k - Config.arcanaY.get();
            int x = i - Config.arcanaX.get();

        	if(Config.hideArcanaBar.get() != false) {
        		if(getPercents() != 100) {
        			gig.blit(event.getMatrixStack(), x, y, 0, 0, 100, 9);
        			gig.blit(event.getMatrixStack(), x, y, 0, 9, getPercents(), 18);
        		}
        	} 
        	else {
        		gig.blit(event.getMatrixStack(), x, y, 0, 0, 100, 9);
        		gig.blit(event.getMatrixStack(), x, y, 0, 9, getPercents(), 18);    	
        	}
        }
    }

    private int getPercents() {
    	IArcana arcana = mc.player.getCapability(ArcanaProvider.ARCANA_CAP).orElse(new Arcana());
        if (arcana != null) {
            float result = arcana.getArcana() / arcana.getMaxArcana() * 100;

            return (int) MathHelper.clamp(Math.floor(result), 0, 100);
        }

        return 0;
    }
}
