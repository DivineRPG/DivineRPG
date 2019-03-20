package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelAngryBunny;
import naturix.divinerpg.objects.entities.entity.twilight.TameAngryBunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
 
public class RenderTameAngryBunny extends RenderLiving<TameAngryBunny> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/tamed_angry_bunny.png");
	private final ModelAngryBunny ModelAngryBunny;
    
	public RenderTameAngryBunny(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAngryBunny(), 1F);
        ModelAngryBunny = (ModelAngryBunny) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(TameAngryBunny entity) {
        return texture;
		}

	 public static class Factory implements IRenderFactory<TameAngryBunny> {

	        @Override
	        public Render<? super TameAngryBunny> createRenderFor(RenderManager manager) {
	            return new RenderTameAngryBunny(manager, new ModelAngryBunny(), 0.5F);
	        }
	    }

	}