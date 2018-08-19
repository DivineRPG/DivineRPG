package naturix.divinerpg.entities.hostile.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDivineMob extends RenderLiving {
	
    private static RenderManager RenderDramcryx;
	private ResourceLocation texture;
    private float scale = 1;

	public RenderDivineMob(ModelBase model, float shadowSize, ResourceLocation tex) {
        super(RenderDramcryx, model, shadowSize);
        texture = tex;
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