package divinerpg.objects.entities.assets.render.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vethea.ModelLadyLuna;
import divinerpg.objects.entities.entity.vethea.EntityLadyLuna;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderLadyLuna extends RenderLiving<EntityLadyLuna> {


    public RenderLadyLuna(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelLadyLuna(), 1F);
    }


    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityLadyLuna entity) {
        EntityLadyLuna boss = entity;
        if (boss.getProtectionType() == EntityLadyLuna.ProtectionType.ARCANA)
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_arcanic.png");
        else if (boss.getProtectionType() == EntityLadyLuna.ProtectionType.RANGED)
            return new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna_ranged.png");
        return new ResourceLocation(DivineRPG.MODID, "textures/entity/lady_luna.png");
    }

}