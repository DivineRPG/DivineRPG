package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelKobblin;
import divinerpg.entities.vanilla.overworld.EntityKobblin;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderKobblin extends MobRenderer<EntityKobblin, ModelKobblin> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/kobblin.png");
    public RenderKobblin(EntityRendererProvider.Context context) {super(context, new ModelKobblin(context), .5F);}
    @Override protected void scale(EntityKobblin entity, PoseStack matrixStackIn, float partialTickTime) {
        if(entity.hasPose(Pose.EMERGING)) matrixStackIn.translate(0, 1.325F - .053F * entity.tickCount, 0);
    }
    @Override public ResourceLocation getTextureLocation(EntityKobblin entity) {return TEXTURE;}
}