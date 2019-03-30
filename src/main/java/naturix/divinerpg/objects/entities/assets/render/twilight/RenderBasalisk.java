package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelBasalisk;
import naturix.divinerpg.objects.entities.entity.twilight.Basilisk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBasalisk extends RenderLiving<Basilisk> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/basalisk.png");
	private final ModelBasalisk ModelBasalisk;
    
	public RenderBasalisk(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBasalisk(), 1F);
        ModelBasalisk = (ModelBasalisk) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Basilisk entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Basilisk> {

	        @Override
	        public Render<? super Basilisk> createRenderFor(RenderManager manager) {
	            return new RenderBasalisk(manager, new ModelBasalisk(), 0.5F);
	        }
	    }

	}