package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelWildfire;
import naturix.divinerpg.objects.entities.assets.render.MainHandLayerRenderWildfire;
import naturix.divinerpg.objects.entities.entity.vanilla.Wildfire;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWildfire extends RenderLiving<Wildfire> {
    public static class Factory implements IRenderFactory<Wildfire> {
        @Override
        public Render<? super Wildfire> createRenderFor(RenderManager manager) {
            return new RenderWildfire(manager, new ModelWildfire(), 0F);
        }
    }

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/wildfire.png");

    private final ModelWildfire modelEntity;

    public RenderWildfire(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWildfire(), shadowsizeIn);
        modelEntity = (ModelWildfire) super.mainModel;
        addLayer(new MainHandLayerRenderWildfire(this));
    }

    @SuppressWarnings("null")
    @Override
    public void doRender(Wildfire entity, double x, double y, double z, float entityYaw, float partialTicks) {
        ItemStack stack = entity.getHeldItemMainhand();
        modelEntity.isHolding = stack != null || !stack.isEmpty();
        if (modelEntity.isHolding && stack != null) {
            modelEntity.itemStack = stack;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Wildfire entity) {
        return texture;
    }
}
