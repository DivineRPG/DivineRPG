package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelGrizzle;
import divinerpg.objects.entities.entity.vanilla.EntityBrownGrizzle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderBrownGrizzle extends RenderLiving<EntityBrownGrizzle> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/brown_grizzle.png");

    public RenderBrownGrizzle(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGrizzle(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityBrownGrizzle entity) {
        return texture;
    }

}