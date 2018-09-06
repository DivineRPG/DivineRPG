package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelEnchantedArcher;
import naturix.divinerpg.entities.entity.twilight.ApalachiaArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderApalachiaArcher extends RenderLiving<ApalachiaArcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/archer_apalachia.png");
	private final ModelEnchantedArcher ModelEnchantedArcher;
    
	public RenderApalachiaArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnchantedArcher(), 1F);
        ModelEnchantedArcher = (ModelEnchantedArcher) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(ApalachiaArcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<ApalachiaArcher> {

	        @Override
	        public Render<? super ApalachiaArcher> createRenderFor(RenderManager manager) {
	            return new RenderApalachiaArcher(manager, new ModelEnchantedArcher(), 0.5F);
	        }
	    }

	}