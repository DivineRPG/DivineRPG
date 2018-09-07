package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelCadillion;
import naturix.divinerpg.entities.entity.twilight.ApalachiaCadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCadillionApalachia extends RenderLiving<ApalachiaCadillion> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/cadillion_apalachia.png");
	private final ModelCadillion ModelCadillion;
    
	public RenderCadillionApalachia(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), 1F);
        ModelCadillion = (ModelCadillion) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(ApalachiaCadillion entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<ApalachiaCadillion> {

	        @Override
	        public Render<? super ApalachiaCadillion> createRenderFor(RenderManager manager) {
	            return new RenderCadillionApalachia(manager, new ModelCadillion(), 0.5F);
	        }
	    }

	}