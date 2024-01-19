package divinerpg.client.renders.entity.boss;

import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelLadyLuna;
import divinerpg.client.renders.base.RenderDivineMob;
import divinerpg.entities.boss.EntityLadyLuna;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderLadyLuna extends RenderDivineMob<EntityLadyLuna> {
	private final ResourceLocation arcanic = new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_arcanic.png"), ranged = new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_ranged.png");
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