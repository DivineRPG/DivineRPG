package naturix.divinerpg.entities.assets.render.arcana;

import naturix.divinerpg.entities.assets.model.arcana.model.ModelParasecta;
import naturix.divinerpg.entities.entity.arcana.Parasecta;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderParasecta extends RenderLiving<Parasecta> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/parasecta.png");
	private final ModelParasecta modelEntity;
    
	public RenderParasecta(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelParasecta(), 0.5F);
        modelEntity = (ModelParasecta) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Parasecta entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Parasecta> {

	        @Override
	        public Render<? super Parasecta> createRenderFor(RenderManager manager) {
	            return new RenderParasecta(manager, new ModelParasecta(), 0.5F);
	        }
	    }

	}