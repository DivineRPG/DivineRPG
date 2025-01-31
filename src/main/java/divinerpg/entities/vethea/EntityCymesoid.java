package divinerpg.entities.vethea;


import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityCymesoid extends EntityDivineMonster {
    public EntityCymesoid(EntityType<? extends EntityCymesoid> type, Level worldIn) {super(type, worldIn);}
    @Override public void tick() {
        super.tick();
        Player player = level().getNearestPlayer(this, 64);
        if(player != null && !player.isCreative())  {
            Vec3 playerLook = player.getLookAngle().normalize();
            Vec3 positionQuotient = new Vec3(getX() - player.getX(), getBoundingBox().minY + getEyeHeight() / 2 - (player.getY() + player.getEyeHeight()), getZ() - player.getZ());
            double distance = positionQuotient.length();
            positionQuotient = positionQuotient.normalize();
            double dotProduct = playerLook.dot(positionQuotient);
            if(dotProduct > 1 - .025 / distance && player.hasLineOfSight(this))
                addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10 * 20, 1));
        }
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.CYMESOID.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.CYMESOID_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.CYMESOID_HURT.get();}
}