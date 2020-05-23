package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelLivestockMerchant;
import divinerpg.objects.entities.entity.vanilla.EntityLivestockMerchant;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLivestockMerchant extends RenderLiving<EntityLivestockMerchant> {


    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/livestock_merchant.png");

    public RenderLivestockMerchant(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelLivestockMerchant(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLivestockMerchant entity) {
        return texture;
    }

}