package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelHellPig;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderHellPig<T extends EntityDivineTameable, S extends LivingEntityRenderState, M extends EntityModel<S>> extends MobRenderer<T, S, M> {
    private static final Identifier
            hellPigLoc = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/hell_pig/hell_pig.png"),
            madHellPigLoc = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/hell_pig/hell_pig_mad.png"),
            tamedHellPigLoc = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/hell_pig/hell_pig_tamed.png");
    boolean isTame, isAngry;
    @SuppressWarnings("unchecked")
    public RenderHellPig(EntityRendererProvider.Context context) {
        super(context, (M) new ModelHellPig(context), 0.7F);
        //TODO - layer
//        this.addLayer(new PetCollarLayer<>(this));
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    isAngry = entity.isAngry();
    isTame = entity.isTame();
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return isTame ? tamedHellPigLoc : (isAngry ? madHellPigLoc : hellPigLoc);
    }
}