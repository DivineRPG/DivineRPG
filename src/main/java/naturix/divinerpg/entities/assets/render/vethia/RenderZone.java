package naturix.divinerpg.entities.assets.render.vethia;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelZone;
import naturix.divinerpg.entities.entity.vethia.Zone;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderZone extends RenderLiving<Zone> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/zone.png");
	private final ModelZone modelEntity;
    
	public RenderZone(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelZone(), 1F);
        modelEntity = (ModelZone) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Zone entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Zone> {

	        @Override
	        public Render<? super Zone> createRenderFor(RenderManager manager) {
	            return new RenderZone(manager, new ModelZone(), 1F);
	        }
	    }

	}