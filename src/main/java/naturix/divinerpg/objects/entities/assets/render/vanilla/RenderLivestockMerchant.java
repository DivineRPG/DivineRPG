package naturix.divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelLivestockMerchant;
import naturix.divinerpg.objects.entities.entity.vanilla.LivestockMerchant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLivestockMerchant extends RenderLiving<LivestockMerchant> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/livestock_merchant.png");

    public RenderLivestockMerchant(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLivestockMerchant(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(LivestockMerchant entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<LivestockMerchant> {
        @Override
        public Render<? super LivestockMerchant> createRenderFor(RenderManager manager) {
            return new RenderLivestockMerchant(manager, new ModelLivestockMerchant(), 0.5F);
        }
    }
}