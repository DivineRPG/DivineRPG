package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelKingCrab;
import divinerpg.objects.entities.entity.vanilla.EntityKingCrab;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderKingCrab extends RenderLiving<EntityKingCrab> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/crab.png");

    public RenderKingCrab(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelKingCrab(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKingCrab entity) {
        return texture;
    }
}