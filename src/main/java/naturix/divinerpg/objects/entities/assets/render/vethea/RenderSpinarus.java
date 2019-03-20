package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelSpinarusBody;
import naturix.divinerpg.objects.entities.entity.vethea.Spinarus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSpinarus extends RenderLiving<Spinarus> {
	
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
    protected ResourceLocation getEntityTexture(Spinarus entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Spinarus> {

	        @Override
	        public Render<? super Spinarus> createRenderFor(RenderManager manager) {
	            return new RenderSpinarus(manager, new ModelSpinarusBody(), 1F);
	        }
	    }

	}