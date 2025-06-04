package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.DivineThrowableProjectile;
import divinerpg.registries.*;
import divinerpg.util.WeightedRandom;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EntityExperiencedCori extends EntityDivineFlyingMonster implements RangedAttackMob {
    private final ServerBossEvent bossEvent = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);
    private final WeightedRandom<EntityType<? extends EntityDivineMonster>> coriTypePool = new WeightedRandom<>();

    public EntityExperiencedCori(EntityType<? extends EntityExperiencedCori> type, Level worldIn) {
        super(type, worldIn);
        xpReward = XP_REWARD_BOSS;
        coriTypePool.addItem(EntityRegistry.WEAK_CORI.get(), 4);
        coriTypePool.addItem(EntityRegistry.ADVANCED_CORI.get(), 1);
    }
    @Override
    public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((s) -> s.withHoverEvent(createHoverEvent()).withInsertion(getStringUUID()).withBold(true));
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if (this.isAlive()) {
            if (getTarget() != null && !level().isClientSide) {
                double tx = getTarget().getX() - this.getX();
                double ty = getTarget().getEyeY() - this.getEyeY();
                double tz = getTarget().getZ() - this.getZ();
                DivineThrowableProjectile e = EntityRegistry.CORI_SHOT.get().create(level());
                e.setPos(getEyePosition());
                e.setOwner(this);
                e.baseDamage = 80F;
                double horizontalDistance = Math.sqrt(tx * tx + tz * tz);
                e.shoot(tx, ty, tz, 1.6f, 0);
                e.setDeltaMovement(tx / horizontalDistance * 1.6f, ty / horizontalDistance * 1.6f, tz / horizontalDistance * 1.6f);
                this.level().addFreshEntity(e);
            }
        }
    }
    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossEvent.setName(getDisplayName());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(hasCustomName()) bossEvent.setName(getDisplayName());
    }
    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }
    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<Player>(this, Player.class, false));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 64.0F));
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
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

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        bossEvent.setProgress(getHealth() / getMaxHealth());
        if (this.isAlive() && this.ambientSoundTime % (20 * (10 + random.nextInt(10))) == 0) {
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(getX() + random.nextInt(8), getY(), getZ() + random.nextInt(8));
            EntityType<? extends EntityDivineMonster> selectedCoriType = coriTypePool.selectRandomItem(new Random());
            if (selectedCoriType != null) {
                selectedCoriType.spawn((ServerLevel) level(), ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, true, false);
            }
        }
    }
}
