package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelAridWarrior;
import naturix.divinerpg.entities.entity.vanilla.AridWarrior;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderAridWarrior extends RenderLiving<AridWarrior> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/arid_warrior.png");
    
	public RenderAridWarrior(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelAridWarrior(), 1F);
    }

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(AridWarrior entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<AridWarrior> {

	        @Override
	        public Render<? super AridWarrior> createRenderFor(RenderManager manager) {
	            return new RenderAridWarrior(manager, new ModelAridWarrior(), 0.5F);
	        }
	    }

	}