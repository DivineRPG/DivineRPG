package divinerpg.client.renders.entity.vanilla;


import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelKobblin;
import divinerpg.entities.vanilla.overworld.EntityKobblin;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderKobblin extends MobRenderer<EntityKobblin, ModelKobblin> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/kobblin.png");

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