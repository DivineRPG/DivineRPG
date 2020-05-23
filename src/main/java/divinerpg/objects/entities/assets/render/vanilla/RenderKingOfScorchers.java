package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelKingScorcher;
import divinerpg.objects.entities.entity.vanilla.EntityKingOfScorchers;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderKingOfScorchers extends RenderLiving<EntityKingOfScorchers> {

    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/king_of_scorchers.png");

    public RenderKingOfScorchers(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelKingScorcher(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityKingOfScorchers entity) {
        return texture;
    }

}