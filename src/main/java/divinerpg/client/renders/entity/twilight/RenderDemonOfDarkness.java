package divinerpg.client.renders.entity.twilight;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelDemonOfDarkness;
import divinerpg.entities.mortum.EntityDemonOfDarkness;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDemonOfDarkness extends MobRenderer<EntityDemonOfDarkness, ModelDemonOfDarkness> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/demon_of_darkness.png");
    public RenderDemonOfDarkness(Context context) {
        super(context, new ModelDemonOfDarkness(context), .8F);
    }
    protected void scale(EntityDemonOfDarkness entity, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(180F));
    }
    public ResourceLocation getTextureLocation(EntityDemonOfDarkness entity) {
        return TEXTURE;
    }
}