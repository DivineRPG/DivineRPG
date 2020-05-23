package divinerpg.objects.entities.assets.render.iceika;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.iceika.ModelWorkshop;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopMerchant;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderWorkshopMerchant extends RenderLiving<EntityWorkshopMerchant> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/workshop_merchant.png");

    public RenderWorkshopMerchant(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWorkshop(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityWorkshopMerchant entity) {
        return texture;
    }

}