package naturix.divinerpg.entities.assets.render;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelEye;
import naturix.divinerpg.entities.entity.Rotatick;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRotatick extends RenderLiving<Rotatick> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/rotatick.png");
	private final ModelEye ModelEye;
    
	public RenderRotatick(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEye(), 1F);
        ModelEye = (ModelEye) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Rotatick entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Rotatick> {

	        @Override
	        public Render<? super Rotatick> createRenderFor(RenderManager manager) {
	            return new RenderRotatick(manager, new ModelEye(), 0.5F);
	        }
	    }

	}