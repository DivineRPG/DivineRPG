package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelQuadro;
import naturix.divinerpg.objects.entities.entity.vethea.Quadro;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderQuadro extends RenderLiving<Quadro> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/quadro.png");
	private final ModelQuadro modelEntity;
    
	public RenderQuadro(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelQuadro(), 1F);
        modelEntity = (ModelQuadro) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Quadro entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Quadro> {

	        @Override
	        public Render<? super Quadro> createRenderFor(RenderManager manager) {
	            return new RenderQuadro(manager, new ModelQuadro(), 1F);
	        }
	    }

	}