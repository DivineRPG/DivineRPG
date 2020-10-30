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
public class RenderCyclops extends MobRenderer<EntityCyclops, ModelCyclops<EntityCyclops>> {
    ResourceLocation cyclopsLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/cyclops.png");
    ResourceLocation angryCyclopsLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_cyclops.png");

    public RenderCyclops(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelCyclops<EntityCyclops>(1), 0.8F);
    }
    protected void preRenderCallback(EntityCyclops entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(2, 2, 2);
    }

    public ResourceLocation getEntityTexture(EntityCyclops entity) {
        return entity.isAngry() ? angryCyclopsLoc : cyclopsLoc;
    }
}