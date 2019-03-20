package naturix.divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.iceika.model.ModelWorkshop;
import naturix.divinerpg.objects.entities.entity.iceika.WorkshopMerchant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWorkshopMerchant extends RenderLiving<WorkshopMerchant> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/workshop_merchant.png");
	private final ModelWorkshop modelEntity;
    
	public RenderWorkshopMerchant(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWorkshop(), 1F);
        modelEntity = (ModelWorkshop) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(WorkshopMerchant entity) {

        return texture;
    }

	 public static class Factory implements IRenderFactory<WorkshopMerchant> {

	        @Override
	        public Render<? super WorkshopMerchant> createRenderFor(RenderManager manager) {
	            return new RenderWorkshopMerchant(manager, new ModelWorkshop(), 1F);
	        }
	    }

	}