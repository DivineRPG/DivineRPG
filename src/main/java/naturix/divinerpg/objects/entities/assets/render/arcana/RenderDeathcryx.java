package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.arcana.model.ModelDeathcryx;
import naturix.divinerpg.objects.entities.entity.arcana.Deathcryx;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDeathcryx extends RenderLiving<Deathcryx> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/deathcryx.png");
	private final ModelDeathcryx modelEntity;
    
	public RenderDeathcryx(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDeathcryx(), 1F);
        modelEntity = (ModelDeathcryx) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Deathcryx entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Deathcryx> {

	        @Override
	        public Render<? super Deathcryx> createRenderFor(RenderManager manager) {
	            return new RenderDeathcryx(manager, new ModelDeathcryx(), 1F);
	        }
	    }

	}