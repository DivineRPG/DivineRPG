package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelEnchantedWarrior;
import naturix.divinerpg.objects.entities.entity.twilight.EnchantedWarrior;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnchantedWarrior extends RenderLiving<EnchantedWarrior> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/enchanted_warrior.png");
	private final ModelEnchantedWarrior ModelEnchantedWarrior;
    
	public RenderEnchantedWarrior(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnchantedWarrior(), 1F);
        ModelEnchantedWarrior = (ModelEnchantedWarrior) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EnchantedWarrior entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EnchantedWarrior> {

	        @Override
	        public Render<? super EnchantedWarrior> createRenderFor(RenderManager manager) {
	            return new RenderEnchantedWarrior(manager, new ModelEnchantedWarrior(), 0.5F);
	        }
	    }

	}