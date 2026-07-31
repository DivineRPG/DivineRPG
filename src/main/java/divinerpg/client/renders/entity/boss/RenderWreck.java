package divinerpg.client.renders.entity.boss;

import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderWreck<T extends EntityWreck, S extends LivingEntityRenderState, M extends EntityModel<S>> extends RenderDivineMob<T, S, M> {
    private final M modelMelee, modelArcanic, modelRanged;
    int abilityType;

    private final Identifier
            arcanic = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/wreck_arcanic.png"),
            ranged = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/wreck_ranged.png");

    @SuppressWarnings("unchecked")
    public RenderWreck(Context context) {
        super(context, "wreck_melee", (M) new ModelWreck<>(context), 0.8F);
        this.modelMelee = this.model;
        this.modelArcanic = (M) new ModelWreckArcanic<>(context);
        this.modelRanged = (M) new ModelWreckRanged<>(context);
    }
    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }
    @Override
    public void extractRenderState(T entity, S state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        abilityType = entity.getAbilityType();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return switch(abilityType) {
            case 1 -> arcanic;
            case 2 -> ranged;
            default -> TEXTURE;
        };
    }
}