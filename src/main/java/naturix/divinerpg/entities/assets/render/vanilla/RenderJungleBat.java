package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelJungleBat;
import naturix.divinerpg.entities.entity.vanilla.JungleBat;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJungleBat extends RenderLiving<JungleBat> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jungle_bat.png");
	private final ModelJungleBat ModelAyereco;
    
	public RenderJungleBat(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelJungleBat(), 0.125F);
        ModelAyereco = (ModelJungleBat) super.mainModel;
    } 

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(JungleBat entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<JungleBat> {

	        @Override
	        public Render<? super JungleBat> createRenderFor(RenderManager manager) {
	            return new RenderJungleBat(manager, new ModelJungleBat(), 0.125F);
	        }
	    }

	}