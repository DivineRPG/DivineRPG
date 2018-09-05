package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelTwilightGolem;
import naturix.divinerpg.entities.entity.twilight.TwilightGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTwilightGolem extends RenderLiving<TwilightGolem> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/golem_twilight.png");
	private final ModelTwilightGolem ModelTwilightGolem;
    
	public RenderTwilightGolem(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightGolem(), 1F);
        ModelTwilightGolem = (ModelTwilightGolem) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(TwilightGolem entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<TwilightGolem> {

	        @Override
	        public Render<? super TwilightGolem> createRenderFor(RenderManager manager) {
	            return new RenderTwilightGolem(manager, new ModelTwilightGolem(), 0.5F);
	        }
	    }

	}