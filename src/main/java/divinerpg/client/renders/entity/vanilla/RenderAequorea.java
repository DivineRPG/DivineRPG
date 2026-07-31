package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.vanilla.ModelAequorea;
import divinerpg.entities.vanilla.overworld.EntityAequorea;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

import javax.annotation.Nullable;

import static divinerpg.DivineRPG.MODID;

public class RenderAequorea<T extends EntityAequorea, S extends LivingEntityRenderState, M extends ModelAequorea<S>> extends MobRenderer<T, S, M> {
    public static final Identifier
            RED = Identifier.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_red.png"),
            YELLOW = Identifier.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_yellow.png"),
            GREEN = Identifier.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_green.png"),
            BLUE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_blue.png"),
            PURPLE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_purple.png"),
            PINK = Identifier.fromNamespaceAndPath(MODID, "textures/entity/aequorea/aequorea_pink.png");
    byte color;
    @SuppressWarnings("unchecked")
    public RenderAequorea(EntityRendererProvider.Context context) {
        super(context, (M) new ModelAequorea(context), 0.3F);
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    protected @Nullable RenderType getRenderType(S state, boolean isBodyVisible, boolean forceTransparent, boolean appearGlowing) {
        return RenderTypes.entityTranslucent(getTextureLocation(state));
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    color = entity.getColor();
    }

    @Override
    protected void setupRotations(S state, PoseStack poseStack, float bob, float yBodyRot) {
        float f = 0.0F;
        float f1 = 0.0F;
        poseStack.translate(0.0D, 0.25D, 0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - yBodyRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(f));
        poseStack.mulPose(Axis.YP.rotationDegrees(f1));
        poseStack.translate(0.0D, -0.6D, 0.0D);
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return switch(color) {
            case 0 -> YELLOW;
            case 1 -> GREEN;
            case 2 -> BLUE;
            case 3 -> PURPLE;
            case 4 -> PINK;
            default -> RED;
        };
    }
}