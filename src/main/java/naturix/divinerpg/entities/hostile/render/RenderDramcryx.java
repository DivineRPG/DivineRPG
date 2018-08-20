package naturix.divinerpg.entities.hostile.render;

import naturix.divinerpg.entities.hostile.dramcryx.JungleStegosaurus;
import naturix.divinerpg.entities.hostile.dramcryx.ModelDramcryx;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDramcryx extends RenderLiving<JungleStegosaurus> {
    private ResourceLocation mobTexture = new ResourceLocation("divinerpg:textures/entity/dramcryx_jungle.png");
    
    public RenderDramcryx(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelDramcryx(), 0.8F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(JungleStegosaurus entity) {
        return mobTexture;
    }

    public static final RenderDramcryx.Factory FACTORY = new RenderDramcryx.Factory();

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    @Override
    protected void preRenderCallback(JungleStegosaurus entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static class Factory implements IRenderFactory<JungleStegosaurus> {

        @Override
        public Render<? super JungleStegosaurus> createRenderFor(RenderManager manager) {
            return new RenderDramcryx(manager);
        }

    }

}