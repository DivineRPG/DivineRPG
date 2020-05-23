package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelHoverStinger;
import divinerpg.objects.entities.entity.vethea.EntityHoverStinger;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHoverStinger extends RenderLiving<EntityHoverStinger> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/hover_stinger.png");

    public RenderHoverStinger(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHoverStinger(), 1F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHoverStinger entity) {
        return texture;
    }
}