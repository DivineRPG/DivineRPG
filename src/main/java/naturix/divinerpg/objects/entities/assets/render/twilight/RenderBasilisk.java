package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.ModelBasilisk;
import naturix.divinerpg.objects.entities.entity.twilight.Basilisk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBasilisk extends RenderLiving<Basilisk> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/basilisk.png");
	private final ModelBasilisk ModelBasilisk;
    
	public RenderBasilisk(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBasilisk(), 1F);
        ModelBasilisk = (ModelBasilisk) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Basilisk entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Basilisk> {

	        @Override
	        public Render<? super Basilisk> createRenderFor(RenderManager manager) {
	            return new RenderBasilisk(manager, new ModelBasilisk(), 0.5F);
	        }
	    }

	}