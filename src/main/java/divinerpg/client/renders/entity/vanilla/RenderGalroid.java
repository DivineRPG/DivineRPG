package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.models.state.GalroidRenderState;
import divinerpg.client.models.vethea.ModelGalroid;
import divinerpg.entities.vethea.EntityGalroid;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;


public class RenderGalroid extends MobRenderer<EntityGalroid, GalroidRenderState, ModelGalroid> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/galroid.png"), INVULNERABLE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/galroid_invulnerable.png");
    private boolean isInvulnerable;
    public RenderGalroid(EntityRendererProvider.Context context) {
        super(context, new ModelGalroid(context), 0.5F);
    }

    @Override
    public void extractRenderState(EntityGalroid entity, GalroidRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        isInvulnerable = entity.isInvulnerable();
    }

    @Override
    public GalroidRenderState createRenderState() {
        return new GalroidRenderState();
    }

    @Override
    public Identifier getTextureLocation(GalroidRenderState state) {
        if(isInvulnerable) return INVULNERABLE;
        return TEXTURE;
    }
}