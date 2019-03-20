package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelTwilightArcher;
import naturix.divinerpg.objects.entities.entity.twilight.TwilightArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTwilightArcher extends RenderLiving<TwilightArcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/twilight_archer.png");
	private final ModelTwilightArcher ModelTwilightArcher;
    
	public RenderTwilightArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwilightArcher(), 1F);
        ModelTwilightArcher = (ModelTwilightArcher) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(TwilightArcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<TwilightArcher> {

	        @Override
	        public Render<? super TwilightArcher> createRenderFor(RenderManager manager) {
	            return new RenderTwilightArcher(manager, new ModelTwilightArcher(), 0.5F);
	        }
	    }

	}