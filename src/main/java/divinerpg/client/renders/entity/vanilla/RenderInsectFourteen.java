package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.models.state.InsectFourteenRenderState;
import divinerpg.client.models.vethea.ModelInsectFourteen;
import divinerpg.entities.vethea.EntityInsectFourteen;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;


public class RenderInsectFourteen extends MobRenderer<EntityInsectFourteen, InsectFourteenRenderState, ModelInsectFourteen> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/insect_fourteen_attacking.png");
    public RenderInsectFourteen(EntityRendererProvider.Context context) {
        super(context, new ModelInsectFourteen(context), 0.5F);
    }

    @Override
    public InsectFourteenRenderState createRenderState() {
        return new InsectFourteenRenderState();
    }

    @Override
    public Identifier getTextureLocation(InsectFourteenRenderState state) {
        return TEXTURE;
    }
}