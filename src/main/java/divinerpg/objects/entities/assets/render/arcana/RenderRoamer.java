package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelRoamer;
import divinerpg.objects.entities.entity.arcana.EntityRoamer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderRoamer extends RenderLiving<EntityRoamer> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/roamer.png");

    public RenderRoamer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelRoamer(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityRoamer entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityRoamer> {
        @Override
        public Render<? super EntityRoamer> createRenderFor(RenderManager manager) {
            return new RenderRoamer(manager, new ModelRoamer(), 0);
        }
    }
}