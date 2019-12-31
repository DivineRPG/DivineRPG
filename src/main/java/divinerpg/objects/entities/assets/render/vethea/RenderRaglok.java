package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelRaglok;
import divinerpg.objects.entities.entity.vethea.EntityRaglok;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRaglok extends RenderLiving<EntityRaglok> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/raglok_gogdure.png");
	private final ModelRaglok modelEntity;
    
	public RenderRaglok(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRaglok(), 1F);
        modelEntity = (ModelRaglok) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRaglok entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityRaglok> {

	        @Override
	        public Render<? super EntityRaglok> createRenderFor(RenderManager manager) {
	            return new RenderRaglok(manager, new ModelRaglok(), 1F);
	        }
	    }

	}