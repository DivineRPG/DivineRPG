package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelGlacide;
import divinerpg.objects.entities.entity.iceika.Glacide;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGlacide extends RenderLiving<Glacide> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/glacon.png");

    public RenderGlacide(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGlacide(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Glacide entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<Glacide> {
        @Override
        public Render<? super Glacide> createRenderFor(RenderManager manager) {
            return new RenderGlacide(manager, new ModelGlacide(), 0F);
        }
    }
}