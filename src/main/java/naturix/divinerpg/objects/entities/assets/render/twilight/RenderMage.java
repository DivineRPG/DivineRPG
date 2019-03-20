package naturix.divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.twilight.model.ModelMage;
import naturix.divinerpg.objects.entities.entity.twilight.Mage;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMage extends RenderLiving<Mage> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/mage.png");
	private final ModelMage ModelMage;
    
	public RenderMage(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelMage(), 1F);
        ModelMage = (ModelMage) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Mage entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Mage> {

	        @Override
	        public Render<? super Mage> createRenderFor(RenderManager manager) {
	            return new RenderMage(manager, new ModelMage(), 0.5F);
	        }
	    }

	}