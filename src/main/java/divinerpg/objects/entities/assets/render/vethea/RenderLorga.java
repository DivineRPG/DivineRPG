package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelLorga;
import divinerpg.objects.entities.entity.vethea.EntityLorga;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLorga extends RenderLiving<EntityLorga> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lorga.png");
	private final ModelLorga modelEntity;
    
	public RenderLorga(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLorga(), 1F);
        modelEntity = (ModelLorga) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLorga entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityLorga> {

	        @Override
	        public Render<? super EntityLorga> createRenderFor(RenderManager manager) {
	            return new RenderLorga(manager, new ModelLorga(), 1F);
	        }
	    }

	}