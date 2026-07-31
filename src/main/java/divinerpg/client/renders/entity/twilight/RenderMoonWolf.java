package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelMoonWolf;
import divinerpg.entities.wildwood.EntityMoonWolf;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderMoonWolf<T extends EntityMoonWolf, S extends LivingEntityRenderState, M extends ModelMoonWolf<S>> extends MobRenderer<T, S, M> {
    private static final Identifier
            WOLF_LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_default.png"),
            WOLF_TAME_LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_default.png"),
            WOLF_ANGRY_LOCATION = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/moon_wolf/moon_wolf_agro.png");
    boolean isTame, isAngry;
    @SuppressWarnings("unchecked")
    public RenderMoonWolf(EntityRendererProvider.Context context) {
        super(context, (M) new ModelMoonWolf(context), 0.5F);
            //TODO - layer
        //        this.addLayer(new MoonWolfCollarLayer<>(this));
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    isAngry = entity.isAngry();
    isTame = entity.isTame();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        if (isTame) return WOLF_TAME_LOCATION;
        else return isAngry ? WOLF_ANGRY_LOCATION : WOLF_LOCATION;
    }
}