package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelJungleSpider;
import divinerpg.objects.entities.entity.vanilla.EntityJungleSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJungleSpider extends RenderLiving<EntityJungleSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jungle_spider.png");

    public RenderJungleSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelJungleSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityJungleSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityJungleSpider> {
        @Override
        public Render<? super EntityJungleSpider> createRenderFor(RenderManager manager) {
            return new RenderJungleSpider(manager, new ModelJungleSpider(), 0F);
        }
    }
}