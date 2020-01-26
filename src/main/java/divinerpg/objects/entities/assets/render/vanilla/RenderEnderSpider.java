package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelEnderSpider;
import divinerpg.objects.entities.entity.vanilla.EntityEnderSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEnderSpider extends RenderLiving<EntityEnderSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/ender_spider.png");

    public RenderEnderSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelEnderSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityEnderSpider> {
        @Override
        public Render<? super EntityEnderSpider> createRenderFor(RenderManager manager) {
            return new RenderEnderSpider(manager, new ModelEnderSpider(), 0F);
        }
    }
}