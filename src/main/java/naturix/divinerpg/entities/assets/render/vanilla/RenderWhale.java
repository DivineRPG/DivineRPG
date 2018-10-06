package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelWhale;
import naturix.divinerpg.entities.entity.vanilla.Whale;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWhale extends RenderLiving<Whale> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/whale.png");
	private final ModelWhale ModelAyereco;
    
	public RenderWhale(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWhale(), 1F);
        ModelAyereco = (ModelWhale) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Whale entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Whale> {

	        @Override
	        public Render<? super Whale> createRenderFor(RenderManager manager) {
	            return new RenderWhale(manager, new ModelWhale(), 0.5F);
	        }
	    }

	}