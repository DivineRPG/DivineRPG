package naturix.divinerpg.objects.entities.assets.render.vethia;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelTocaxin;
import naturix.divinerpg.objects.entities.entity.vethia.Tocaxin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderTocaxin extends RenderLiving<Tocaxin> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/tocaxin.png");
	private final ModelTocaxin modelEntity;
    
	public RenderTocaxin(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTocaxin(), 1F);
        modelEntity = (ModelTocaxin) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Tocaxin entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Tocaxin> {

	        @Override
	        public Render<? super Tocaxin> createRenderFor(RenderManager manager) {
	            return new RenderTocaxin(manager, new ModelTocaxin(), 1F);
	        }
	    }

	}