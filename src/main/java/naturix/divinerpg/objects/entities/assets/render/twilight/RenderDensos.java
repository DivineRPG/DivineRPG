package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelDensos;
import naturix.divinerpg.objects.entities.entity.twilight.Densos;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDensos extends RenderLiving<Densos> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/densos.png");
	private final ModelDensos ModelDensos;
    
	public RenderDensos(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDensos(), 1F);
        ModelDensos = (ModelDensos) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Densos entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Densos> {

	        @Override
	        public Render<? super Densos> createRenderFor(RenderManager manager) {
	            return new RenderDensos(manager, new ModelDensos(), 0.5F);
	        }
	    }

	}