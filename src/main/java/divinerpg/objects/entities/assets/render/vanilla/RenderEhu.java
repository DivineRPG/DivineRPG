package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelEhu;
import divinerpg.objects.entities.entity.vanilla.EntityEhu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEhu extends RenderLiving<EntityEhu> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ehu.png");

    public RenderEhu(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEhu(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEhu entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityEhu> {
        @Override
        public Render<? super EntityEhu> createRenderFor(RenderManager manager) {
            return new RenderEhu(manager, new ModelEhu(), 0F);
        }
    }
}