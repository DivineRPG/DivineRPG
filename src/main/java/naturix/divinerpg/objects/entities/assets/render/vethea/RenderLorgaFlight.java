package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.ModelLorgaflight;
import naturix.divinerpg.objects.entities.entity.vethea.Lorgaflight;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLorgaFlight extends RenderLiving<Lorgaflight> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lorga_flight.png");
	private final ModelLorgaflight modelEntity;
    
	public RenderLorgaFlight(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLorgaflight(), 1F);
        modelEntity = (ModelLorgaflight) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Lorgaflight entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Lorgaflight> {

	        @Override
	        public Render<? super Lorgaflight> createRenderFor(RenderManager manager) {
	            return new RenderLorgaFlight(manager, new ModelLorgaflight(), 1F);
	        }
	    }
}