package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelGalroid;
import naturix.divinerpg.entities.entity.vethia.Galroid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGalroid extends RenderLiving<Galroid> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/galroid.png");
	private final ModelGalroid modelEntity;
    
	public RenderGalroid(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGalroid(), 1F);
        modelEntity = (ModelGalroid) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Galroid entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Galroid> {

	        @Override
	        public Render<? super Galroid> createRenderFor(RenderManager manager) {
	            return new RenderGalroid(manager, new ModelGalroid(), 1F);
	        }
	    }

	}