package naturix.divinerpg.entities.assets.render.vethia;


import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vethea.model.ModelHungerHungry;
import naturix.divinerpg.entities.entity.vethia.HungerHungry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHungerHungry extends RenderLiving<HungerHungry> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hungerhungry.png");
	private final ModelHungerHungry modelEntity;
    
	public RenderHungerHungry(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHungerHungry(), 1F);
        modelEntity = (ModelHungerHungry) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(HungerHungry entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<HungerHungry> {

	        @Override
	        public Render<? super HungerHungry> createRenderFor(RenderManager manager) {
	            return new RenderHungerHungry(manager, new ModelHungerHungry(), 1F);
	        }
	    }

	}