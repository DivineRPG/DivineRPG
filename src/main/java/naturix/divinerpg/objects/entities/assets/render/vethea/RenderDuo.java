package naturix.divinerpg.objects.entities.assets.render.vethea;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelDuo;
import naturix.divinerpg.objects.entities.entity.vethea.Duo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderDuo extends RenderLiving<Duo> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/duo.png");
	private final ModelDuo modelEntity;
    
	public RenderDuo(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDuo(), 1F);
        modelEntity = (ModelDuo) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Duo entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Duo> {

	        @Override
	        public Render<? super Duo> createRenderFor(RenderManager manager) {
	            return new RenderDuo(manager, new ModelDuo(), 1F);
	        }
	    }

	}