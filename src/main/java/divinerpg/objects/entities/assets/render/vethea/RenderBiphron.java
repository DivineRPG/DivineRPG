package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelBiphron;
import divinerpg.objects.entities.entity.vethea.EntityBiphron;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBiphron extends RenderLiving<EntityBiphron> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/biphron.png");
	private final ModelBiphron modelEntity;
    
	public RenderBiphron(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiphron(), 1F);
        modelEntity = (ModelBiphron) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBiphron entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityBiphron> {

	        @Override
	        public Render<? super EntityBiphron> createRenderFor(RenderManager manager) {
	            return new RenderBiphron(manager, new ModelBiphron(), 1F);
	        }
	    }

	}