package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMonster;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.*;
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

public class EntityTheWatcher extends EntityDivineFlyingMonster implements RangedAttackMob {
    private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE,
            BossEvent.BossBarOverlay.PROGRESS);
    public EntityTheWatcher(EntityType<? extends EntityDivineFlyingMonster> type, Level worldIn) {
        super(type, worldIn, 5, 9, 10);
        xpReward = XP_REWARD_BOSS;
    }
    @Override public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((s) -> s.withHoverEvent(createHoverEvent()).withInsertion(getStringUUID()).withBold(true));
    }
    @Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {return false;}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new RangedAttackGoal(this, 1, 40, 40));
    }
    @Override public void performRangedAttack(LivingEntity entity, float range) {
        if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = EntityRegistry.WATCHER_SHOT.get().create(level());
            projectile.setPos(getEyePosition());
            projectile.setOwner(this);
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - projectile.getY() - .25;
            double d2 = getTarget().getZ() - getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, 13 - level().getDifficulty().getId() * 4);
            level().addFreshEntity(projectile);
            playAttackSound();
        }
    }
    @Override public boolean hurt(DamageSource source, float amount) {
        if(this.isInvulnerableTo(source)) return false;
        else if(source.getEntity() instanceof LargeFireball && source.getDirectEntity() instanceof Player) {
            super.hurt(source, 1000);
            return true;
        } else return super.hurt(source, amount);
    }
    @Override protected void playAttackSound() {playSound(SoundEvents.BLAZE_SHOOT);}
    @Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(hasCustomName()) bossInfo.setName(getDisplayName());
    }
    @Override public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossInfo.setName(getDisplayName());
    }
    @Override protected void customServerAiStep() {
        super.customServerAiStep();
        bossInfo.setProgress(getHealth() / getMaxHealth());
    }
    @Override public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossInfo.addPlayer(player);
    }
    @Override public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }
}