package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelCrawler;
import naturix.divinerpg.objects.entities.entity.vanilla.DesertCrawler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderDesertCrawler extends RenderLiving<DesertCrawler> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/desert_crawler.png");

    public RenderDesertCrawler(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelCrawler(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(DesertCrawler entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<DesertCrawler> {
        @Override
        public Render<? super DesertCrawler> createRenderFor(RenderManager manager) {
            return new RenderDesertCrawler(manager, new ModelCrawler(), 0F);
        }
    }
}