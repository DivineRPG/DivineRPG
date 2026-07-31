package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.models.state.AcidHagRenderState;
import divinerpg.client.models.vanilla.ModelEnderSpider;
import divinerpg.client.models.vethea.ModelAcidHag;
import divinerpg.entities.vanilla.end.EntityEnderSpider;
import divinerpg.entities.vethea.EntityAcidHag;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;


public class RenderAcidHag extends MobRenderer<EntityAcidHag, AcidHagRenderState, ModelAcidHag> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/entity/acid_hag.png");

    public RenderAcidHag(EntityRendererProvider.Context context) {
        super(context, new ModelAcidHag(context.bakeLayer(ModelAcidHag.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public AcidHagRenderState createRenderState() {
        return new AcidHagRenderState();
    }

    @Override
    public void extractRenderState(EntityAcidHag entity, AcidHagRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
    }

    @Override
    public Identifier getTextureLocation(AcidHagRenderState state) {
        return TEXTURE;
    }
}