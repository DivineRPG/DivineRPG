package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelHellSpider;
import divinerpg.objects.entities.entity.vanilla.EntityHellSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHellSpider extends RenderLiving<EntityHellSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hell_spider.png");

    public RenderHellSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHellSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHellSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityHellSpider> {
        @Override
        public Render<? super EntityHellSpider> createRenderFor(RenderManager manager) {
            return new RenderHellSpider(manager, new ModelHellSpider(), 0.6F);
        }
    }
}