package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.entities.vanilla.overworld.EntityCyclops;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.utils.Utils.layerHumanoid;

public class RenderCyclops<T extends EntityCyclops, S extends HumanoidRenderState, M extends HumanoidModel<S>> extends HumanoidMobRenderer<T, S, M> {
    private final Identifier
            CYCLOPS = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/cyclops.png"),
            CYCLOPS_ANGRY = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/cyclops_angry.png");
    boolean isAggressive;
    @SuppressWarnings("unchecked")
    public RenderCyclops(EntityRendererProvider.Context context) {
        super(context, (M) new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.8F);
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    isAggressive = entity.isAggressive();
    }

    @Override
    public S createRenderState() {
        return (S) new HumanoidRenderState();
    }

    @Override
    protected void scale(S state, PoseStack poseStack) {
        poseStack.scale(2.0F, 2.0F, 2.0F);
        super.scale(state, poseStack);
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return isAggressive ? CYCLOPS_ANGRY : CYCLOPS;
    }
}