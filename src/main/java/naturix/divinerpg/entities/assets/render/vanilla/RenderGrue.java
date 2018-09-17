package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelGrue;
import naturix.divinerpg.entities.entity.vanilla.Grue;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGrue extends RenderLiving<Grue> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/grue.png");
	private final ModelGrue ModelAyereco;
    
	public RenderGrue(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGrue(), 1F);
        ModelAyereco = (ModelGrue) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Grue entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Grue> {

	        @Override
	        public Render<? super Grue> createRenderFor(RenderManager manager) {
	            return new RenderGrue(manager, new ModelGrue(), 0.5F);
	        }
	    }

	}