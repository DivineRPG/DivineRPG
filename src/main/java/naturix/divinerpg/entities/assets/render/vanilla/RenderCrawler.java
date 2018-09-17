package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelCrawler;
import naturix.divinerpg.entities.entity.vanilla.Crawler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCrawler extends RenderLiving<Crawler> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/crawler.png");
	private final ModelCrawler ModelAyereco;
    
	public RenderCrawler(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCrawler(), 1F);
        ModelAyereco = (ModelCrawler) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Crawler entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Crawler> {

	        @Override
	        public Render<? super Crawler> createRenderFor(RenderManager manager) {
	            return new RenderCrawler(manager, new ModelCrawler(), 0.5F);
	        }
	    }

	}