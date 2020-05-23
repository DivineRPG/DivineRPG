package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelPumpkinSpider;
import divinerpg.objects.entities.entity.vanilla.EntityPumpkinSpider;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderPumpkinSpider extends RenderLiving<EntityPumpkinSpider> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/pumpkin_spider.png");

    public RenderPumpkinSpider(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelPumpkinSpider(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityPumpkinSpider entity) {
        return texture;
    }
}