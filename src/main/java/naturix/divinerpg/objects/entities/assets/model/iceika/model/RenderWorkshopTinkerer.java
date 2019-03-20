package naturix.divinerpg.objects.entities.assets.model.iceika.model;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.iceika.WorkshopTinkerer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWorkshopTinkerer extends RenderLiving<WorkshopTinkerer> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/workshop_tinkerer.png");
	private final ModelWorkshop modelEntity;
    
	public RenderWorkshopTinkerer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWorkshop(), 1F);
        modelEntity = (ModelWorkshop) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(WorkshopTinkerer entity) {

        return texture;
    }

	 public static class Factory implements IRenderFactory<WorkshopTinkerer> {

	        @Override
	        public Render<? super WorkshopTinkerer> createRenderFor(RenderManager manager) {
	            return new RenderWorkshopTinkerer(manager, new ModelWorkshop(), 1F);
	        }
	    }

	}