package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelEnchantedArcher;
import naturix.divinerpg.objects.entities.entity.twilight.EnchantedArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnchantedArcher extends RenderLiving<EnchantedArcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/enchanted_archer.png");
	private final ModelEnchantedArcher ModelEnchantedArcher;
    
	public RenderEnchantedArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnchantedArcher(), 1F);
        ModelEnchantedArcher = (ModelEnchantedArcher) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EnchantedArcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<EnchantedArcher> {

	        @Override
	        public Render<? super EnchantedArcher> createRenderFor(RenderManager manager) {
	            return new RenderEnchantedArcher(manager, new ModelEnchantedArcher(), 0.5F);
	        }
	    }

	}