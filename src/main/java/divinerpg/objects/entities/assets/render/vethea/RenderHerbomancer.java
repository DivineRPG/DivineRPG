package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelHerbomancer;
import divinerpg.objects.entities.entity.vethea.EntityHerbomancer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHerbomancer extends RenderLiving<EntityHerbomancer> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/herbomancer.png");
	private final ModelHerbomancer modelEntity;
    
	public RenderHerbomancer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHerbomancer(), 1F);
        modelEntity = (ModelHerbomancer) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHerbomancer entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityHerbomancer> {

	        @Override
	        public Render<? super EntityHerbomancer> createRenderFor(RenderManager manager) {
	            return new RenderHerbomancer(manager, new ModelHerbomancer(), 1F);
	        }
	    }

	}