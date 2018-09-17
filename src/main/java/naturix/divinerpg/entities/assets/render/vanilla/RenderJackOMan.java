package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelJackOMan;
import naturix.divinerpg.entities.entity.vanilla.JackOMan;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJackOMan extends RenderLiving<JackOMan> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jackoman.png");
	private final ModelJackOMan ModelAyereco;
    
	public RenderJackOMan(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelJackOMan(), 1F);
        ModelAyereco = (ModelJackOMan) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(JackOMan entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<JackOMan> {

	        @Override
	        public Render<? super JackOMan> createRenderFor(RenderManager manager) {
	            return new RenderJackOMan(manager, new ModelJackOMan(), 0.5F);
	        }
	    }

	}