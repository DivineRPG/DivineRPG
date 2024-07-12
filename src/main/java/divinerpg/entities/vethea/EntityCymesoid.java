package divinerpg.entities.vethea;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

public class EntityCymesoid extends EntityDivineMonster {

    public EntityCymesoid(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void tick() {
        super.tick();
        Player player = this.level().getNearestPlayer(this, 64.0D);

        if (player == null || player.isCreative())
            return;
        else {
            Vec3 playerLook = player.getLookAngle().normalize();
            Vec3 positionQuotient = new Vec3(this.getX() - player.getX(), this.getBoundingBox().minY + this.getEyeHeight() / 2.0F - (player.getY() + player.getEyeHeight()), this.getZ() - player.getZ());
            double distance = positionQuotient.length();
            positionQuotient = positionQuotient.normalize();
            double dotProduct = playerLook.dot(positionQuotient);
            if( dotProduct > 1.0D - 0.025D / distance && player.hasLineOfSight(this)) {
                this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 1));
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYMESOID.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYMESOID_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYMESOID_HURT.get();
    }
}