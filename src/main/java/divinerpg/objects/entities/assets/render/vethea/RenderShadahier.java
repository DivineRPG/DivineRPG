package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelShadahier;
import divinerpg.objects.entities.entity.vethea.EntityShadahier;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderShadahier extends RenderLiving<EntityShadahier> {
    ResourceLocation texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/shadahier.png");

    public RenderShadahier(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelShadahier(), 1F);

    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityShadahier entity) {
        return texture;
    }
}