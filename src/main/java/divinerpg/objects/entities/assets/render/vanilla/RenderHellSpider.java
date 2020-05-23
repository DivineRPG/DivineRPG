package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelHellSpider;
import divinerpg.objects.entities.entity.vanilla.EntityHellSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHellSpider extends RenderLiving<EntityHellSpider> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_spider.png");

    public RenderHellSpider(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHellSpider(), 0.6F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHellSpider entity) {
        return texture;
    }
}