package divinerpg.client.renders.entity.iceika;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelGroglin;
import divinerpg.entities.iceika.groglin.Groglin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;

public class RenderGroglin<T extends Groglin, S extends HumanoidRenderState, M extends ModelGroglin<S>> extends HumanoidMobRenderer<T, S, M> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/groglin.png");

    @SuppressWarnings("unchecked")
    public RenderGroglin(EntityRendererProvider.Context context) {
        super(context, (M) new ModelGroglin(context.bakeLayer(ModelGroglin.LAYER_LOCATION)), 0.4F);
        //TODO - layer
//        this.addLayer(new HumanoidArmorLayer<>(this, new ModelGroglin(context.bakeLayer(ModelLayers.SKELETON)), new ModelGroglin(context.bakeLayer(ModelLayers.SKELETON)), context.getEquipmentRenderer()));
    }

    @Override
    public S createRenderState() {
        return (S) new HumanoidRenderState();
    }

    @Override
    public Identifier getTextureLocation(S state) {
        return TEXTURE;
    }

    @Override
    protected void scale(S state, PoseStack stack) {
        stack.scale(0.8F, 0.8F, 0.8F);
    }
}