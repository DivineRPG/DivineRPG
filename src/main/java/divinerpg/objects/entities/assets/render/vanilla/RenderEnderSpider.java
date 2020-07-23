package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelEnderSpider;
import divinerpg.objects.entities.entity.end.EntityEnderSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderEnderSpider extends RenderLiving<EntityEnderSpider> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/ender_spider.png");

    public RenderEnderSpider(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelEnderSpider(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityEnderSpider entity) {
        return texture;
    }
}