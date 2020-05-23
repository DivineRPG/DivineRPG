package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSoulSpider;
import divinerpg.objects.entities.entity.twilight.EntitySoulSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSoulSpider extends RenderLiving<EntitySoulSpider> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_spider.png");

    public RenderSoulSpider(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSoulSpider(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySoulSpider entity) {
        return texture;
    }
}