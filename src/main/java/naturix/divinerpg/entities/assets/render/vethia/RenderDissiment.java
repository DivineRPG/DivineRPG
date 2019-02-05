package naturix.divinerpg.entities.assets.render.vethia;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelDissiment;
import naturix.divinerpg.entities.entity.vethia.Dissiment;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderDissiment extends RenderLiving<Dissiment> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dissiment.png");
	private final ModelDissiment modelEntity;
    
	public RenderDissiment(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDissiment(), 1F);
        modelEntity = (ModelDissiment) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Dissiment entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Dissiment> {

	        @Override
	        public Render<? super Dissiment> createRenderFor(RenderManager manager) {
	            return new RenderDissiment(manager, new ModelDissiment(), 1F);
	        }
	    }

	}