package naturix.divinerpg.entities.assets.render.vethia;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelLheiva;
import naturix.divinerpg.entities.entity.vethia.Lheiva;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderLheiva extends RenderLiving<Lheiva> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lheiva.png");
	private final ModelLheiva modelEntity;
    
	public RenderLheiva(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLheiva(), 1F);
        modelEntity = (ModelLheiva) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Lheiva entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Lheiva> {

	        @Override
	        public Render<? super Lheiva> createRenderFor(RenderManager manager) {
	            return new RenderLheiva(manager, new ModelLheiva(), 1F);
	        }
	    }

	}