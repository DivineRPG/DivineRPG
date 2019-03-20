package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.arcana.model.ModelRejuvGolem;
import naturix.divinerpg.objects.entities.entity.arcana.RejuvGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRejuvGolem extends RenderLiving<RejuvGolem> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/rejuv_golem.png");
	private final ModelRejuvGolem ModelRejuvGolem;
    
	public RenderRejuvGolem(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRejuvGolem(), 1F);
        ModelRejuvGolem = (ModelRejuvGolem) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(RejuvGolem entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<RejuvGolem> {

	        @Override
	        public Render<? super RejuvGolem> createRenderFor(RenderManager manager) {
	            return new RenderRejuvGolem(manager, new ModelRejuvGolem(), 0.5F);
	        }
	    }

	}