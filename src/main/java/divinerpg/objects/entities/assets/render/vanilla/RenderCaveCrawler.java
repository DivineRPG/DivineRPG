package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelCrawler;
import divinerpg.objects.entities.entity.vanilla.EntityCaveCrawler;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCaveCrawler extends RenderLiving<EntityCaveCrawler> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/cave_crawler.png");

    public RenderCaveCrawler(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCrawler(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaveCrawler entity) {
        return texture;
    }
}