package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelCyclops;
import divinerpg.objects.entities.entity.vanilla.EntityCyclops;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCyclops extends RenderLiving<EntityCyclops> {

    ResourceLocation cyclopsLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/cyclops.png");
    ResourceLocation angryCyclopsLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_cyclops.png");

    public RenderCyclops(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCyclops(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCyclops cyclops) {
        return cyclops.isAngry() ? angryCyclopsLoc : cyclopsLoc;
    }

}