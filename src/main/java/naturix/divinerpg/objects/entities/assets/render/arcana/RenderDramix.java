package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.arcana.model.ModelDramix;
import naturix.divinerpg.objects.entities.entity.arcana.Dramix;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDramix extends RenderLiving<Dramix> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dramix.png");
	private final ModelDramix modelEntity;
    
	public RenderDramix(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramix(), 1.5F);
        modelEntity = (ModelDramix) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Dramix entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Dramix> {

	        @Override
	        public Render<? super Dramix> createRenderFor(RenderManager manager) {
	            return new RenderDramix(manager, new ModelDramix(), 1.5F);
	        }
	    }

	}