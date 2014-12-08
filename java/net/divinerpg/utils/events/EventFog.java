package net.divinerpg.utils.events;

import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.client.event.EntityViewRenderEvent.RenderFogEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EventFog {

	@SubscribeEvent
	public void renderFog(FogDensity evt) {
		double d0 = evt.entity.posY + (double)evt.entity.getEyeHeight();
        int i = MathHelper.floor_double(evt.entity.posX);
        int j = MathHelper.floor_float((float)MathHelper.floor_double(d0));
        int k = MathHelper.floor_double(evt.entity.posZ);
		if(evt.entity.worldObj.getBlock(i, j, k) == IceikaBlocks.iceikaLava){
			evt.density = 2f;
			evt.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void renderFog(FogColors evt) {
		double d0 = evt.entity.posY + (double)evt.entity.getEyeHeight();
        int i = MathHelper.floor_double(evt.entity.posX);
        int j = MathHelper.floor_float((float)MathHelper.floor_double(d0));
        int k = MathHelper.floor_double(evt.entity.posZ);
		if(evt.entity.worldObj.getBlock(i, j, k) == IceikaBlocks.iceikaLava) {
			evt.red = 181;
			evt.green = 209;
			evt.blue = 255;
		}
	}
	
}
