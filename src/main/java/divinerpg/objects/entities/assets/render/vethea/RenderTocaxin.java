package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelTocaxin;
import divinerpg.objects.entities.entity.vethea.EntityTocaxin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTocaxin extends RenderLiving<EntityTocaxin> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/tocaxin.png");
	private final ModelTocaxin modelEntity;
    
	public RenderTocaxin(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTocaxin(), 1F);
        modelEntity = (ModelTocaxin) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTocaxin entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityTocaxin> {

	        @Override
	        public Render<? super EntityTocaxin> createRenderFor(RenderManager manager) {
	            return new RenderTocaxin(manager, new ModelTocaxin(), 1F);
	        }
	    }

	}