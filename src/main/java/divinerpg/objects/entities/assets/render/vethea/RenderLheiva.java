package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelLheiva;
import divinerpg.objects.entities.entity.vethea.EntityLheiva;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLheiva extends RenderLiving<EntityLheiva> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lheiva.png");
	private final ModelLheiva modelEntity;
    
	public RenderLheiva(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLheiva(), 1F);
        modelEntity = (ModelLheiva) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLheiva entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityLheiva> {

	        @Override
	        public Render<? super EntityLheiva> createRenderFor(RenderManager manager) {
	            return new RenderLheiva(manager, new ModelLheiva(), 1F);
	        }
	    }

	}