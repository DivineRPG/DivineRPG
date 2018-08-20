package naturix.divinerpg.entities.assets.render;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelShark;
import naturix.divinerpg.entities.entity.LandShark;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderShark extends RenderLiving<LandShark> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/shark.png");
	private final ModelShark ModelShark;
    
	public RenderShark(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelShark(), 1F);
        ModelShark = (ModelShark) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(LandShark entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<LandShark> {

	        @Override
	        public Render<? super LandShark> createRenderFor(RenderManager manager) {
	            return new RenderShark(manager, new ModelShark(), 0.5F);
	        }
	    }

	}