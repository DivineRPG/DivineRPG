package divinerpg.client.renders.entity.vethea;

import divinerpg.*;
import divinerpg.client.models.vethea.ModelGalroid;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.vethea.EntityGalroid;
import net.minecraft.client.renderer.entity.*;
import net.neoforged.api.distmarker.*;

import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class RenderGalroid extends RenderDivineMob<EntityGalroid> {
    public static final ResourceLocation regular = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/galroid.png"), invulnerable = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/galroid_invulnerable.png");
    public RenderGalroid(EntityRendererProvider.Context context) {
        super(context, "galroid", new ModelGalroid(context), .8F);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityGalroid mob) {
        if(mob.isInvulnerable()) return invulnerable;
        else return regular;
    }
}
