package divinerpg.client.renders.entity.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGruzzorlug;
import divinerpg.entities.iceika.gruzzorlug.Gruzzorlug;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public class RenderGruzzorlug<T extends Gruzzorlug, S extends HumanoidRenderState, M extends ModelGruzzorlug<S>> extends HumanoidMobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/gruzzorlug.png");

    @SuppressWarnings("unchecked")
    public RenderGruzzorlug(EntityRendererProvider.Context context) {
        super(context, (M) new ModelGruzzorlug(context.bakeLayer(ModelGruzzorlug.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public S createRenderState() {
        return (S) new HumanoidRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }

    @Override
    protected void scale(S state, PoseStack stack) {
        stack.scale(0.8F, 0.8F, 0.8F);
    }
}