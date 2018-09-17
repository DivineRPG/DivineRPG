package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelSnapper;
import naturix.divinerpg.entities.entity.vanilla.Snapper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSnapper extends RenderLiving<Snapper> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/snapper.png");
	private final ModelSnapper ModelAyereco;
    
	public RenderSnapper(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSnapper(), 1F);
        ModelAyereco = (ModelSnapper) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Snapper entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Snapper> {

	        @Override
	        public Render<? super Snapper> createRenderFor(RenderManager manager) {
	            return new RenderSnapper(manager, new ModelSnapper(), 0.5F);
	        }
	    }

	}