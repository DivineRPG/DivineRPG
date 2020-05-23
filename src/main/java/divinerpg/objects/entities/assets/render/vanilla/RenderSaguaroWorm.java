package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelSaguaroWorm;
import divinerpg.objects.entities.entity.vanilla.EntitySaguaroWorm;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSaguaroWorm extends RenderLiving<EntitySaguaroWorm> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/saguaro_worm.png");

    public RenderSaguaroWorm(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSaguaroWorm(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySaguaroWorm entity) {
        return texture;
    }

}