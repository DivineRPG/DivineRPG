package naturix.divinerpg.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelMoonWolf;
import naturix.divinerpg.entities.entity.twilight.MoonWolf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMoonWolf extends RenderLiving<MoonWolf> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wolf_moon.png");
	private final ModelMoonWolf ModelMoonWolf;
    
	public RenderMoonWolf(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMoonWolf(), 1F);
        ModelMoonWolf = (ModelMoonWolf) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(MoonWolf entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<MoonWolf> {

	        @Override
	        public Render<? super MoonWolf> createRenderFor(RenderManager manager) {
	            return new RenderMoonWolf(manager, new ModelMoonWolf(), 0.5F);
	        }
	    }

	}