package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelIceMan;
import naturix.divinerpg.entities.entity.vanilla.IceMan;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderIceMan extends RenderLiving<IceMan> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/iceman.png");
	private final ModelIceMan ModelAyereco;
    
	public RenderIceMan(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelIceMan(), 1F);
        ModelAyereco = (ModelIceMan) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(IceMan entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<IceMan> {

	        @Override
	        public Render<? super IceMan> createRenderFor(RenderManager manager) {
	            return new RenderIceMan(manager, new ModelIceMan(), 0.5F);
	        }
	    }

	}