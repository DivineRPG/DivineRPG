package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelEnderWatcher;
import divinerpg.objects.entities.entity.vanilla.EntityEnderWatcher;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnderWatcher extends RenderLiving<EntityEnderWatcher> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ender_watcher.png");

    public RenderEnderWatcher(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnderWatcher(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderWatcher entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityEnderWatcher> {
        @Override
        public Render<? super EntityEnderWatcher> createRenderFor(RenderManager manager) {
            return new RenderEnderWatcher(manager, new ModelEnderWatcher(), 0F);
        }
    }
}