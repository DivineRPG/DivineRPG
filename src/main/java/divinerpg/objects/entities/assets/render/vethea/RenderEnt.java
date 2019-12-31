package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelEnt;
import divinerpg.objects.entities.entity.vethea.EntityEnt;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnt extends RenderLiving<EntityEnt> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ent.png");
	private final ModelEnt modelEntity;
    
	public RenderEnt(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnt(), 1F);
        modelEntity = (ModelEnt) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnt entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityEnt> {

	        @Override
	        public Render<? super EntityEnt> createRenderFor(RenderManager manager) {
	            return new RenderEnt(manager, new ModelEnt(), 1F);
	        }
	    }

	}