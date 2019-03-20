package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelMystic;
import naturix.divinerpg.objects.entities.entity.twilight.Mystic;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMystic extends RenderLiving<Mystic> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mystic.png");
	private final ModelMystic ModelMystic;
    
	public RenderMystic(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMystic(), 1F);
        ModelMystic = (ModelMystic) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Mystic entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Mystic> {

	        @Override
	        public Render<? super Mystic> createRenderFor(RenderManager manager) {
	            return new RenderMystic(manager, new ModelMystic(), 0.5F);
	        }
	    }

	}