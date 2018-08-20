package naturix.divinerpg.entities.hostile.render;

import naturix.divinerpg.entities.hostile.entity.dramcryx.JungleStegosaurus;
import naturix.divinerpg.entities.hostile.model.ModelDramcryx;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDramcryx extends RenderLiving {
	static RenderManager renderManager;
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dramcryx_jungle.png");
	public RenderDramcryx(float size) {
		super(renderManager, new ModelDramcryx(), size);
	}

	public void doRender(JungleStegosaurus p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(JungleStegosaurus p_110775_1_)
    {
        return texture;
    }

    /*
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    /*protected float handleRotationFloat(JungleStegosaurus p_77044_1_, float p_77044_2_)
    {
        float f1 = p_77044_1_.field_70888_h + (p_77044_1_.field_70886_e - p_77044_1_.field_70888_h) * p_77044_2_;
        float f2 = p_77044_1_.field_70884_g + (p_77044_1_.destPos - p_77044_1_.field_70884_g) * p_77044_2_;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }*/

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((JungleStegosaurus)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((JungleStegosaurus)p_110775_1_);
    }

}