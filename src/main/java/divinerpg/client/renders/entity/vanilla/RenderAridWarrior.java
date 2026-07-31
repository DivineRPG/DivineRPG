package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.models.vanilla.ModelAridWarrior;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderAridWarrior<T extends EntityAridWarrior, S extends HumanoidRenderState, M extends ModelAridWarrior<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/arid_warrior.png");

    @SuppressWarnings("unchecked")
    public RenderAridWarrior(EntityRendererProvider.Context context) {
        super(context, (M) new ModelAridWarrior<HumanoidRenderState>(context.bakeLayer(ModelAridWarrior.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public S createRenderState() {
        return (S) new HumanoidRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }
}