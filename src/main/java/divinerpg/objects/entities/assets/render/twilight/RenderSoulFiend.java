package divinerpg.objects.entities.assets.render.twilight;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.twilight.ModelSoulFiend;
import divinerpg.objects.entities.entity.twilight.EntitySoulFiend;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSoulFiend extends RenderLiving<EntitySoulFiend> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/soul_fiend.png");

    public RenderSoulFiend(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSoulFiend(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySoulFiend entity) {
        return texture;
    }
}