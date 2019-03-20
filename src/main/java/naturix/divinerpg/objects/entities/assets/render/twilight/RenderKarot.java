package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelKarot;
import naturix.divinerpg.objects.entities.entity.twilight.Karot;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKarot extends RenderLiving<Karot> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/karot.png");
	private final ModelKarot ModelKarot;
    
	public RenderKarot(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKarot(), 1F);
        ModelKarot = (ModelKarot) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Karot entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Karot> {

	        @Override
	        public Render<? super Karot> createRenderFor(RenderManager manager) {
	            return new RenderKarot(manager, new ModelKarot(), 0.5F);
	        }
	    }

	}