package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelAcidHag;
import divinerpg.objects.entities.entity.vethea.EntityAcidHag;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderAcidHag extends RenderLiving<EntityAcidHag> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/acid_hag.png");

    public RenderAcidHag(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelAcidHag(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAcidHag entity) {
        return texture;
    }

}