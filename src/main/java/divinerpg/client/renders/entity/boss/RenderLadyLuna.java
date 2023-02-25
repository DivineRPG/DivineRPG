package divinerpg.client.renders.entity.boss;

import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraftforge.api.distmarker.*;

import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class RenderLadyLuna extends RenderDivineMob<EntityLadyLuna> {
	private final ResourceLocation arcanic = new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_arcanic.png"), ranged = new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_ranged.png");
    public RenderLadyLuna(Context context) {
        super(context, "lady_luna", new ModelLadyLuna(context), 0.8F);
    }
    @Override
    public ResourceLocation getTextureLocation(EntityLadyLuna entity) {
        EntityLadyLuna boss = entity;
        if (boss.getProtectionType() == EntityLadyLuna.ProtectionType.ARCANA)
            return arcanic;
        else if (boss.getProtectionType() == EntityLadyLuna.ProtectionType.RANGED)
            return ranged;
        return TEXTURE;
    }
}