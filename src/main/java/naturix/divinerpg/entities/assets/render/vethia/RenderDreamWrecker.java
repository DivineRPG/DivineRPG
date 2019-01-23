package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelDreamwrecker;
import naturix.divinerpg.entities.entity.vethia.Dreamwrecker;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDreamwrecker extends RenderLiving<Dreamwrecker> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dreamwrecker.png");
	private final ModelDreamwrecker modelEntity;
    
	public RenderDreamwrecker(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDreamwrecker(), 1F);
        modelEntity = (ModelDreamwrecker) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Dreamwrecker entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Dreamwrecker> {

	        @Override
	        public Render<? super Dreamwrecker> createRenderFor(RenderManager manager) {
	            return new RenderDreamwrecker(manager, new ModelDreamwrecker(), 1F);
	        }
	    }

	}