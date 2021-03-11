package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.arcana.ModelDramix;
import divinerpg.entities.arcana.EntityDungeonConstructor;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDungeonConstructor extends MobRenderer<EntityDungeonConstructor, ModelDramix<EntityDungeonConstructor>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_constructor.png");

    public RenderDungeonConstructor(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelDramix<EntityDungeonConstructor>(), 0.4F);
    }
    protected void preRenderCallback(EntityDungeonConstructor entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    }
    public ResourceLocation getEntityTexture(EntityDungeonConstructor entity) {
        return TEXTURE;
    }
}
