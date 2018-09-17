package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelHusk;
import naturix.divinerpg.entities.entity.vanilla.Husk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHusk extends RenderLiving<Husk> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/husk.png");
	private final ModelHusk ModelAyereco;
    
	public RenderHusk(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHusk(), 1F);
        ModelAyereco = (ModelHusk) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(Husk entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<Husk> {

	        @Override
	        public Render<? super Husk> createRenderFor(RenderManager manager) {
	            return new RenderHusk(manager, new ModelHusk(), 0.5F);
	        }
	    }

	}