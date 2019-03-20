package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelCryptKeeper;
import naturix.divinerpg.objects.entities.entity.vethea.CryptKeeper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCryptKeeper extends RenderLiving<CryptKeeper> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/crypt_keeper.png");
	private final ModelCryptKeeper modelEntity;
    
	public RenderCryptKeeper(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCryptKeeper(), 1F);
        modelEntity = (ModelCryptKeeper) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(CryptKeeper entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<CryptKeeper> {

	        @Override
	        public Render<? super CryptKeeper> createRenderFor(RenderManager manager) {
	            return new RenderCryptKeeper(manager, new ModelCryptKeeper(), 1F);
	        }
	    }

	}