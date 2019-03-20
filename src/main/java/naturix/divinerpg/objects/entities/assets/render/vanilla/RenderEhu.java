package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelEhu;
import naturix.divinerpg.objects.entities.entity.vanilla.Ehu;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEhu extends RenderLiving<Ehu> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ehu.png");

    public RenderEhu(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEhu(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Ehu entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Ehu> {
        @Override
        public Render<? super Ehu> createRenderFor(RenderManager manager) {
            return new RenderEhu(manager, new ModelEhu(), 0F);
        }
    }
}