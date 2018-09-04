package naturix.divinerpg.entities.assets.render.iceika;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.iceika.model.ModelFractite;
import naturix.divinerpg.entities.entity.iceika.Fractite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFractite extends RenderLiving<Fractite> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/fractite.png");
	private final ModelFractite modelEntity;
    
	public RenderFractite(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelFractite(), 1F);
        modelEntity = (ModelFractite) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Fractite entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Fractite> {

	        @Override
	        public Render<? super Fractite> createRenderFor(RenderManager manager) {
	            return new RenderFractite(manager, new ModelFractite(), 1F);
	        }
	    }

	}