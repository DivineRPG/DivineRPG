package divinerpg.objects.entities.assets.render.vethea;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vethea.ModelLadyLuna;
import divinerpg.objects.entities.entity.vethea.EntityLadyLuna;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLadyLuna extends RenderLiving<EntityLadyLuna> {
	
	public static final IRenderFactory FACTORY = new Factory();
	private final ModelLadyLuna modelEntity;
    
	public RenderLadyLuna(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLadyLuna(), 1F);
        modelEntity = (ModelLadyLuna) super.mainModel;

    }


	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLadyLuna entity) {
		EntityLadyLuna boss = (EntityLadyLuna)entity;
		if(boss.getProtectionType() == boss.protectionType.ARCANA) return new ResourceLocation("divinerpg:textures/entity/lady_luna_arcanic.png");
		else if(boss.getProtectionType() == boss.protectionType.RANGED) return new ResourceLocation("divinerpg:textures/entity/lady_luna_ranged.png");
		return new ResourceLocation("divinerpg:textures/entity/lady_luna.png");
    }

	 public static class Factory implements IRenderFactory<EntityLadyLuna> {

	        @Override
	        public Render<? super EntityLadyLuna> createRenderFor(RenderManager manager) {
	            return new RenderLadyLuna(manager, new ModelLadyLuna(), 1F);
	        }
	    }

	}