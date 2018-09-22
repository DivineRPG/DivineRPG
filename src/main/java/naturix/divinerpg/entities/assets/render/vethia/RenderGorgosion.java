package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelGorgosion;
import naturix.divinerpg.entities.entity.vethia.Gorgosion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGorgosion extends RenderLiving<Gorgosion> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/gorgosion.png");
	private final ModelGorgosion modelEntity;
    
	public RenderGorgosion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGorgosion(), 1F);
        modelEntity = (ModelGorgosion) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Gorgosion entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Gorgosion> {

	        @Override
	        public Render<? super Gorgosion> createRenderFor(RenderManager manager) {
	            return new RenderGorgosion(manager, new ModelGorgosion(), 1F);
	        }
	    }

	}