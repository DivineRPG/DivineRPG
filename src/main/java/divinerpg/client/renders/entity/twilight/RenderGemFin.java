package divinerpg.client.renders.entity.twilight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.twilight.ModelGemFin;
import divinerpg.entities.eden.EntityGemFin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

import static divinerpg.DivineRPG.MODID;

public class RenderGemFin<T extends EntityGemFin, S extends LivingEntityRenderState, M extends ModelGemFin<S>> extends MobRenderer<T, S, M> {
    private static final Identifier RUBY = Identifier.fromNamespaceAndPath(MODID, "textures/entity/gem_fin/ruby_gem_fin.png"),
            PATCHY = Identifier.fromNamespaceAndPath(MODID, "textures/entity/gem_fin/patchy_gem_fin.png"),
            PRECIOUS = Identifier.fromNamespaceAndPath(MODID, "textures/entity/gem_fin/precious_gem_fin.png");

    int variant;
    boolean isInWater;

    @SuppressWarnings("unchecked")
    public RenderGemFin(EntityRendererProvider.Context context) {
        super(context, (M) new ModelGemFin(context), 0.32F);
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    variant = entity.getVariant();
    isInWater = entity.isInWater();
    }

    @Override
    protected void setupRotations(S state, PoseStack poseStack, float bob, float yBodyRot) {
        super.setupRotations(state, poseStack, bob, yBodyRot);
        float f = 4.3F * Mth.sin(0.6F * bob);
        poseStack.mulPose(Axis.YP.rotationDegrees(f));
        if (!isInWater) {
            poseStack.translate(0.2F, 0.2F, 0.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return switch (variant) {
            case 0 -> PATCHY;
            case 1 -> PRECIOUS;
            default -> RUBY;
        };
    }
}