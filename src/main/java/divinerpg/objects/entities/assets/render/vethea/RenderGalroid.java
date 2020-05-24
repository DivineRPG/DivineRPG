package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelGalroid;
import divinerpg.objects.entities.entity.vethea.EntityGalroid;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderGalroid extends RenderLiving<EntityGalroid> {
    ResourceLocation regular = new ResourceLocation(DivineRPG.MODID, "textures/entity/galroid.png");
    ResourceLocation invulnerable = new ResourceLocation(DivineRPG.MODID, "textures/entity/galroid_invulnerable.png");

    public RenderGalroid(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGalroid(), 1F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGalroid entity) {
        if (entity.getIsInvulnerable()) {
            return invulnerable;
        }
        else {
            return regular;
        }
    }

}