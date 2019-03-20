package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelMandragora;
import naturix.divinerpg.objects.entities.entity.vethea.Mandragora;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMandragora extends RenderLiving<Mandragora> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mandragora.png");
	private final ModelMandragora modelEntity;
    
	public RenderMandragora(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMandragora(), 1F);
        modelEntity = (ModelMandragora) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Mandragora entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Mandragora> {

	        @Override
	        public Render<? super Mandragora> createRenderFor(RenderManager manager) {
	            return new RenderMandragora(manager, new ModelMandragora(), 1F);
	        }
	    }

	}