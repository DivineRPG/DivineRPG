package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelSpinarusBody;
import divinerpg.objects.entities.entity.vethea.EntitySpinarus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSpinarus extends RenderLiving<EntitySpinarus> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/spinarus.png");
	private final ModelSpinarusBody modelEntity;
//	private final ModelSpinarusHead modelEntity2;
//	private final ModelSpinarusTail modelEntity3;
    
	public RenderSpinarus(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSpinarusBody(), 1F);
        modelEntity = (ModelSpinarusBody) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpinarus entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntitySpinarus> {

	        @Override
	        public Render<? super EntitySpinarus> createRenderFor(RenderManager manager) {
	            return new RenderSpinarus(manager, new ModelSpinarusBody(), 1F);
	        }
	    }

	}