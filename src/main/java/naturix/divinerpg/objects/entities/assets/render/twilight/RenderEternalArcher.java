package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelEternalArcher;
import naturix.divinerpg.objects.entities.entity.twilight.EternalArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEternalArcher extends RenderLiving<EternalArcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/eternal_archer.png");
	private final ModelEternalArcher ModelEternalArcher;
    
	public RenderEternalArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEternalArcher(), 1F);
        ModelEternalArcher = (ModelEternalArcher) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EternalArcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EternalArcher> {

	        @Override
	        public Render<? super EternalArcher> createRenderFor(RenderManager manager) {
	            return new RenderEternalArcher(manager, new ModelEternalArcher(), 0.5F);
	        }
	    }

	}