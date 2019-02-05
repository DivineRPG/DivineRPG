package naturix.divinerpg.utils;

import naturix.divinerpg.DivineRPG;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on Feb
 * /04/2019
 */
@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = DivineRPG.modId, value = Side.CLIENT)
public class CustomTextureStitchHandler {
    @SubscribeEvent
    public static void pre (TextureStitchEvent.Pre event){
        TextureMap map = event.getMap();
        map.registerSprite(new ResourceLocation(DivineRPG.modId, "particle/frost"));
    }
}
