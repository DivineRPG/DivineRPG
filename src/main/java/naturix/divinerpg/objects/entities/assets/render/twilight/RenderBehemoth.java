package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelBehemoth;
import naturix.divinerpg.objects.entities.entity.twilight.Behemoth;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderBehemoth extends RenderLiving<Behemoth> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/behemoth.png");
	private final ModelBehemoth ModelBehemoth;
    
	public RenderBehemoth(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBehemoth(), 1F);
        ModelBehemoth = (ModelBehemoth) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Behemoth entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Behemoth> {

	        @Override
	        public Render<? super Behemoth> createRenderFor(RenderManager manager) {
	            return new RenderBehemoth(manager, new ModelBehemoth(), 0.5F);
	        }
	    }

	}