package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelSamek;
import naturix.divinerpg.objects.entities.entity.twilight.Verek;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVerek extends RenderLiving<Verek> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/varek.png");
	private final ModelSamek ModelSamek;
    
	public RenderVerek(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSamek(), 1F);
        ModelSamek = (ModelSamek) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Verek entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Verek> {

	        @Override
	        public Render<? super Verek> createRenderFor(RenderManager manager) {
	            return new RenderVerek(manager, new ModelSamek(), 0.5F);
	        }
	    }

	}