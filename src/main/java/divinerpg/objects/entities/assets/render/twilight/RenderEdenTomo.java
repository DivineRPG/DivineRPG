package divinerpg.objects.entities.assets.render.twilight;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.twilight.ModelTomo;
import divinerpg.objects.entities.entity.twilight.EntityEdenTomo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEdenTomo extends RenderLiving<EntityEdenTomo> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/eden_tomo.png");

    public RenderEdenTomo(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelTomo(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEdenTomo entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityEdenTomo> {
        @Override
        public Render<? super EntityEdenTomo> createRenderFor(RenderManager manager) {
            return new RenderEdenTomo(manager, new ModelTomo(), 0);
        }
    }
}