package divinerpg.client.renders.entity.vethea;

import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.entities.boss.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderLadyLuna extends MobRenderer<EntityLadyLuna, SegmentedModel<EntityLadyLuna>> {

    public RenderLadyLuna(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelLadyLuna(), 0.8F);


    }

    @Override
    public ResourceLocation getTextureLocation(EntityLadyLuna entity) {
        EntityLadyLuna boss = entity;
        if (boss.getProtectionType() == EntityLadyLuna.ProtectionType.ARCANA)
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_arcanic.png");
        else if (boss.getProtectionType() == EntityLadyLuna.ProtectionType.RANGED)
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_ranged.png");
        return new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna.png");
    }



}