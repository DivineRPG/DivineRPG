package naturix.divinerpg.entities.assets.render.iceika;

import naturix.divinerpg.entities.entity.iceika.FrostArcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderFrostArcher extends RenderLiving<FrostArcher> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/frost_archer.png");
	private final ModelBiped modelEntity;
    
	public RenderFrostArcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelBiped(), 1F);
        modelEntity = (ModelBiped) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(FrostArcher entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<FrostArcher> {

	        @Override
	        public Render<? super FrostArcher> createRenderFor(RenderManager manager) {
	            return new RenderFrostArcher(manager, new ModelBiped(), 1F);
	        }
	    }

	}