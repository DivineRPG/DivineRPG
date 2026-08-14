package divinerpg.client.renders.base;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Mob;

public class RenderDivineHumanoid<T extends Mob, S extends HumanoidRenderState, M extends HumanoidModel<S>> extends HumanoidMobRenderer<T, S, M> {
    protected final Identifier TEXTURE;
    protected final float scale;

    public RenderDivineHumanoid(EntityRendererProvider.Context context, String name, M model) {
        this(context, name, model, 1.0f, 1.0f);
    }

    public RenderDivineHumanoid(EntityRendererProvider.Context context, String name, M model, float shadowSize) {
        this(context, name, model, shadowSize, 1.0f);
    }

    public RenderDivineHumanoid(EntityRendererProvider.Context context, String name, M model, float shadowSize, float scale) {
        super(context, model, shadowSize);
        this.scale = scale;
        this.TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + name + ".png");
    }

    @Override
    @SuppressWarnings("unchecked")
    public S createRenderState() {
        return (S) new HumanoidRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
    }

    @Override
    protected void scale(S state, PoseStack stack) {
        if (state.isBaby) {
            stack.scale(scale / 2.0f, scale / 2.0f, scale / 2.0f);
        } else {
            stack.scale(scale, scale, scale);
        }
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }
}