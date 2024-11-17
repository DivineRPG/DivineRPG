package net.divinerpg.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderDivineMob extends RenderLiving {
	
    private ResourceLocation texture;
    private float scale = 1;

	public RenderDivineMob(ModelBase model, float shadowSize, ResourceLocation tex) {
        super(model, shadowSize);
        texture = tex;
    }
	
	public RenderDivineMob(ModelBase model, float shadowSize, float scale, ResourceLocation tex) {
        super(model, shadowSize);
        texture = tex;
        this.scale = scale;
    }
	
	public RenderDivineMob(ModelBase model, ResourceLocation tex) {
        this(model, 0.0F, tex);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
    
    @Override
    public void preRenderCallback(EntityLivingBase entity, float f) {
    	GL11.glScalef(this.scale, this.scale, this.scale);
    }
}