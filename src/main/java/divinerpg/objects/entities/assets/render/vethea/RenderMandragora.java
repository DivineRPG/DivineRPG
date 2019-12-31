package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelMandragora;
import divinerpg.objects.entities.entity.vethea.EntityMandragora;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMandragora extends RenderLiving<EntityMandragora> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mandragora.png");
	private final ModelMandragora modelEntity;
    
	public RenderMandragora(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMandragora(), 1F);
        modelEntity = (ModelMandragora) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityMandragora entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityMandragora> {

	        @Override
	        public Render<? super EntityMandragora> createRenderFor(RenderManager manager) {
	            return new RenderMandragora(manager, new ModelMandragora(), 1F);
	        }
	    }

	}