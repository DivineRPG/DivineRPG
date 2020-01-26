package divinerpg.objects.entities.assets.render.vanilla;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.vanilla.ModelLivestockMerchant;
import divinerpg.objects.entities.entity.vanilla.EntityLivestockMerchant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderLivestockMerchant extends RenderLiving<EntityLivestockMerchant> {

    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/livestock_merchant.png");

    public RenderLivestockMerchant(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelLivestockMerchant(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLivestockMerchant entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityLivestockMerchant> {
        @Override
        public Render<? super EntityLivestockMerchant> createRenderFor(RenderManager manager) {
            return new RenderLivestockMerchant(manager, new ModelLivestockMerchant(), 0.5F);
        }
    }
}