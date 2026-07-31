package divinerpg.client.renders.base;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelJungleBat;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ambient.AmbientCreature;

public class RenderDivineBat<T extends AmbientCreature, S extends LivingEntityRenderState> extends MobRenderer<T, S, EntityModel<S>> {
    protected final Identifier texture;
    protected final float scale;

    @SuppressWarnings("unchecked")
    public RenderDivineBat(EntityRendererProvider.Context context, String name, float shadowSize, float scale) {
        super(context, (EntityModel<S>) new ModelJungleBat(context.bakeLayer(ModelJungleBat.LAYER_LOCATION)), shadowSize);
        this.scale = scale;
        this.texture = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + name + ".png");
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public void extractRenderState(T entity, S state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
    }

    @Override
    protected void scale(S state, PoseStack stack) {
        stack.scale(this.scale, this.scale, this.scale);
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return this.texture;
    }
}