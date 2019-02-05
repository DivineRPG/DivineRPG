package naturix.divinerpg.entities.assets.render.vethia;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelKazrotic;
import naturix.divinerpg.entities.entity.vethia.Kazrotic;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderKazrotic extends RenderLiving<Kazrotic> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/kazrotic.png");
	private final ModelKazrotic modelEntity;
    
	public RenderKazrotic(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKazrotic(), 1F);
        modelEntity = (ModelKazrotic) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Kazrotic entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Kazrotic> {

	        @Override
	        public Render<? super Kazrotic> createRenderFor(RenderManager manager) {
	            return new RenderKazrotic(manager, new ModelKazrotic(), 1F);
	        }
	    }

	}