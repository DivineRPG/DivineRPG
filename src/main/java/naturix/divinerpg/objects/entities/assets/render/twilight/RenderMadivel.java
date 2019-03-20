package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelMadivel;
import naturix.divinerpg.objects.entities.entity.twilight.Madivel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMadivel extends RenderLiving<Madivel> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/madivel.png");
	private final ModelMadivel ModelMadivel;
    
	public RenderMadivel(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMadivel(), 1F);
        ModelMadivel = (ModelMadivel) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Madivel entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Madivel> {

	        @Override
	        public Render<? super Madivel> createRenderFor(RenderManager manager) {
	            return new RenderMadivel(manager, new ModelMadivel(), 0.5F);
	        }
	    }

	}