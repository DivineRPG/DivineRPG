package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelGalroid;
import divinerpg.objects.entities.entity.vethea.EntityGalroid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGalroid extends RenderLiving<EntityGalroid> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/galroid.png");
	private final ModelGalroid modelEntity;
    
	public RenderGalroid(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGalroid(), 1F);
        modelEntity = (ModelGalroid) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGalroid entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityGalroid> {

	        @Override
	        public Render<? super EntityGalroid> createRenderFor(RenderManager manager) {
	            return new RenderGalroid(manager, new ModelGalroid(), 1F);
	        }
	    }

	}