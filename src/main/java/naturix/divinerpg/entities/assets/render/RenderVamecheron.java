package naturix.divinerpg.entities.assets.render;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelVamacheron;
import naturix.divinerpg.entities.entity.Vamecheron;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVamecheron extends RenderLiving<Vamecheron> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/vamacheron.png");
	private final ModelVamacheron modelEntity;
    
	public RenderVamecheron(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelVamacheron(), 1.3F);
        modelEntity = (ModelVamacheron) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Vamecheron entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Vamecheron> {

	        @Override
	        public Render<? super Vamecheron> createRenderFor(RenderManager manager) {
	            return new RenderVamecheron(manager, new ModelVamacheron(), 0.5F);
	        }
	    }

	}