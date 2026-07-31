package divinerpg.client.renders.entity.projectile;

import divinerpg.DivineRPG;
import divinerpg.entities.projectile.DivineArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class RenderDivineArrow extends ArrowRenderer<DivineArrow, ArrowRenderState> {
    protected final Identifier TEXTURE;
    public RenderDivineArrow(EntityRendererProvider.Context context, String textureName) {
        super(context);
        TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/projectiles/" + textureName + ".png");
    }
    @Override protected Identifier getTextureLocation(ArrowRenderState arrowRenderState) {return TEXTURE;}

    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}