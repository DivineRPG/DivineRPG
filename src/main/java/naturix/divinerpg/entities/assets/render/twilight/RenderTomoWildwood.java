package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelTomo;
import naturix.divinerpg.entities.entity.twilight.WildwoodTomo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTomoWildwood extends RenderLiving<WildwoodTomo> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/tomo_wildwood.png");
	private final ModelTomo ModelTomo;
    
	public RenderTomoWildwood(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
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
	            return new RenderTomoWildwood(manager, new ModelTomo(), 0.5F);
	        }
	    }

	}