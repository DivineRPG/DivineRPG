package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelLadyLuna;
import naturix.divinerpg.objects.entities.entity.vethea.LadyLuna;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLadyLuna extends RenderLiving<LadyLuna> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lady_luna.png");
	private final ModelLadyLuna modelEntity;
    
	public RenderLadyLuna(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLadyLuna(), 1F);
        modelEntity = (ModelLadyLuna) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(LadyLuna entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<LadyLuna> {

	        @Override
	        public Render<? super LadyLuna> createRenderFor(RenderManager manager) {
	            return new RenderLadyLuna(manager, new ModelLadyLuna(), 1F);
	        }
	    }

	}