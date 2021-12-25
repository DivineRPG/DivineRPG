package divinerpg.client.renders.entity.vethea;


import divinerpg.*;
import divinerpg.client.models.vethea.*;
import divinerpg.entities.vethea.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderGalroid extends MobRenderer<EntityGalroid, SegmentedModel<EntityGalroid>> {
    ResourceLocation regular = new ResourceLocation(DivineRPG.MODID, "textures/entity/galroid.png");
    ResourceLocation invulnerable = new ResourceLocation(DivineRPG.MODID, "textures/entity/galroid_invulnerable.png");

    public RenderGalroid(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelGalroid(), 0.8F);


    }

    @Override
    public ResourceLocation getTextureLocation(EntityGalroid entity) {
        if (entity.isInvulnerable()) {
            return invulnerable;
        }
        else {
            return regular;
        }
    }
}
