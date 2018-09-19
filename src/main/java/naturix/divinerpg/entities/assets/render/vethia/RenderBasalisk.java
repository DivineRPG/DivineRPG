package naturix.divinerpg.entities.assets.render.vethia;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelBasalisk;
import naturix.divinerpg.entities.entity.vethia.Basalisk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBasalisk extends RenderLiving<Basalisk> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/basalisk.png");
	private final ModelBasalisk modelEntity;
    
	public RenderBasalisk(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBasalisk(), 1F);
        modelEntity = (ModelBasalisk) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Basalisk entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Basalisk> {

	        @Override
	        public Render<? super Basalisk> createRenderFor(RenderManager manager) {
	            return new RenderBasalisk(manager, new ModelBasalisk(), 1F);
	        }
	    }

	}