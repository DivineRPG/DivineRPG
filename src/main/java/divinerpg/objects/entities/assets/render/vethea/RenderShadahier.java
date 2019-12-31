package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelShadahier;
import divinerpg.objects.entities.entity.vethea.EntityShadahier;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderShadahier extends RenderLiving<EntityShadahier> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/shadahier.png");
	private final ModelShadahier modelEntity;
    
	public RenderShadahier(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelShadahier(), 1F);
        modelEntity = (ModelShadahier) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityShadahier entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityShadahier> {

	        @Override
	        public Render<? super EntityShadahier> createRenderFor(RenderManager manager) {
	            return new RenderShadahier(manager, new ModelShadahier(), 1F);
	        }
	    }

	}