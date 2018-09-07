package naturix.divinerpg.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelTomo;
import naturix.divinerpg.entities.entity.twilight.ApalachiaTomo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTomoApalachia extends RenderLiving<ApalachiaTomo> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/tomo_apalachia.png");
	private final ModelTomo ModelTomoApalachia;
    
	public RenderTomoApalachia(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTomo(), 1F);
        ModelTomoApalachia = (ModelTomo) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(ApalachiaTomo entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<ApalachiaTomo> {

	        @Override
	        public Render<? super ApalachiaTomo> createRenderFor(RenderManager manager) {
	            return new RenderTomoApalachia(manager, new ModelTomo(), 0.5F);
	        }
	    }

	}