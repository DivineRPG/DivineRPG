package naturix.divinerpg.objects.entities.assets.render.vethea;


import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelHungerHungry;
import naturix.divinerpg.objects.entities.entity.vethea.TheHunger;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTheHunger extends RenderLiving<TheHunger> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/the_hunger.png");
	private final ModelHungerHungry modelEntity;
    
	public RenderTheHunger(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHungerHungry(), 1F);
        modelEntity = (ModelHungerHungry) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(TheHunger entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<TheHunger> {

	        @Override
	        public Render<? super TheHunger> createRenderFor(RenderManager manager) {
	            return new RenderTheHunger(manager, new ModelHungerHungry(), 1F);
	        }
	    }

	}