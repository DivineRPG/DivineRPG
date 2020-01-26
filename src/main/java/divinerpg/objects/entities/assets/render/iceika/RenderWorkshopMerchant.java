package divinerpg.objects.entities.assets.render.iceika;

import javax.annotation.Nullable;

import divinerpg.objects.entities.assets.model.iceika.ModelWorkshop;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopMerchant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderWorkshopMerchant extends RenderLiving<EntityWorkshopMerchant> {
    public static final IRenderFactory FACTORY = new Factory();
    ResourceLocation texture = new ResourceLocation("divinerpg:textures/entity/workshop_merchant.png");

    public RenderWorkshopMerchant(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
        super(rendermanagerIn, new ModelWorkshop(), shadowsizeIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWorkshopMerchant entity) {
        return texture;
    }

    public static class Factory implements IRenderFactory<EntityWorkshopMerchant> {
        @Override
        public Render<? super EntityWorkshopMerchant> createRenderFor(RenderManager manager) {
            return new RenderWorkshopMerchant(manager, new ModelWorkshop(), 0F);
        }
    }
}