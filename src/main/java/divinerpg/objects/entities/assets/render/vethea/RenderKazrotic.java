package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelKazrotic;
import divinerpg.objects.entities.entity.vethea.EntityKazrotic;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKazrotic extends RenderLiving<EntityKazrotic> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/kazrotic.png");
	private final ModelKazrotic modelEntity;
    
	public RenderKazrotic(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKazrotic(), 1F);
        modelEntity = (ModelKazrotic) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKazrotic entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityKazrotic> {

	        @Override
	        public Render<? super EntityKazrotic> createRenderFor(RenderManager manager) {
	            return new RenderKazrotic(manager, new ModelKazrotic(), 1F);
	        }
	    }

	}