package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.entities.vanilla.overworld.EntityCaveclops;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.utils.Utils.layerHumanoid;

public class RenderCaveclops<T extends EntityCaveclops, S extends HumanoidRenderState, M extends HumanoidModel<S>> extends HumanoidMobRenderer<T, S, M> {
    private final Identifier CAVECLOPS = Identifier.fromNamespaceAndPath(MODID, "textures/entity/caveclops.png");

    @SuppressWarnings("unchecked")
    public RenderCaveclops(EntityRendererProvider.Context context) {
        super(context, (M) new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.8F);
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
        return CAVECLOPS;
    }
}