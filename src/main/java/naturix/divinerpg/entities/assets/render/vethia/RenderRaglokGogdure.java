package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelRaglokGogdure;
import naturix.divinerpg.entities.entity.vethia.RaglokGogdure;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRaglokGogdure extends RenderLiving<RaglokGogdure> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/raglok_gogdure.png");
	private final ModelRaglokGogdure modelEntity;
    
	public RenderRaglokGogdure(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRaglokGogdure(), 1F);
        modelEntity = (ModelRaglokGogdure) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(RaglokGogdure entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<RaglokGogdure> {

	        @Override
	        public Render<? super RaglokGogdure> createRenderFor(RenderManager manager) {
	            return new RenderRaglokGogdure(manager, new ModelRaglokGogdure(), 1F);
	        }
	    }

	}