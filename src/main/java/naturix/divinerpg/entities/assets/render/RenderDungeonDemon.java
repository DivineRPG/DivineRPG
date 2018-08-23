package naturix.divinerpg.entities.assets.render;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.arcana.model.ModelDungeonDemon;
import naturix.divinerpg.entities.entity.DungeonDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDungeonDemon extends RenderLiving<DungeonDemon> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dungeon_demon.png");
	private final ModelDungeonDemon ModelDungeonDemon;
    
	public RenderDungeonDemon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDungeonDemon(), 1F);
        ModelDungeonDemon = (ModelDungeonDemon) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(DungeonDemon entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<DungeonDemon> {

	        @Override
	        public Render<? super DungeonDemon> createRenderFor(RenderManager manager) {
	            return new RenderDungeonDemon(manager, new ModelDungeonDemon(), 0.5F);
	        }
	    }

	}