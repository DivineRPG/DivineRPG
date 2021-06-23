package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.*;
import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.arcana.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderKazari extends MobRenderer<EntityKazari, ModelCyclops<EntityKazari>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/kazari.png");

    public RenderKazari(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityKazari>(1), 0.8F);
    }

    protected void scale(MobEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1, 1, 1);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityKazari entity) {
        return TEXTURE;
    }
}
