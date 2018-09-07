package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelTwilightGolem;
import naturix.divinerpg.entities.entity.twilight.WildwoodGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGolemWildwood extends RenderLiving<WildwoodGolem> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/golem_wildwood.png");
	private final ModelTwilightGolem ModelTwilightGolem;
    
	public RenderGolemWildwood(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightGolem(), 1F);
        ModelTwilightGolem = (ModelTwilightGolem) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(WildwoodGolem entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<WildwoodGolem> {

	        @Override
	        public Render<? super WildwoodGolem> createRenderFor(RenderManager manager) {
	            return new RenderGolemWildwood(manager, new ModelTwilightGolem(), 0.5F);
	        }
	    }

	}