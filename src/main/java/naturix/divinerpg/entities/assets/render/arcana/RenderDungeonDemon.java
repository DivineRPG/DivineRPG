package naturix.divinerpg.entities.assets.render.arcana;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.arcana.model.ModelDungeonDemon;
import naturix.divinerpg.entities.entity.arcana.Dramix;
import naturix.divinerpg.entities.entity.arcana.DungeonDemon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDungeonDemon extends RenderLiving<DungeonDemon> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/dungeon_demon.png");
	private final ModelDungeonDemon modelEntity;
    
	public RenderDungeonDemon(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDungeonDemon(), 1F);
        modelEntity = (ModelDungeonDemon) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(DungeonDemon entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<DungeonDemon> {

	        @Override
	        public Render<? super DungeonDemon> createRenderFor(RenderManager manager) {
	            return new RenderDungeonDemon(manager, new ModelDungeonDemon(), 1F);
	        }
	    }

	}