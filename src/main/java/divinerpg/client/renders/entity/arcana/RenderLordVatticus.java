package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.*;
import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.arcana.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;

public class RenderLordVatticus extends MobRenderer<EntityLordVatticus, ModelCyclops<EntityLordVatticus>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/lord_vatticus.png");

    public RenderLordVatticus(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityLordVatticus>(1), 0.8F);
    }
    protected void scale(EntityLordVatticus entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1, 1, 1);
    }
    public ResourceLocation getTextureLocation(EntityLordVatticus entity) {
        return TEXTURE;
    }
}
