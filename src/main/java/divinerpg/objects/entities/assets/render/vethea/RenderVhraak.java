package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelVhraak;
import divinerpg.objects.entities.entity.vethea.EntityVhraak;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVhraak extends RenderLiving<EntityVhraak> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/vhraak.png");
	private final ModelVhraak modelEntity;
    
	public RenderVhraak(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelVhraak(), 1F);
        modelEntity = (ModelVhraak) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityVhraak entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityVhraak> {

	        @Override
	        public Render<? super EntityVhraak> createRenderFor(RenderManager manager) {
	            return new RenderVhraak(manager, new ModelVhraak(), 1F);
	        }
	    }

	}