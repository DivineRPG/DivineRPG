package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelEpiphite;
import naturix.divinerpg.objects.entities.entity.twilight.Epiphite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEpiphite extends RenderLiving<Epiphite> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/epiphite.png");
	private final ModelEpiphite ModelEpiphite;
    
	public RenderEpiphite(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEpiphite(), 1F);
        ModelEpiphite = (ModelEpiphite) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Epiphite entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Epiphite> {

	        @Override
	        public Render<? super Epiphite> createRenderFor(RenderManager manager) {
	            return new RenderEpiphite(manager, new ModelEpiphite(), 0.5F);
	        }
	    }

	}