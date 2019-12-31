package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelVermenous;
import divinerpg.objects.entities.entity.vethea.EntityVermenous;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVermenous extends RenderLiving<EntityVermenous> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/vermenous.png");
	private final ModelVermenous modelEntity;
    
	public RenderVermenous(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelVermenous(), 1F);
        modelEntity = (ModelVermenous) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityVermenous entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityVermenous> {

	        @Override
	        public Render<? super EntityVermenous> createRenderFor(RenderManager manager) {
	            return new RenderVermenous(manager, new ModelVermenous(), 1F);
	        }
	    }

	}