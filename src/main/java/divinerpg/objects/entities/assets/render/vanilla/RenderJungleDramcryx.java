package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelDramcryx;
import divinerpg.objects.entities.entity.vanilla.EntityJungleDramcryx;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJungleDramcryx extends RenderLiving<EntityJungleDramcryx> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jungle_dramcryx.png");

    public RenderJungleDramcryx(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelDramcryx(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityJungleDramcryx entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityJungleDramcryx> {
        @Override
        public Render<? super EntityJungleDramcryx> createRenderFor(RenderManager manager) {
            return new RenderJungleDramcryx(manager, new ModelDramcryx(), 0F);
        }
    }
}