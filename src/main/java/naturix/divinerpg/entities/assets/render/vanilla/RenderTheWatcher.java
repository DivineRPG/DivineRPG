package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelWatcher;
import naturix.divinerpg.entities.entity.vanilla.TheWatcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTheWatcher extends RenderLiving<TheWatcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/the_watcher.png");
	private final ModelWatcher modelEntity;
    
	public RenderTheWatcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWatcher(), 1F);
        modelEntity = (ModelWatcher) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(TheWatcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<TheWatcher> {

	        @Override
	        public Render<? super TheWatcher> createRenderFor(RenderManager manager) {
	            return new RenderTheWatcher(manager, new ModelWatcher(), 1F);
	        }
	    }

	}