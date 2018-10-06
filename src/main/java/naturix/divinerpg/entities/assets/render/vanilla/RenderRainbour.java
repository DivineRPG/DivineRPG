package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelRainbour;
import naturix.divinerpg.entities.entity.vanilla.Rainbour;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRainbour extends RenderLiving<Rainbour> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/rainbour.png");
	private final ModelRainbour ModelAyereco;
    
	public RenderRainbour(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRainbour(), 1F);
        ModelAyereco = (ModelRainbour) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Rainbour entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Rainbour> {

	        @Override
	        public Render<? super Rainbour> createRenderFor(RenderManager manager) {
	            return new RenderRainbour(manager, new ModelRainbour(), 0.5F);
	        }
	    }

	}