package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;

public class EntityVermenous extends EntityDivineMonster {
    public EntityVermenous(EntityType<? extends EntityVermenous> type, Level worldIn) {super(type, worldIn);}
    @Override public void tick() {
        super.tick();
        Player var1 = level().getNearestPlayer(this, 64);
        if(var1 == null || var1.isCreative()) return;
        else {
            Vec3 var3 = var1.getLookAngle().normalize();
            Vec3 var4 = new Vec3(this.getX() - var1.getX(), getBoundingBox().minY + getEyeHeight() / 2 - (var1.getY() + var1.getEyeHeight()), getZ() - var1.getZ());
            double var5 = var4.length();
            var4 = var4.normalize();
            double var7 = var3.dot(var4);
            if(var7 > 1 - .025 / var5 && var1.hasLineOfSight(this)) var1.hurt(damageSources().mobAttack(this), 4);
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.VERMENOUS.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.VERMENOUS_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.VERMENOUS_HURT.get();}
}