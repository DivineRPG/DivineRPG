package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelKobblin;
import divinerpg.entities.vanilla.overworld.EntityKobblin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Pose;

public class RenderKobblin<T extends EntityKobblin, S extends LivingEntityRenderState, M extends ModelKobblin<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/kobblin.png");
    boolean isEmerging;
    int tickCount;
    @SuppressWarnings("unchecked")
    public RenderKobblin(EntityRendererProvider.Context context) {
        super(context, (M) new ModelKobblin(context), 0.5F);
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    isEmerging = entity.hasPose(Pose.EMERGING);
    tickCount = entity.tickCount;
    }

    @Override
    protected void scale(S state, PoseStack matrixStackIn) {
        if (isEmerging) {
            matrixStackIn.translate(0.0D, 1.325F - 0.053F * tickCount, 0.0D);
        }
        super.scale(state, matrixStackIn);
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }
}