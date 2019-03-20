package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.arcana.model.ModelWraith;
import naturix.divinerpg.objects.entities.entity.arcana.Wraith;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWraith extends RenderLiving<Wraith> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wraith.png");
	private final ModelWraith ModelWraith;
    
	public RenderWraith(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWraith(), 1F);
        ModelWraith = (ModelWraith) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Wraith entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Wraith> {

	        @Override
	        public Render<? super Wraith> createRenderFor(RenderManager manager) {
	            return new RenderWraith(manager, new ModelWraith(), 0.5F);
	        }
	    }

	}