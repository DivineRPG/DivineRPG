package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelWreckForm1;
import divinerpg.objects.entities.entity.vethea.Wreck;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWreck extends RenderLiving<Wreck> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wreck_form_1.png");
	private final ModelWreckForm1 modelEntity;
    
	public RenderWreck(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWreckForm1(), 1F);
        modelEntity = (ModelWreckForm1) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Wreck entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Wreck> {

	        @Override
	        public Render<? super Wreck> createRenderFor(RenderManager manager) {
	            return new RenderWreck(manager, new ModelWreckForm1(), 1F);
	        }
	    }

	}