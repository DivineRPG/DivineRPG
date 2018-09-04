package naturix.divinerpg.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.arcana.model.ModelRoamer;
import naturix.divinerpg.entities.entity.arcana.Roamer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRoamer extends RenderLiving<Roamer> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/roamer.png");
	private final ModelRoamer ModelRoamer;
    
	public RenderRoamer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRoamer(), 1F);
        ModelRoamer = (ModelRoamer) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Roamer entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Roamer> {

	        @Override
	        public Render<? super Roamer> createRenderFor(RenderManager manager) {
	            return new RenderRoamer(manager, new ModelRoamer(), 0.5F);
	        }
	    }

	}