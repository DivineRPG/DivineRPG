package net.divinerpg.client.render.entity.vethea;

import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.entities.vethea.EntityGalroid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGalroid extends RenderDivineMob
{
    public RenderGalroid(ModelBase var1, float var2, ResourceLocation textureLoc)
    {
        super(var1, var2, textureLoc);
    }

    public void renderGalroid(EntityGalroid var1, double var2, double var4, double var6, float var8, float var9)
    {
        super.doRender(var1, var2, var4, var6, var8, var9);
    }

    @Override
    public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.renderGalroid((EntityGalroid)var1, var2, var4, var6, var8, var9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.renderGalroid((EntityGalroid)var1, var2, var4, var6, var8, var9);
    }
}