package naturix.divinerpg.entities.assets.render;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelAncientEntity;
import naturix.divinerpg.entities.assets.model.vanilla.model.ModelDramcryx;
import naturix.divinerpg.entities.entity.anciententity.AncientEntity;
import naturix.divinerpg.entities.entity.dramcryx.JungleStegosaurus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAncientEntity extends RenderLiving<AncientEntity> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/anciententity.png");
	private final ModelAncientEntity modelEntity;
    
	public RenderAncientEntity(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAncientEntity(), 8F);
        modelEntity = (ModelAncientEntity) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(AncientEntity entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<AncientEntity> {

	        @Override
	        public Render<? super AncientEntity> createRenderFor(RenderManager manager) {
	            return new RenderAncientEntity(manager, new ModelAncientEntity(), 0.5F);
	        }
	    }

	}