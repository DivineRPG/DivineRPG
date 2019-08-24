package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelJungleSpider;
import divinerpg.objects.entities.entity.vanilla.JungleSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJungleSpider extends RenderLiving<JungleSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/jungle_spider.png");

    public RenderJungleSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelJungleSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(JungleSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<JungleSpider> {
        @Override
        public Render<? super JungleSpider> createRenderFor(RenderManager manager) {
            return new RenderJungleSpider(manager, new ModelJungleSpider(), 0F);
        }
    }
}