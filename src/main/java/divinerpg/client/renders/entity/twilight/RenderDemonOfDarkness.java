package divinerpg.client.renders.entity.twilight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelDemonOfDarkness;
import divinerpg.entities.mortum.EntityDemonOfDarkness;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderDemonOfDarkness<T extends EntityDemonOfDarkness, S extends LivingEntityRenderState, M extends ModelDemonOfDarkness<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/demon_of_darkness.png");

    @SuppressWarnings("unchecked")
    public RenderDemonOfDarkness(Context context) {
        super(context, (M) new ModelDemonOfDarkness(context), 0.8F);
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    protected void scale(S state, PoseStack matrixStackIn) {
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0F));
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }
}