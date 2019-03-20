package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelHusk;
import naturix.divinerpg.objects.entities.entity.vanilla.Husk;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHusk extends RenderLiving<Husk> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/husk.png");

    public RenderHusk(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHusk(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Husk entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Husk> {
        @Override
        public Render<? super Husk> createRenderFor(RenderManager manager) {
            return new RenderHusk(manager, new ModelHusk(), 0F);
        }
    }
}