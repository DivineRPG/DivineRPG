package naturix.divinerpg.objects.entities.assets.render.vethia;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelCymesoid;
import naturix.divinerpg.objects.entities.entity.vethia.Cymesoid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderCymesoid extends RenderLiving<Cymesoid> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/cymesoid.png");
	private final ModelCymesoid modelEntity;
    
	public RenderCymesoid(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCymesoid(), 1F);
        modelEntity = (ModelCymesoid) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Cymesoid entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Cymesoid> {

	        @Override
	        public Render<? super Cymesoid> createRenderFor(RenderManager manager) {
	            return new RenderCymesoid(manager, new ModelCymesoid(), 1F);
	        }
	    }

	}