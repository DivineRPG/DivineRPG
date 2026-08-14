package divinerpg.client.renders.entity.iceika;

import divinerpg.client.models.iceika.ModelRollum;
import divinerpg.client.models.state.RollumRenderState;
import divinerpg.entities.iceika.EntityRollum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderRollum extends LivingEntityRenderer<EntityRollum, RollumRenderState, ModelRollum<RollumRenderState>> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/rollum.png");

    public RenderRollum(EntityRendererProvider.Context context) {
        super(context, new ModelRollum<>(context), 0.7F);
    }

    @Override
    public RollumRenderState createRenderState() {
        return new RollumRenderState();
    }

    @Override
    public void extractRenderState(EntityRollum entity, RollumRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);

        state.attackTime = (int) entity.getAttackAnim(partialTick);
    }

    @Override
    public Identifier getTextureLocation(RollumRenderState state) {
        return TEXTURE;
    }
}