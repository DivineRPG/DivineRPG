package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelBunny;
import naturix.divinerpg.objects.entities.entity.twilight.Bunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBunny extends RenderLiving<Bunny> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/bunny.png");
	private final ModelBunny ModelBunny;
    
	public RenderBunny(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBunny(), 1F);
        ModelBunny = (ModelBunny) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Bunny entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Bunny> {

	        @Override
	        public Render<? super Bunny> createRenderFor(RenderManager manager) {
	            return new RenderBunny(manager, new ModelBunny(), 0.5F);
	        }
	    }

	}