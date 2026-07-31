package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.Identifier;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

import static divinerpg.utils.Utils.layerHumanoid;

public class RenderMiner extends HumanoidMobRenderer<EntityMiner, HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/miner.png");

    public RenderMiner(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.5F);
    }

    @Override
    public HumanoidRenderState createRenderState() {
        return new HumanoidRenderState();
    }

    @Override
    public Identifier getTextureLocation(HumanoidRenderState state) {
        return TEXTURE;
    }
}