package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelSunArcher;
import naturix.divinerpg.objects.entities.entity.twilight.SunArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSunArcher extends RenderLiving<SunArcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/sun_archer.png");
	private final ModelSunArcher ModelSunArcher;
    
	public RenderSunArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSunArcher(), 1F);
        ModelSunArcher = (ModelSunArcher) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(SunArcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<SunArcher> {

	        @Override
	        public Render<? super SunArcher> createRenderFor(RenderManager manager) {
	            return new RenderSunArcher(manager, new ModelSunArcher(), 0.5F);
	        }
	    }

	}