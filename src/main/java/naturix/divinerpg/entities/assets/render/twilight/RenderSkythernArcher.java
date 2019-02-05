package naturix.divinerpg.entities.assets.render.twilight;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelEnchantedArcher;
import naturix.divinerpg.entities.entity.twilight.SkythernArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderSkythernArcher extends RenderLiving<SkythernArcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/skythern_archer.png");
	private final ModelEnchantedArcher ModelEnchantedArcher;
    
	public RenderSkythernArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnchantedArcher(), 1F);
        ModelEnchantedArcher = (ModelEnchantedArcher) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(SkythernArcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<SkythernArcher> {

	        @Override
	        public Render<? super SkythernArcher> createRenderFor(RenderManager manager) {
	            return new RenderSkythernArcher(manager, new ModelEnchantedArcher(), 0.5F);
	        }
	    }

	}