package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityCoriShot;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityExperiencedCori extends EntityDivineFlyingMob implements RangedAttackMob {
    private ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE,
            BossEvent.BossBarOverlay.PROGRESS));
//    private int deathTicks;

    public EntityExperiencedCori(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        super(type, worldIn);
        xpReward=2000;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 3.8F;
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (this.isAlive()) {
            if (getTarget() != null && !level.isClientSide) {
                double tx = getTarget().getX() - this.getX();
                double ty = getTarget().getEyeY() - this.getEyeY();
                double tz = getTarget().getZ() - this.getZ();
                EntityCoriShot e = new EntityCoriShot(EntityRegistry.CORI_SHOT.get(), level, this, (float) getAttribute(Attributes.ATTACK_DAMAGE).getValue());
                double horizontalDistance = Math.sqrt(tx * tx + tz * tz);
                e.shoot(tx, ty, tz, 1.6f, 0);
                e.setDeltaMovement(tx / horizontalDistance * 1.6f, ty / horizontalDistance * 1.6f, tz / horizontalDistance * 1.6f);
                this.level.addFreshEntity(e);
            }
        }
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<Player>(this, Player.class, false));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 64.0F));
    }

    @Override
    public int getMaxSpawnClusterSize() {return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CORI_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CORI_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CORI_HURT.get();
    }

    @Override
    public boolean removeWhenFarAway(double dist) {
        return false;
    }

    public BossBarColor getBarColor() {
        return BossBarColor.WHITE;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossInfo.setColor(getBarColor());
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        if (this.isAlive() && this.random.nextInt(1000) < this.ambientSoundTime++)
        {
            this.playAmbientSound();
            if(!this.level.isClientSide) {
                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(getX() + random.nextInt(8), getY(), getZ() + random.nextInt(8));
                if (random.nextInt(10) == 1) {
                    EntityRegistry.WEAK_CORI.get().spawn((ServerLevel) level, ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, true, false);
                }
                if (random.nextInt(20) == 1) {
                    EntityRegistry.ADVANCED_CORI.get().spawn((ServerLevel) level, ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, true, false);
                }
            }
        }
    }
}