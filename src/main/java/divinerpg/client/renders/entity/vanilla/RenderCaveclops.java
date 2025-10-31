package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.entities.vanilla.overworld.EntityCaveclops;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.OnlyIn;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.util.ClientUtils.layerHumanoid;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class RenderCaveclops extends HumanoidMobRenderer<EntityCaveclops, HumanoidModel<EntityCaveclops>> {
    private final ResourceLocation CAVECLOPS = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/caveclops.png");
    public RenderCaveclops(EntityRendererProvider.Context context) {super(context, new HumanoidModel<>(context.bakeLayer(layerHumanoid)), .8F, 2, 2, 2);}
    @Override protected void scale(EntityCaveclops livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(2, 2, 2);
        super.scale(livingEntity, poseStack, partialTickTime);
    }
    @Override public ResourceLocation getTextureLocation(EntityCaveclops entity) {return CAVECLOPS;}
}