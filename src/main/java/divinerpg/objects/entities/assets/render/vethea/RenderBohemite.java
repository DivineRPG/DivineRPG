package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelBohemite;
import divinerpg.objects.entities.entity.vethea.Bohemite;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBohemite extends RenderLiving<Bohemite> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/bohemite.png");
	private final ModelBohemite modelEntity;
    
	public RenderBohemite(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBohemite(), 1F);
        modelEntity = (ModelBohemite) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Bohemite entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Bohemite> {

	        @Override
	        public Render<? super Bohemite> createRenderFor(RenderManager manager) {
	            return new RenderBohemite(manager, new ModelBohemite(), 1F);
	        }
	    }

	}