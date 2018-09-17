package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelPumpkinSpider;
import naturix.divinerpg.entities.entity.vanilla.PumpkinSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderPumpkinSpider extends RenderLiving<PumpkinSpider> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/spider_pumpkin.png");
	private final ModelPumpkinSpider ModelAyereco;
    
	public RenderPumpkinSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelPumpkinSpider(), 1F);
        ModelAyereco = (ModelPumpkinSpider) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(PumpkinSpider entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<PumpkinSpider> {

	        @Override
	        public Render<? super PumpkinSpider> createRenderFor(RenderManager manager) {
	            return new RenderPumpkinSpider(manager, new ModelPumpkinSpider(), 0.5F);
	        }
	    }

	}