package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelHusk;
import divinerpg.objects.entities.entity.vanilla.EntityHusk;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderHusk extends RenderLiving<EntityHusk> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/husk.png");

    public RenderHusk(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelHusk(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityHusk entity) {
        return texture;
    }

}