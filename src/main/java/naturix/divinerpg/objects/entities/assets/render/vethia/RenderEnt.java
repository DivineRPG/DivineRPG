package naturix.divinerpg.objects.entities.assets.render.vethia;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelEnt;
import naturix.divinerpg.objects.entities.entity.vethia.Ent;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderEnt extends RenderLiving<Ent> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ent.png");
	private final ModelEnt modelEntity;
    
	public RenderEnt(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnt(), 1F);
        modelEntity = (ModelEnt) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Ent entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Ent> {

	        @Override
	        public Render<? super Ent> createRenderFor(RenderManager manager) {
	            return new RenderEnt(manager, new ModelEnt(), 1F);
	        }
	    }

	}