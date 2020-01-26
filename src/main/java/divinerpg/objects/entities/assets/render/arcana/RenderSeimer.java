package divinerpg.objects.entities.assets.render.arcana;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.arcana.ModelSeimer;
import divinerpg.objects.entities.entity.arcana.EntitySeimer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSeimer extends RenderLiving<EntitySeimer> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/seimer.png");

    public RenderSeimer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelSeimer(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySeimer entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntitySeimer> {
        @Override
        public Render<? super EntitySeimer> createRenderFor(RenderManager manager) {
            return new RenderSeimer(manager, new ModelSeimer(), 0);
        }
    }
}