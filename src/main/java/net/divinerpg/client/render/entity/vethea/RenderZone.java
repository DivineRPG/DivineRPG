package net.divinerpg.client.render.entity.vethea;

import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.entities.vethea.EntityZone;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderZone extends RenderDivineMob {
	
    public RenderZone(ModelBase var1, float var2, ResourceLocation loc) {
        super(var1, var2, loc);
    }

    public void renderZone(EntityZone var1, double var2, double var4, double var6, float var8, float var9) {
        super.doRender(var1, var2, var4, var6, var8, var9);
    }

    @Override
    public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.renderZone((EntityZone)var1, var2, var4, var6, var8, var9);
    }

    @Override
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.renderZone((EntityZone)var1, var2, var4, var6, var8, var9);
    }
}