package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelBiphron;
import naturix.divinerpg.objects.entities.entity.vethea.Biphron;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBiphron extends RenderLiving<Biphron> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/biphron.png");
	private final ModelBiphron modelEntity;
    
	public RenderBiphron(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiphron(), 1F);
        modelEntity = (ModelBiphron) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Biphron entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Biphron> {

	        @Override
	        public Render<? super Biphron> createRenderFor(RenderManager manager) {
	            return new RenderBiphron(manager, new ModelBiphron(), 1F);
	        }
	    }

	}