package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.arcana.EntityKazari;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

public class RenderKazari extends MobRenderer<EntityKazari, ModelCyclops<EntityKazari>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/kazari.png");

    public RenderKazari(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityKazari>(1), 0.8F);
    }
    protected void preRenderCallback(EntityKazari entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1, 1, 1);
    }
    public ResourceLocation getEntityTexture(EntityKazari entity) {
        return TEXTURE;
    }
}
