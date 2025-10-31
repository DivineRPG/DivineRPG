package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.entities.vanilla.overworld.EntityCyclops;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.OnlyIn;

import static divinerpg.util.ClientUtils.layerHumanoid;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class RenderCyclops extends HumanoidMobRenderer<EntityCyclops, HumanoidModel<EntityCyclops>> {
    private final ResourceLocation
            CYCLOPS = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/cyclops.png"),
            CYCLOPS_ANGRY = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/cyclops_angry.png");
    public RenderCyclops(EntityRendererProvider.Context context) {super(context, new HumanoidModel<>(context.bakeLayer(layerHumanoid)), .8F);}
    @Override protected void scale(EntityCyclops livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(2, 2, 2);
        super.scale(livingEntity, poseStack, partialTickTime);
    }
    @Override public ResourceLocation getTextureLocation(EntityCyclops entity) {
        return entity.isAggressive() ? CYCLOPS_ANGRY : CYCLOPS;
    }
}