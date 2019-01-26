package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelLiopleurodon;
import naturix.divinerpg.entities.entity.vanilla.Liopleurodon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLiopleurodon extends RenderLiving<Liopleurodon> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/liopleurodon.png");
    
	public RenderLiopleurodon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLiopleurodon(), 1F);
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Liopleurodon entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Liopleurodon> {

	        @Override
	        public Render<? super Liopleurodon> createRenderFor(RenderManager manager) {
	            return new RenderLiopleurodon(manager, new ModelLiopleurodon(), 0.5F);
	        }
	    }

	}