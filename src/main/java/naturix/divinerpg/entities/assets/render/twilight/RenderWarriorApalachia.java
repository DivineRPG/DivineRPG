package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelEnchantedWarrior;
import naturix.divinerpg.entities.entity.twilight.ApalachiaWarrior;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWarriorApalachia extends RenderLiving<ApalachiaWarrior> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/warrior_apalachia.png");
	private final ModelEnchantedWarrior ModelEnchantedWarrior;
    
	public RenderWarriorApalachia(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnchantedWarrior(), 1F);
        ModelEnchantedWarrior = (ModelEnchantedWarrior) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(ApalachiaWarrior entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<ApalachiaWarrior> {

	        @Override
	        public Render<? super ApalachiaWarrior> createRenderFor(RenderManager manager) {
	            return new RenderWarriorApalachia(manager, new ModelEnchantedWarrior(), 0.5F);
	        }
	    }

	}