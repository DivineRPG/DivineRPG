package naturix.divinerpg.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.entities.assets.model.vanilla.model.ModelHellSpider;
import naturix.divinerpg.entities.entity.vanilla.HellSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderHellSpider extends RenderLiving<HellSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/hell_spider.png");

    public RenderHellSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelHellSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(HellSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<HellSpider> {
        @Override
        public Render<? super HellSpider> createRenderFor(RenderManager manager) {
            return new RenderHellSpider(manager, new ModelHellSpider(), 0.5F);
        }
    }
}