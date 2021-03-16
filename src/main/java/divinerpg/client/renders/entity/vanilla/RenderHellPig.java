package divinerpg.client.renders.entity.vanilla;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.entities.vanilla.nether.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderHellPig extends MobRenderer<EntityHellPig, PigModel<EntityHellPig>> {
    ResourceLocation hellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/hell_pig.png");
    ResourceLocation madHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/mad_hell_pig.png");
    ResourceLocation tamedHellPigLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/tamed_hell_pig.png");

    public RenderHellPig(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new PigModel<EntityHellPig>(), 1.0F);
    }
    protected void preRenderCallback(EntityHellPig entity, MatrixStack matrixStackIn, float partialTickTime) {
    }
    public ResourceLocation getTextureLocation(EntityHellPig entity) {
        return entity.isTame() ? tamedHellPigLoc : (entity.isAngry() ? madHellPigLoc : hellPigLoc);
    }
}