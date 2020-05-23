package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelSnapper;
import divinerpg.objects.entities.entity.vanilla.EntitySnapper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSnapper extends RenderLiving<EntitySnapper> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/snapper.png");

    public RenderSnapper(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSnapper(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySnapper entity) {
        return texture;
    }
}