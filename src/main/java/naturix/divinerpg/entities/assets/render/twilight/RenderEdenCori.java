package naturix.divinerpg.entities.assets.render.twilight;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelCori;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderEdenCori extends RenderLiving<naturix.divinerpg.entities.entity.arcana.EdenCori> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/eden_cori.png");
	private final ModelCori ModelCori;
    
	public RenderEdenCori(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCori(), 1F);
        ModelCori = (ModelCori) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(naturix.divinerpg.entities.entity.arcana.EdenCori entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<naturix.divinerpg.entities.entity.arcana.EdenCori> {

	        @Override
	        public Render<? super naturix.divinerpg.entities.entity.arcana.EdenCori> createRenderFor(RenderManager manager) {
	            return new RenderEdenCori(manager, new ModelCori(), 0.5F);
	        }
	    }

	}