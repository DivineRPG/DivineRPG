package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelHiveSoldier;
import naturix.divinerpg.objects.entities.entity.vethea.HiveSoldier;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHiveSoldier extends RenderLiving<HiveSoldier> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hive_soldier.png");
	private final ModelHiveSoldier modelEntity;
    
	public RenderHiveSoldier(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHiveSoldier(), 1F);
        modelEntity = (ModelHiveSoldier) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(HiveSoldier entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<HiveSoldier> {

	        @Override
	        public Render<? super HiveSoldier> createRenderFor(RenderManager manager) {
	            return new RenderHiveSoldier(manager, new ModelHiveSoldier(), 1F);
	        }
	    }

	}