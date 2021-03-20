package divinerpg.client.renders.entity.arcana;

import com.mojang.blaze3d.matrix.*;
import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.entities.arcana.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;

public class RenderDungeonConstructor extends MobRenderer<EntityDungeonConstructor, ModelDramix<EntityDungeonConstructor>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/dungeon_constructor.png");

    public RenderDungeonConstructor(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelDramix<EntityDungeonConstructor>(), 0.4F);
    }
    protected void preRenderCallback(EntityDungeonConstructor entity, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.5F, 0.5F, 0.5F);
    }
    public ResourceLocation getTextureLocation(EntityDungeonConstructor entity) {
        return TEXTURE;
    }
}
