package naturix.divinerpg.entities.assets.render.twilight;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelCadillion;
import naturix.divinerpg.entities.entity.twilight.MortumCadillion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderMortumCadillion extends RenderLiving<MortumCadillion> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mortum_cadillion.png");
	private final ModelCadillion ModelCadillion;
    
	public RenderMortumCadillion(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCadillion(), 1F);
        ModelCadillion = (ModelCadillion) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(MortumCadillion entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<MortumCadillion> {

	        @Override
	        public Render<? super MortumCadillion> createRenderFor(RenderManager manager) {
	            return new RenderMortumCadillion(manager, new ModelCadillion(), 0.5F);
	        }
	    }

	}