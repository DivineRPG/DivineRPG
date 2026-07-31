package divinerpg.client.renders.entity.boss;

import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelAyeraco;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.EntityAyeraco;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderAyeraco<T extends EntityAyeraco, S extends LivingEntityRenderState, M extends ModelAyeraco<S>> extends RenderDivineMob<T, S, M> {
    public static final Identifier
            TEXTURE0 = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/ayeraco_blue.png"),
            TEXTURE1 = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/ayeraco_green.png"),
            TEXTURE2 = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/ayeraco_pink.png"),
            TEXTURE3 = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/ayeraco_purple.png"),
            TEXTURE4 = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/ayeraco_red.png"),
            TEXTURE5 = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/ayeraco_yellow.png");

    byte variant;

    @SuppressWarnings("unchecked")
    public RenderAyeraco(Context context) {
        super(context, "ayeraco_white", (M) new ModelAyeraco<>(context), 0.4F);
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
    variant = entity.getVariant();
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return switch(variant) {
            case 6 -> TEXTURE0;
            case 1 -> TEXTURE1;
            case 2 -> TEXTURE2;
            case 3 -> TEXTURE3;
            case 4 -> TEXTURE4;
            case 5 -> TEXTURE5;
            default -> TEXTURE;
        };
    }
}