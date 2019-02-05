package naturix.divinerpg.entities.assets.render.twilight;

import naturix.divinerpg.entities.assets.model.twilight.model.ModelBehemoth;
import naturix.divinerpg.entities.entity.twilight.Bohemoth;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderBehemoth extends RenderLiving<Bohemoth> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/behemoth.png");
	private final ModelBehemoth ModelBehemoth;
    
	public RenderBehemoth(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBehemoth(), 1F);
        ModelBehemoth = (ModelBehemoth) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Bohemoth entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Bohemoth> {

	        @Override
	        public Render<? super Bohemoth> createRenderFor(RenderManager manager) {
	            return new RenderBehemoth(manager, new ModelBehemoth(), 0.5F);
	        }
	    }

	}