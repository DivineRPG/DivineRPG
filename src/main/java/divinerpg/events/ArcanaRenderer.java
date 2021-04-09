package divinerpg.events;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.config.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;

@OnlyIn(Dist.CLIENT)
public class ArcanaRenderer {

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            Minecraft mc = Minecraft.getInstance();
            float width = mc.getWindow().getGuiScaledWidth() - Config.arcanaX.get(), height = mc.getWindow().getGuiScaledHeight() - Config.arcanaY.get();
            mc.getTextureManager().bind(new ResourceLocation(DivineRPG.MODID, "textures/gui/arcana_bar.png"));
            //TODO - seek help rendering
        }
    }


    private int getPercents() {
        if (ArcanaProvider.ARCANA_CAP.getDefaultInstance() != null) {
            float result = ArcanaProvider.ARCANA_CAP.getDefaultInstance().getArcana() / ArcanaProvider.ARCANA_CAP.getDefaultInstance().getMaxArcana() * 100;
            return (int) MathHelper.clamp(Math.floor(result), 0, 100);
        }

        return 0;
    }
}
