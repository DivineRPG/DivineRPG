package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelTwins;
import divinerpg.objects.entities.entity.vethea.EntityTwins;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTwins extends RenderLiving<EntityTwins> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/twins.png");
	private final ModelTwins modelEntity;
    
	public RenderTwins(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwins(), 1F);
        modelEntity = (ModelTwins) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTwins entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityTwins> {

	        @Override
	        public Render<? super EntityTwins> createRenderFor(RenderManager manager) {
	            return new RenderTwins(manager, new ModelTwins(), 1F);
	        }
	    }

	}