package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.arcana.ModelDramix;
import naturix.divinerpg.objects.entities.entity.arcana.Dramix;
import naturix.divinerpg.objects.entities.entity.arcana.EntityConstructor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderConstructor extends RenderLiving<EntityConstructor> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/constructor.png");
	private final ModelDramix modelEntity;
    
	public RenderConstructor(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramix(), 0.4F);
        //FIXME - Constructor will need scaling
        modelEntity = (ModelDramix) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityConstructor entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EntityConstructor> {

	        @Override
	        public Render<? super EntityConstructor> createRenderFor(RenderManager manager) {
	            return new RenderConstructor(manager, new ModelDramix(), 0.4F);
	        }
	    }

	}