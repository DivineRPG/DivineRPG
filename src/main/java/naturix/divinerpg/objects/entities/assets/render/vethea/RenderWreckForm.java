package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelWreckForm1;
import naturix.divinerpg.objects.entities.entity.vethea.WreckForm;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWreckForm extends RenderLiving<WreckForm> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wreck_form_1.png");
	private final ModelWreckForm1 modelEntity;
    
	public RenderWreckForm(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWreckForm1(), 1F);
        modelEntity = (ModelWreckForm1) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(WreckForm entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<WreckForm> {

	        @Override
	        public Render<? super WreckForm> createRenderFor(RenderManager manager) {
	            return new RenderWreckForm(manager, new ModelWreckForm1(), 1F);
	        }
	    }

	}