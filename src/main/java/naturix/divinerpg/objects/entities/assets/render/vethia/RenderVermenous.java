package naturix.divinerpg.objects.entities.assets.render.vethia;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelVermenous;
import naturix.divinerpg.objects.entities.entity.vethia.Vermenous;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderVermenous extends RenderLiving<Vermenous> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/vermenous.png");
	private final ModelVermenous modelEntity;
    
	public RenderVermenous(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelVermenous(), 1F);
        modelEntity = (ModelVermenous) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Vermenous entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Vermenous> {

	        @Override
	        public Render<? super Vermenous> createRenderFor(RenderManager manager) {
	            return new RenderVermenous(manager, new ModelVermenous(), 1F);
	        }
	    }

	}