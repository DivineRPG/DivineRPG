package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelScorcher;
import naturix.divinerpg.entities.entity.vanilla.Scorcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderScorcher extends RenderLiving<Scorcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/scorcher.png");
    
	public RenderScorcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelScorcher(), 1F);
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Scorcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Scorcher> {

	        @Override
	        public Render<? super Scorcher> createRenderFor(RenderManager manager) {
	            return new RenderScorcher(manager, new ModelScorcher(), 0.5F);
	        }
	    }

	}