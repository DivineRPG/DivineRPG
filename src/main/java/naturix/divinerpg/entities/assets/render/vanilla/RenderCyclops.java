package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelCyclops;
import naturix.divinerpg.entities.entity.vanilla.Cyclops;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCyclops extends RenderLiving<Cyclops> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/cyclops.png");
    
	public RenderCyclops(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCyclops(), 1F);
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Cyclops entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Cyclops> {

	        @Override
	        public Render<? super Cyclops> createRenderFor(RenderManager manager) {
	            return new RenderCyclops(manager, new ModelCyclops(), 0.5F);
	        }
	    }

	}