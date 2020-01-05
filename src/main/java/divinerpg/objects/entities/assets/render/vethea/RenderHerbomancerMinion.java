package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelHerbomancerMinion;
import divinerpg.objects.entities.entity.vethea.EntityHerbomancerMinion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHerbomancerMinion extends RenderLiving<EntityHerbomancerMinion> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/herbomancer.png");
	private final ModelHerbomancerMinion modelEntity;
    
	public RenderHerbomancerMinion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHerbomancerMinion(), 1F);
        modelEntity = (ModelHerbomancerMinion) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHerbomancerMinion entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityHerbomancerMinion> {

	        @Override
	        public Render<? super EntityHerbomancerMinion> createRenderFor(RenderManager manager) {
	            return new RenderHerbomancerMinion(manager, new ModelHerbomancerMinion(), 1F);
	        }
	    }

	}