package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelSamek;
import naturix.divinerpg.objects.entities.entity.twilight.Samek;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSamek extends RenderLiving<Samek> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/samek.png");
	private final ModelSamek ModelSamek;
    
	public RenderSamek(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), 1F);
        ModelSamek = (ModelSamek) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Samek entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Samek> {

	        @Override
	        public Render<? super Samek> createRenderFor(RenderManager manager) {
	            return new RenderSamek(manager, new ModelSamek(), 0.5F);
	        }
	    }

	}