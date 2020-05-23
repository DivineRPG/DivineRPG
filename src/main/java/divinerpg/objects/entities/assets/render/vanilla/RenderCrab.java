package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelCrab;
import divinerpg.objects.entities.entity.vanilla.EntityCrab;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderCrab extends RenderLiving<EntityCrab> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/crab.png");

    public RenderCrab(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCrab(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityCrab entity) {
        return texture;
    }

}