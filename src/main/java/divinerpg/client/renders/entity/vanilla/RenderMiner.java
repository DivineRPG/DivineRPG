package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

import static divinerpg.util.ClientUtils.layerHumanoid;

@OnlyIn(Dist.CLIENT)
public class RenderMiner extends HumanoidMobRenderer<EntityMiner, HumanoidModel<EntityMiner>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/miner.png");
    public RenderMiner(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(layerHumanoid)), .5F);
    }
    @Override public ResourceLocation getTextureLocation(EntityMiner entity) {return TEXTURE;}
}