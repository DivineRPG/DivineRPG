package naturix.divinerpg.entities.assets.render.iceika;

import naturix.divinerpg.entities.assets.model.iceika.model.ModelGlacide;
import naturix.divinerpg.entities.entity.iceika.Glacide;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderGlacide extends RenderLiving<Glacide> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/glacon.png");
	private final ModelGlacide modelEntity;
    
	public RenderGlacide(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGlacide(), 1F);
        modelEntity = (ModelGlacide) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Glacide entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Glacide> {

	        @Override
	        public Render<? super Glacide> createRenderFor(RenderManager manager) {
	            return new RenderGlacide(manager, new ModelGlacide(), 1F);
	        }
	    }

	}