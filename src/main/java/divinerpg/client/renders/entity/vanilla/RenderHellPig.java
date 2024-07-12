package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelHellPig;
import divinerpg.client.renders.layer.PetCollarLayer;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderHellPig extends MobRenderer<EntityDivineTameable, EntityModel<EntityDivineTameable>> {
    private static final ResourceLocation
            hellPigLoc = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/hell_pig/hell_pig.png"),
            madHellPigLoc = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/hell_pig/hell_pig_mad.png"),
            tamedHellPigLoc = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/hell_pig/hell_pig_tamed.png");

    public RenderHellPig(Context context) {
        super(context, new ModelHellPig<>(context), 0.7F);
        this.addLayer(new PetCollarLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDivineTameable entity) {
        return entity.isTame() ? tamedHellPigLoc : (entity.isAngry() ? madHellPigLoc : hellPigLoc);
    }
}