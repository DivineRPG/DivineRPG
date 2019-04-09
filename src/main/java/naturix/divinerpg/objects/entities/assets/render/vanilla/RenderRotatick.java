package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.ModelRotatick;
import naturix.divinerpg.objects.entities.entity.vanilla.Rotatick;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRotatick extends RenderLiving<Rotatick> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/rotatick.png");

    public RenderRotatick(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRotatick(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Rotatick entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Rotatick> {
        @Override
        public Render<? super Rotatick> createRenderFor(RenderManager manager) {
            return new RenderRotatick(manager, new ModelRotatick(), 0F);
        }
    }
}