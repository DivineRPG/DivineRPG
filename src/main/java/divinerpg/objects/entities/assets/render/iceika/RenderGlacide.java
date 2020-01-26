package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelGlacide;
import divinerpg.objects.entities.entity.iceika.EntityGlacide;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGlacide extends RenderLiving<EntityGlacide> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/glacon.png");

    public RenderGlacide(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelGlacide(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityGlacide entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityGlacide> {
        @Override
        public Render<? super EntityGlacide> createRenderFor(RenderManager manager) {
            return new RenderGlacide(manager, new ModelGlacide(), 0F);
        }
    }
}