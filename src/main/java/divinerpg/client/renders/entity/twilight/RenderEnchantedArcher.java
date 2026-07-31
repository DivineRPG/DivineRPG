package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.entities.apalachia.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class RenderEnchantedArcher<T extends EntityEnchantedArcher, S extends LivingEntityRenderState, M extends ModelEnchantedArcher<S>> extends MobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/enchanted_archer.png");

    @SuppressWarnings("unchecked")
    public RenderEnchantedArcher(EntityRendererProvider.Context context) {
        super(context, (M) new ModelEnchantedArcher<>(context), 0.8F);
        //TODO - layer
        //        this.addLayer(new EnchantedArcherLayer<>(this));
    }

    @Override
    public S createRenderState() {
        return (S) new LivingEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }
}