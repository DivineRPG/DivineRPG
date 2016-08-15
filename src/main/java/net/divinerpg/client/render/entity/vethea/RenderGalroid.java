package net.divinerpg.client.render.entity.vethea;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.vethea.EntityGalroid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGalroid extends RenderLiving
{
    public RenderGalroid(ModelBase var1, float var2) {
        super(var1, var2);
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		if(entity.isEntityInvulnerable()) return EntityResourceLocation.GALROID_INVULNERABLE;
		return EntityResourceLocation.GALROID;
	}
}