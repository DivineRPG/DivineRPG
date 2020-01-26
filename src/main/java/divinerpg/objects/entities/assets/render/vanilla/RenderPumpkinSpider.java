package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelPumpkinSpider;
import divinerpg.objects.entities.entity.vanilla.EntityPumpkinSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderPumpkinSpider extends RenderLiving<EntityPumpkinSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/pumpkin_spider.png");

    public RenderPumpkinSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelPumpkinSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityPumpkinSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityPumpkinSpider> {
        @Override
        public Render<? super EntityPumpkinSpider> createRenderFor(RenderManager manager) {
            return new RenderPumpkinSpider(manager, new ModelPumpkinSpider(), 0F);
        }
    }
}