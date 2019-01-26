package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelWildfire;
import naturix.divinerpg.entities.assets.render.MainHandLayerRender;
import naturix.divinerpg.entities.entity.vanilla.WildFire;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWildFire extends RenderLiving<WildFire> {
	
	public static final IRenderFactory FACTORY = new Factory();
	ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wildfire.png");
	private final ModelWildfire modelEntity;
    
	public RenderWildFire(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWildfire(), 1.0F);
        modelEntity = (ModelWildfire) super.mainModel;
        addLayer(new MainHandLayerRender(this));
    }
 
	@SuppressWarnings("null")
	@Override
    public void doRender(WildFire entity, double x, double y, double z, float entityYaw, float partialTicks) {
        ItemStack stack = entity.getHeldItemMainhand();
        modelEntity.isHolding = stack != null || !stack.isEmpty();
        if (modelEntity.isHolding && stack != null){
            modelEntity.itemStack = stack;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

	@Nullable
    @Override
    protected ResourceLocation getEntityTexture(WildFire entity) {
        return texture;
    }

	 public static class Factory implements IRenderFactory<WildFire> {

	        @Override
	        public Render<? super WildFire> createRenderFor(RenderManager manager) {
	            return new RenderWildFire(manager, new ModelWildfire(), 0.5F);
	        }
	    }

	}