package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.ModelTwins;
import naturix.divinerpg.objects.entities.entity.vethea.Twins;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTwins extends RenderLiving<Twins> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/twins.png");
	private final ModelTwins modelEntity;
    
	public RenderTwins(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTwins(), 1F);
        modelEntity = (ModelTwins) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Twins entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Twins> {

	        @Override
	        public Render<? super Twins> createRenderFor(RenderManager manager) {
	            return new RenderTwins(manager, new ModelTwins(), 1F);
	        }
	    }

	}