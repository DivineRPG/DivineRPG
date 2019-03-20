package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelLorga;
import naturix.divinerpg.objects.entities.entity.vethea.Lorga;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLorga extends RenderLiving<Lorga> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lorga.png");
	private final ModelLorga modelEntity;
    
	public RenderLorga(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLorga(), 1F);
        modelEntity = (ModelLorga) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Lorga entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Lorga> {

	        @Override
	        public Render<? super Lorga> createRenderFor(RenderManager manager) {
	            return new RenderLorga(manager, new ModelLorga(), 1F);
	        }
	    }

	}