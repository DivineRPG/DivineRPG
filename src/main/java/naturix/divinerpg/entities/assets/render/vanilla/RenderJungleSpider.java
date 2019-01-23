package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelJungleSpider;
import naturix.divinerpg.entities.entity.vanilla.JungleSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJungleSpider extends RenderLiving<JungleSpider> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jungle_spider.png");
	private final ModelJungleSpider ModelAyereco;
    
	public RenderJungleSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelJungleSpider(), 1F);
        ModelAyereco = (ModelJungleSpider) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(JungleSpider entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<JungleSpider> {

	        @Override
	        public Render<? super JungleSpider> createRenderFor(RenderManager manager) {
	            return new RenderJungleSpider(manager, new ModelJungleSpider(), 0.5F);
	        }
	    }

	}