package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelBoheimite;
import naturix.divinerpg.entities.entity.vethia.Bohemite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBohemite extends RenderLiving<Bohemite> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/boheimite.png");
	private final ModelBoheimite modelEntity;
    
	public RenderBohemite(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBoheimite(), 1F);
        modelEntity = (ModelBoheimite) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Bohemite entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Bohemite> {

	        @Override
	        public Render<? super Bohemite> createRenderFor(RenderManager manager) {
	            return new RenderBohemite(manager, new ModelBoheimite(), 1F);
	        }
	    }

	}