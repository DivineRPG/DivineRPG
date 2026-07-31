package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.entities.projectile.fireball.EntityFyracryxFireball;
import divinerpg.registries.SoundRegistry;
import divinerpg.registries.TagRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityFyracryx extends EntityDivineTameable implements RangedAttackMob {
    public EntityFyracryx(EntityType<? extends EntityFyracryx> type, Level worldIn) {super(type, worldIn, 1);}
    @Override public void tick() {
        super.tick();
        if(getTarget() != null && !level().isClientSide() && tickCount % 20 == 0) performRangedAttack(getTarget(), 0);
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null && !level().isClientSide()) {
            EntityFyracryxFireball projectile = new EntityFyracryxFireball(level(), this, target.xo - xo + random.nextGaussian() * Mth.sqrt(distanceTo(this)) * .5, target.getBoundingBox().minY - xo,
                    target.zo - zo + random.nextGaussian() * Mth.sqrt(distanceTo(this)) * .5);
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY();
            double d2 = getTarget().getZ() - getZ();
            double d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
        }
    }
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_FYRACRYX);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.TAMING_FYRACRYX);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.DEATHCRYX.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.DEATHCRYX_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.DEATHCRYX.get();}
}