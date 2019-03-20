package naturix.divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vethea.model.ModelHiveQueen;
import naturix.divinerpg.objects.entities.entity.vethea.HiveQueen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHiveQueen extends RenderLiving<HiveQueen> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hive_queen.png");
	private final ModelHiveQueen modelEntity;
    
	public RenderHiveQueen(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHiveQueen(), 1F);
        modelEntity = (ModelHiveQueen) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(HiveQueen entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<HiveQueen> {

	        @Override
	        public Render<? super HiveQueen> createRenderFor(RenderManager manager) {
	            return new RenderHiveQueen(manager, new ModelHiveQueen(), 1F);
	        }
	    }

	}