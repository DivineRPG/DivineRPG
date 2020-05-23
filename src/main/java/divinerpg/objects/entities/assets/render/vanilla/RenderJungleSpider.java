package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelJungleSpider;
import divinerpg.objects.entities.entity.vanilla.EntityJungleSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderJungleSpider extends RenderLiving<EntityJungleSpider> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/jungle_spider.png");

    public RenderJungleSpider(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelJungleSpider(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityJungleSpider entity) {
        return texture;
    }

}