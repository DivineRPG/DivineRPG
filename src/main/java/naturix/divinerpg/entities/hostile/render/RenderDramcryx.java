package naturix.divinerpg.entities.hostile.render;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.hostile.dramcryx.JungleStegosaurus;
import naturix.divinerpg.entities.hostile.dramcryx.ModelDramcryx;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDramcryx extends RenderLiving<JungleStegosaurus> {

	    private ResourceLocation mobTexture = new ResourceLocation(DivineRPG.modId, "textures/entity/dramcryx_jungle.png");
	    
	    public static final Factory FACTORY = new Factory();
	    
		public RenderDramcryx(RenderManager rendermanagerIn) {
			super(rendermanagerIn, new ModelDramcryx(), 0.5F);
		}

		@Override
		protected ResourceLocation getEntityTexture(JungleStegosaurus entity) {
			return mobTexture;
		}
		
		public static class Factory implements IRenderFactory<JungleStegosaurus>{

			@Override
			public Render<? super JungleStegosaurus> createRenderFor(RenderManager manager) {
				return new RenderDramcryx(manager);
			}
			
		}

	}