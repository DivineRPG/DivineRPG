package net.divinerpg.client.render.entity.twilight;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.entity.twilight.model.ModelBunny;
import net.divinerpg.entities.twilight.EntityBunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderBunny extends RenderLiving {

	private static final ResourceLocation bunny = EntityResourceLocation.bunny;
	private static final ResourceLocation bunnyTame = EntityResourceLocation.bunnyTamed;
	private static final ResourceLocation angryBunnyTame = EntityResourceLocation.angryBunnyTamed;
	private float scale = 1;

	public RenderBunny(ModelBase par1ModelBase, float shadowSize) {
		super(par1ModelBase, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
	    mainModel = new ModelBunny();
	    EntityBunny b = (EntityBunny)e;
	    ResourceLocation tex = bunny;
	    scale = 1;
        if(b.isTamed()) {
            if(b.getDataWatcher().getWatchableObjectInt(19) == 1) {
                tex = angryBunnyTame;
                scale = 1.2f;
            }
            else tex = bunnyTame;
        }
        return tex;
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase e, float partialTickTime) {
	    super.preRenderCallback(e, partialTickTime);
	    GL11.glScalef(scale, scale, scale);
	}
}