package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelSorcerer;
import naturix.divinerpg.objects.entities.entity.twilight.Sorcerer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSorcerer extends RenderLiving<Sorcerer> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/sorcerer.png");
	private final ModelSorcerer ModelSorcerer;
    
	public RenderSorcerer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSorcerer(), 1F);
        ModelSorcerer = (ModelSorcerer) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Sorcerer entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Sorcerer> {

	        @Override
	        public Render<? super Sorcerer> createRenderFor(RenderManager manager) {
	            return new RenderSorcerer(manager, new ModelSorcerer(), 0.5F);
	        }
	    }

	}