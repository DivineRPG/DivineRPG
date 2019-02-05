package naturix.divinerpg.entities.assets.render.twilight;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelBasalisk;
import naturix.divinerpg.entities.entity.twilight.Basalisk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderBasalisk extends RenderLiving<Basalisk> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/basalisk.png");
	private final ModelBasalisk ModelBasalisk;
    
	public RenderBasalisk(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBasalisk(), 1F);
        ModelBasalisk = (ModelBasalisk) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Basalisk entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Basalisk> {

	        @Override
	        public Render<? super Basalisk> createRenderFor(RenderManager manager) {
	            return new RenderBasalisk(manager, new ModelBasalisk(), 0.5F);
	        }
	    }

	}