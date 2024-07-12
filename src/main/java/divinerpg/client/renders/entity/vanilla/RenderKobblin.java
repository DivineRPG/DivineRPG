package divinerpg.client.renders.entity.vanilla;


import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.*;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderKobblin extends MobRenderer<EntityKobblin, ModelKobblin> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/kobblin.png");

    public RenderKobblin(Context context) {
        super(context, new ModelKobblin(context), 0.0F);
    }

    protected void scale(EntityKobblin entity, PoseStack matrixStackIn, float partialTickTime) {
        if(entity instanceof EntityKobblin && !((EntityKobblin) entity).getProvoked()){
            matrixStackIn.translate(0, 1.325F, 0);
        }
    }



    public ResourceLocation getTextureLocation(EntityKobblin entity) {
        return TEXTURE;
    }
}