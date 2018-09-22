package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelHoverStinger;
import naturix.divinerpg.entities.entity.vethia.HoverStinger;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHoverStinger extends RenderLiving<HoverStinger> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hover_stinger.png");
	private final ModelHoverStinger modelEntity;
    
	public RenderHoverStinger(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHoverStinger(), 1F);
        modelEntity = (ModelHoverStinger) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(HoverStinger entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<HoverStinger> {

	        @Override
	        public Render<? super HoverStinger> createRenderFor(RenderManager manager) {
	            return new RenderHoverStinger(manager, new ModelHoverStinger(), 1F);
	        }
	    }

	}