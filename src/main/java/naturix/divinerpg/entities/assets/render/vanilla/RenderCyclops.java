package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.entity.vanilla.Cyclops;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCyclops extends RenderLiving<Cyclops>
{
    private static final ResourceLocation ZOMBIE_TEXTURES = new ResourceLocation("divinerpg:textures/entity/cyclops.png");
    /** Scale of the model to use */
    private final float scale;

    public RenderCyclops(RenderManager p_i47206_1_, float p_i47206_2_)
    {
        super(p_i47206_1_, new ModelZombie(), 0.5F * p_i47206_2_);
        this.scale = p_i47206_2_;
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = new ModelZombie(0.5F, true);
                this.modelArmor = new ModelZombie(1.0F, true);
            }
        });
    }

    public void transformHeldFull3DItemLayer()
    {
        GlStateManager.translate(0.0F, 0.1875F, 0.0F);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(Cyclops entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Cyclops entity)
    {
        return ZOMBIE_TEXTURES;
    }

}