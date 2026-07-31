package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelEnchantedWarrior;
import divinerpg.entities.apalachia.EntityEnchantedWarrior;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public class RenderEnchantedWarrior<T extends EntityEnchantedWarrior, S extends HumanoidRenderState, M extends ModelEnchantedWarrior<S>> extends HumanoidMobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/enchanted_warrior.png");

    @SuppressWarnings("unchecked")
    public RenderEnchantedWarrior(EntityRendererProvider.Context context) {
        super(context, (M) new ModelEnchantedWarrior(context.bakeLayer(ModelEnchantedWarrior.LAYER_LOCATION)), 0.5F);
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