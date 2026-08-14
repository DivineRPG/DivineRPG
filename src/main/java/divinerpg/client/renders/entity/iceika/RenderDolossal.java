package divinerpg.client.renders.entity.iceika;

import divinerpg.client.models.iceika.ModelDolossal;
import divinerpg.client.models.state.DolossalRenderState;
import divinerpg.entities.iceika.EntityDolossal;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderDolossal extends MobRenderer<EntityDolossal, DolossalRenderState, ModelDolossal<DolossalRenderState>> {

    private static final Identifier TEXTURE =
            Identifier.fromNamespaceAndPath(MODID, "textures/entity/dolossal.png");

    public RenderDolossal(EntityRendererProvider.Context context) {
        super(context, new ModelDolossal<>(context), 0.9F);
    }

    @Override
    public DolossalRenderState createRenderState() {
        return new DolossalRenderState();
    }

    @Override
    public void extractRenderState(EntityDolossal entity, DolossalRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.onGround = entity.onGround();
        state.walkAnimationPos = entity.walkAnimation.position(partialTicks);
        state.walkAnimationSpeed = entity.walkAnimation.speed(partialTicks);
        state.ageInTicks = entity.tickCount + partialTicks;
    }

    @Override
    public Identifier getTextureLocation(DolossalRenderState state) {
        return TEXTURE;
    }
}