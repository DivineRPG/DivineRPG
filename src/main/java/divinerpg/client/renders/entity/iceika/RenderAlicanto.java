package divinerpg.client.renders.entity.iceika;

import divinerpg.client.models.iceika.ModelAlicanto;
import divinerpg.client.models.state.AlicantoRenderState;
import divinerpg.entities.iceika.EntityAlicanto;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderAlicanto extends MobRenderer<EntityAlicanto, AlicantoRenderState, ModelAlicanto<AlicantoRenderState>> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/alicanto.png");

    public RenderAlicanto(EntityRendererProvider.Context context) {
        super(context, new ModelAlicanto<>(context), 0.5F);
    }

    @Override
    public AlicantoRenderState createRenderState() {
        return new AlicantoRenderState();
    }

    @Override
    public void extractRenderState(EntityAlicanto entity, AlicantoRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.isActuallyOnGround = entity.onGround();
        state.walkAnimationPos = entity.walkAnimation.position(partialTicks);
        state.walkAnimationSpeed = entity.walkAnimation.speed(partialTicks);
        state.ageInTicks = entity.tickCount + partialTicks;
        state.attackTicks = entity.getAttackTick();
    }

    @Override
    public Identifier getTextureLocation(AlicantoRenderState state) {
        return TEXTURE;
    }
}