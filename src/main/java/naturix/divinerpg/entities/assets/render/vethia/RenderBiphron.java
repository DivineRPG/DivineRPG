package naturix.divinerpg.entities.assets.render.vethia;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelBoheimite;
import naturix.divinerpg.entities.entity.vethia.Biphron;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderBiphron extends RenderLiving<Biphron> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/biphron.png");
	private final ModelBoheimite modelEntity;
    
	public RenderBiphron(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBoheimite(), 1F);
        modelEntity = (ModelBoheimite) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Biphron entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Biphron> {

	        @Override
	        public Render<? super Biphron> createRenderFor(RenderManager manager) {
	            return new RenderBiphron(manager, new ModelBoheimite(), 1F);
	        }
	    }

	}