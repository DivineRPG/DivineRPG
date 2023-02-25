
package divinerpg.client.renders.entity.twilight;


import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Vector3f;
import divinerpg.*;
import divinerpg.client.models.twilight.ModelDemonOfDarkness;
import divinerpg.entities.mortum.EntityDemonOfDarkness;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDemonOfDarkness extends MobRenderer<EntityDemonOfDarkness, ModelDemonOfDarkness> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/demon_of_darkness.png");
    public RenderDemonOfDarkness(Context context) {
        super(context, new ModelDemonOfDarkness(context), .8F);
    }
    protected void scale(EntityDemonOfDarkness entity, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180F));
    }
    public ResourceLocation getTextureLocation(EntityDemonOfDarkness entity) {
        return TEXTURE;
    }
}