package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelKaros;
import naturix.divinerpg.objects.entities.entity.vethea.Karos;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKaros extends RenderLiving<Karos> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/karos.png");
	private final ModelKaros modelEntity;
    
	public RenderKaros(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKaros(), 1F);
        modelEntity = (ModelKaros) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Karos entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Karos> {

	        @Override
	        public Render<? super Karos> createRenderFor(RenderManager manager) {
	            return new RenderKaros(manager, new ModelKaros(), 1F);
	        }
	    }

	}