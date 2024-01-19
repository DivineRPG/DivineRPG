package divinerpg.client.renders.entity.vethea;

import divinerpg.DivineRPG;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.vethea.EntityGalroid;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGalroid extends RenderDivineMob<EntityGalroid> {
    ResourceLocation regular = new ResourceLocation(DivineRPG.MODID, "textures/entity/galroid.png");
    ResourceLocation invulnerable = new ResourceLocation(DivineRPG.MODID, "textures/entity/galroid_invulnerable.png");

    public RenderGalroid(EntityRendererProvider.Context context, String name, EntityModel<EntityGalroid> model) {
        super(context, name, model, 0.8F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityGalroid mob) {
        if (mob.isInvulnerable()) {
            return invulnerable;
        }
        else {
            return regular;
        }
    }
}
