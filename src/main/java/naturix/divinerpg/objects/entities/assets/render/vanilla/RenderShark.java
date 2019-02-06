package naturix.divinerpg.objects.entities.assets.render.vanilla;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelShark;
import naturix.divinerpg.objects.entities.entity.vanilla.Shark;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderShark extends RenderLiving<Shark> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/shark.png");

    public RenderShark(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelShark(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Shark entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Shark> {
        @Override
        public Render<? super Shark> createRenderFor(RenderManager manager) {
            return new RenderShark(manager, new ModelShark(), 0F);
        }
    }
}