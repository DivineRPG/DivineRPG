package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelCadillion;
import naturix.divinerpg.entities.entity.twilight.Cadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCadillion extends RenderLiving<Cadillion> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/cadillion.png");
	private final ModelCadillion ModelCadillion;
    
	public RenderCadillion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), 1F);
        ModelCadillion = (ModelCadillion) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Cadillion entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Cadillion> {

	        @Override
	        public Render<? super Cadillion> createRenderFor(RenderManager manager) {
	            return new RenderCadillion(manager, new ModelCadillion(), 0.5F);
	        }
	    }

	}