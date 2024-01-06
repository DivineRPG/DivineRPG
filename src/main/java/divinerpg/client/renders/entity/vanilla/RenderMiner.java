package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.renders.layer.MinerPickLayer;
import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

import static divinerpg.util.ClientUtils.layerHumanoid;

@OnlyIn(Dist.CLIENT)
public class RenderMiner extends MobRenderer<EntityMiner, HumanoidModel<EntityMiner>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/miner.png");

    public RenderMiner(Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(layerHumanoid)), 0.8F);
        this.addLayer(new MinerPickLayer(this));
    }
    public ResourceLocation getTextureLocation(EntityMiner entity) {
        return TEXTURE;
    }
}