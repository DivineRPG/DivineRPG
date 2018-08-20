package naturix.divinerpg.entities.hostile.render;

import naturix.divinerpg.entities.hostile.entity.dramcryx.JungleStegosaurus;
import naturix.divinerpg.entities.hostile.model.ModelDramcryx;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDramcryx extends RenderLiving<JungleStegosaurus> {
	static RenderManager renderManager;
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dramcryx_jungle.png");
	public RenderDramcryx(float size) {
		super(renderManager, new ModelDramcryx(), size);
	}

	@Override
    public void doRender(JungleStegosaurus entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(JungleStegosaurus p_110775_1_)
    {
        return texture;
    }


}