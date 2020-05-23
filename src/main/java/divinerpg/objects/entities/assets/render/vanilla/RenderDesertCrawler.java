package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelCrawler;
import divinerpg.objects.entities.entity.vanilla.EntityDesertCrawler;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderDesertCrawler extends RenderLiving<EntityDesertCrawler> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/desert_crawler.png");

    public RenderDesertCrawler(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCrawler(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityDesertCrawler entity) {
        return texture;
    }
}