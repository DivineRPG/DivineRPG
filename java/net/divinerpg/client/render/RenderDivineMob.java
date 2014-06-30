package net.divinerpg.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderDivineMob extends RenderLiving {
	
    private ResourceLocation texture;

	public RenderDivineMob(ModelBase model, float shadowSize, ResourceLocation tex) {
        super(model, shadowSize);
        texture = tex;
    }
	
	public RenderDivineMob(ModelBase model, ResourceLocation tex) {
        this(model, 0.0F, tex);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }
}