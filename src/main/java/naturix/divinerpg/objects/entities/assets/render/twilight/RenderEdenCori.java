package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelCori;
import naturix.divinerpg.objects.entities.entity.twilight.EdenCori;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEdenCori extends RenderLiving<EdenCori> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/eden_cori.png");
	private final ModelCori ModelCori;
    
	public RenderEdenCori(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCori(), 1F);
        ModelCori = (ModelCori) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EdenCori entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EdenCori> {

	        @Override
	        public Render<? super EdenCori> createRenderFor(RenderManager manager) {
	            return new RenderEdenCori(manager, new ModelCori(), 0.5F);
	        }
	    }

	}