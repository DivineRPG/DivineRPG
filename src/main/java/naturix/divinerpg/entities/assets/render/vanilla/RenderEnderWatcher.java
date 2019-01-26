package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelWatcherEnd;
import naturix.divinerpg.entities.entity.vanilla.EnderWatcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnderWatcher extends RenderLiving<EnderWatcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ender_watcher.png");
    
	public RenderEnderWatcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWatcherEnd(), 1F);
    }

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EnderWatcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EnderWatcher> {

	        @Override
	        public Render<? super EnderWatcher> createRenderFor(RenderManager manager) {
	            return new RenderEnderWatcher(manager, new ModelWatcherEnd(), 0.5F);
	        }
	    }

	}