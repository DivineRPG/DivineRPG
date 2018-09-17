package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelKingScorcher;
import naturix.divinerpg.entities.entity.vanilla.KingScorcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKingScorcher extends RenderLiving<KingScorcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/scorcher_king.png");
	private final ModelKingScorcher ModelAyereco;
    
	public RenderKingScorcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKingScorcher(), 1F);
        ModelAyereco = (ModelKingScorcher) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(KingScorcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<KingScorcher> {

	        @Override
	        public Render<? super KingScorcher> createRenderFor(RenderManager manager) {
	            return new RenderKingScorcher(manager, new ModelKingScorcher(), 0.5F);
	        }
	    }

	}