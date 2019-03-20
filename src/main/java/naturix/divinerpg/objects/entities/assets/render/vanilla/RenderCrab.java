package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelCrab;
import naturix.divinerpg.objects.entities.entity.vanilla.Crab;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCrab extends RenderLiving<Crab> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/crab.png");

    public RenderCrab(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCrab(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Crab entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Crab> {
        @Override
        public Render<? super Crab> createRenderFor(RenderManager manager) {
            return new RenderCrab(manager, new ModelCrab(), 0F);
        }
    }
}