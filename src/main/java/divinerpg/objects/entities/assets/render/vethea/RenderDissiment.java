package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelDissiment;
import divinerpg.objects.entities.entity.vethea.Dissiment;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

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