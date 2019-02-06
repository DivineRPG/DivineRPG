package naturix.divinerpg.objects.entities.assets.render.vanilla;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelPumpkinSpider;
import naturix.divinerpg.objects.entities.entity.vanilla.PumpkinSpider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

public class RenderPumpkinSpider extends RenderLiving<PumpkinSpider> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/pumpkin_spider.png");

    public RenderPumpkinSpider(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelPumpkinSpider(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(PumpkinSpider entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<PumpkinSpider> {
        @Override
        public Render<? super PumpkinSpider> createRenderFor(RenderManager manager) {
            return new RenderPumpkinSpider(manager, new ModelPumpkinSpider(), 0F);
        }
    }
}