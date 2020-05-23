package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelCyclops;
import divinerpg.objects.entities.entity.vanilla.EntityCaveclops;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCaveclops extends RenderLiving<EntityCaveclops> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/caveclops.png");

    public RenderCaveclops(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCyclops(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCaveclops entity) {
        return texture;
    }
}