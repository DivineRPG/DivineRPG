package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityVermenous extends EntityDivineMonster {

    public EntityVermenous(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.5F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();
        Player var1 = this.level.getNearestPlayer(this, 64.0D);

        if (var1 == null || var1.isCreative())
            return;
        else {
            Vec3 var3 = var1.getLookAngle().normalize();
            Vec3 var4 = new Vec3(this.getX() - var1.getX(), this.getBoundingBox().minY + this.getEyeHeight() / 2.0F - (var1.getY() + var1.getEyeHeight()), this.getZ() - var1.getZ());
            double var5 = var4.length();
            var4 = var4.normalize();
            double var7 = var3.dot(var4);
            if( var7 > 1.0D - 0.025D / var5 && var1.hasLineOfSight(this)) {
                var1.hurt(damageSources().mobAttack(this), 4);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VERMENOUS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VERMENOUS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VERMENOUS_HURT.get();
    }
}