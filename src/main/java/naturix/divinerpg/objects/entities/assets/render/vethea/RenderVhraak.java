package naturix.divinerpg.objects.entities.assets.render.vethea;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelVhraak;
import naturix.divinerpg.objects.entities.entity.vethea.Vhraak;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderVhraak extends RenderLiving<Vhraak> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/vhraak.png");
	private final ModelVhraak modelEntity;
    
	public RenderVhraak(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelVhraak(), 1F);
        modelEntity = (ModelVhraak) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Vhraak entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Vhraak> {

	        @Override
	        public Render<? super Vhraak> createRenderFor(RenderManager manager) {
	            return new RenderVhraak(manager, new ModelVhraak(), 1F);
	        }
	    }

	}