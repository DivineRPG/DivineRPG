package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelAyeraco;
import naturix.divinerpg.entities.entity.vanilla.AyeracoGreen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAyeracoGreen extends RenderLiving<AyeracoGreen> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ayeraco_green.png");
	private final ModelAyeraco ModelAyereco;
    
	public RenderAyeracoGreen(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAyeraco(), 1F);
        ModelAyereco = (ModelAyeraco) super.mainModel;

    } 


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(AyeracoGreen entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<AyeracoGreen> {

	        @Override
	        public Render<? super AyeracoGreen> createRenderFor(RenderManager manager) {
	            return new RenderAyeracoGreen(manager, new ModelAyeraco(), 0.5F);
	        }
	    }

	}