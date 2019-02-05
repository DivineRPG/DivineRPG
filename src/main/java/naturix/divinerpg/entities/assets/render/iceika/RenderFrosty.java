package naturix.divinerpg.entities.assets.render.iceika;

import naturix.divinerpg.entities.assets.model.iceika.model.ModelFrosty;
import naturix.divinerpg.entities.entity.iceika.Frosty;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderFrosty extends RenderLiving<Frosty> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/frosty.png");
	private final ModelFrosty modelEntity;
    
	public RenderFrosty(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelFrosty(), 1F);
        modelEntity = (ModelFrosty) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Frosty entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Frosty> {

	        @Override
	        public Render<? super Frosty> createRenderFor(RenderManager manager) {
	            return new RenderFrosty(manager, new ModelFrosty(), 1F);
	        }
	    }

	}