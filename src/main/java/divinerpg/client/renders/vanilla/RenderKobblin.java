package divinerpg.client.renders.vanilla;


import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.*;
import divinerpg.registries.EntityRegistry;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderKobblin extends MobRenderer<EntityKobblin, ModelKobblin<EntityKobblin>> {
    ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/kobblin.png");

    public RenderKobblin(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelKobblin<>(), 0.8F);
    }
    protected void preRenderCallback(EntityKobblin entity, MatrixStack matrixStackIn, float partialTickTime) {
        if(entity instanceof EntityKobblin && !((EntityKobblin) entity).getProvoked()){
            matrixStackIn.translate(0, 1.125F, 0);
        }
    }

    public ResourceLocation getEntityTexture(EntityKobblin entity) {
        return TEXTURE;
    }
}