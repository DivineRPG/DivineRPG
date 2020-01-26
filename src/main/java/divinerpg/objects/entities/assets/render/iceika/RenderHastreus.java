package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelHastreus;
import divinerpg.objects.entities.entity.iceika.EntityHastreus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHastreus extends RenderLiving<EntityHastreus> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hastreus.png");

    public RenderHastreus(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHastreus(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHastreus entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityHastreus> {
        @Override
        public Render<? super EntityHastreus> createRenderFor(RenderManager manager) {
            return new RenderHastreus(manager, new ModelHastreus(), 0F);
        }
    }
}