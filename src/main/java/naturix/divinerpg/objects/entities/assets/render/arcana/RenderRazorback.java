package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.arcana.ModelRazorback;
import naturix.divinerpg.objects.entities.entity.arcana.Razorback;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRazorback extends RenderLiving<Razorback> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/razorback.png");
	private final ModelRazorback ModelRazorback;
    
	public RenderRazorback(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRazorback(), 1F);
        ModelRazorback = (ModelRazorback) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Razorback entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Razorback> {

	        @Override
	        public Render<? super Razorback> createRenderFor(RenderManager manager) {
	            return new RenderRazorback(manager, new ModelRazorback(), 0.5F);
	        }
	    }

	}