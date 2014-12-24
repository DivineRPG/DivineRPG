package net.divinerpg.client.render.entity.iceika;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.entity.iceika.model.ModelFrosty;
import net.divinerpg.entities.iceika.EntityFrosty;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFrosty extends RenderLiving
{
    public RenderFrosty() {
        super(new ModelFrosty(), 1);
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		if(entity instanceof EntityFrosty && ((EntityFrosty)entity).angerLevel > 0) return EntityResourceLocation.FROSTY_ANGRY;
		return EntityResourceLocation.FROSTY;
	}
}