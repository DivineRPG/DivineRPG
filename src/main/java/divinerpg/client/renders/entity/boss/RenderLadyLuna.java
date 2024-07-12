package divinerpg.client.renders.entity.boss;

import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.neoforged.api.distmarker.*;

import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class RenderLadyLuna extends RenderDivineMob<EntityLadyLuna> {
	private final ResourceLocation arcanic = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/lady_luna_arcanic.png"), ranged = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/lady_luna_ranged.png");
    public RenderLadyLuna(Context context) {
        super(context, "lady_luna", new ModelLadyLuna(context), 0.8F);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityLadyLuna entity) {
        EntityLadyLuna boss = entity;
        if (boss.getEntityData().get(EntityLadyLuna.PROTECTION) == 0)
            return arcanic;
        else if (boss.getEntityData().get(EntityLadyLuna.PROTECTION) == 1)
            return ranged;
        return TEXTURE;
    }
}