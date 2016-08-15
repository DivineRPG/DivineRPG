package net.divinerpg.client.render.entity.vanilla;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.vanilla.EntityHellPig;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHellPig extends RenderLiving {

    public RenderHellPig(ModelBase par1ModelBase) {
        super(par1ModelBase, 0.0F);
    }

    protected ResourceLocation getEntityTexture(EntityHellPig pig) {
        return pig.isTamed() ? EntityResourceLocation.hellPigTame : (pig.isAngry() ? EntityResourceLocation.hellPigMad : EntityResourceLocation.hellPig);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.getEntityTexture((EntityHellPig)par1Entity);
    }
}