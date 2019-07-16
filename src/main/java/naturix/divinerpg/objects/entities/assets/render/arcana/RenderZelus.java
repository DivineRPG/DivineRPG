package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.arcana.Zelus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderZelus extends RenderLiving<Zelus> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/zelus.png");
	private final ModelBiped ModelBiped;
    
	public RenderZelus(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), 1F);
        ModelBiped = (ModelBiped) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Zelus entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Zelus> {

	        @Override
	        public Render<? super Zelus> createRenderFor(RenderManager manager) {
	            return new RenderZelus(manager, new ModelBiped(), 0.5F);
	        }
	    }

	}