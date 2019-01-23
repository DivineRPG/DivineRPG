package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelKingScorcher;
import naturix.divinerpg.entities.entity.vanilla.KingOfScorchers;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderKingOfScorchers extends RenderLiving<KingOfScorchers> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/king_of_scorchers.png");
	private final ModelKingScorcher ModelAyereco;
    
	public RenderKingOfScorchers(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelKingScorcher(), 1F);
        ModelAyereco = (ModelKingScorcher) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(KingOfScorchers entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<KingOfScorchers> {

	        @Override
	        public Render<? super KingOfScorchers> createRenderFor(RenderManager manager) {
	            return new RenderKingOfScorchers(manager, new ModelKingScorcher(), 0.5F);
	        }
	    }

	}