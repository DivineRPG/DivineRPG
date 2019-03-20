package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelTomo;
import naturix.divinerpg.objects.entities.entity.twilight.WildwoodTomo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWildwoodTomo extends RenderLiving<WildwoodTomo> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wildwood_tomo.png");
	private final ModelTomo ModelTomo;
    
	public RenderWildwoodTomo(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTomo(), 1F);
        ModelTomo = (ModelTomo) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(WildwoodTomo entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<WildwoodTomo> {

	        @Override
	        public Render<? super WildwoodTomo> createRenderFor(RenderManager manager) {
	            return new RenderWildwoodTomo(manager, new ModelTomo(), 0.5F);
	        }
	    }

	}