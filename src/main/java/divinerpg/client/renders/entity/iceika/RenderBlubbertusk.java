package divinerpg.client.renders.entity.iceika;

import divinerpg.client.models.iceika.ModelBlubbertusk;
import divinerpg.client.models.state.BlubbertuskRenderState;
import divinerpg.entities.iceika.EntityBlubbertusk;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderBlubbertusk extends MobRenderer<EntityBlubbertusk, BlubbertuskRenderState, ModelBlubbertusk<BlubbertuskRenderState>> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/blubbertusk.png");

    public RenderBlubbertusk(EntityRendererProvider.Context context) {
        super(context, new ModelBlubbertusk<>(context), 0.7F);
    }

    @Override
    public BlubbertuskRenderState createRenderState() {
        return new BlubbertuskRenderState();
    }

    @Override
    public void extractRenderState(EntityBlubbertusk entity, BlubbertuskRenderState state, float partialTicks) {

        super.extractRenderState(entity, state, partialTicks);

        state.onGround = entity.onGround();
    }

    @Override
    public Identifier getTextureLocation(BlubbertuskRenderState state) {
        return TEXTURE;
    }
}