package divinerpg.objects.entities.assets.render.vanilla;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelScorcher;
import divinerpg.objects.entities.entity.vanilla.EntityScorcher;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderScorcher extends RenderLiving<EntityScorcher> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/scorcher.png");

    public RenderScorcher(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelScorcher(), 0);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityScorcher entity) {
        return texture;
    }
}