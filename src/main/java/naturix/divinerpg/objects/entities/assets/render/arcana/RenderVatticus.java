package naturix.divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.arcana.Vatticus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVatticus extends RenderLiving<Vatticus> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/lord_vatticus.png");
	private final ModelBiped modelEntity;
    
	public RenderVatticus(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), 1.5F);
        modelEntity = (ModelBiped) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Vatticus entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Vatticus> {

	        @Override
	        public Render<? super Vatticus> createRenderFor(RenderManager manager) {
	            return new RenderVatticus(manager, new ModelBiped(), 1.5F);
	        }
	    }

	}