package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelFrost;
import divinerpg.objects.entities.entity.vanilla.EntityFrost;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderFrost extends RenderLiving<EntityFrost> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/frost.png");

    public RenderFrost(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelFrost(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFrost entity) {
        return texture;
    }
}