package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelDenseDemon;
import naturix.divinerpg.objects.entities.entity.twilight.DenseDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDenseDemon extends RenderLiving<DenseDemon> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dense_demon.png");
	private final ModelDenseDemon ModelDenseDemon;
    
	public RenderDenseDemon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDenseDemon(), 1F);
        ModelDenseDemon = (ModelDenseDemon) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(DenseDemon entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<DenseDemon> {

	        @Override
	        public Render<? super DenseDemon> createRenderFor(RenderManager manager) {
	            return new RenderDenseDemon(manager, new ModelDenseDemon(), 0.5F);
	        }
	    }

	}