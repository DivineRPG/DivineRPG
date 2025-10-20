package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.DivineThrownItem;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.core.particles.*;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class EntityKobblin extends EntityDivineMonster implements RangedAttackMob {
    public int clientBiomeColor = 0xFF00;
    boolean prefersShooting;
    public EntityKobblin(EntityType<? extends EntityKobblin> type, Level worldIn) {super(type, worldIn);}
    @Override public void onAddedToLevel() {
        super.onAddedToLevel();
        prefersShooting = getRandom().nextBoolean();
        if(level().isClientSide) clientBiomeColor = level().getBiome(blockPosition()).value().getGrassColor(getX(), getZ());
    }
    public static boolean kobblinSpawnRule(LevelAccessor worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).is(BlockTags.DIRT);
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true) {@Override public boolean canUse() {return !prefersShooting && super.canUse() && !isEmerging();}});
        goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1) {@Override public boolean canUse() {return super.canUse() && !isEmerging();}});
        goalSelector.addGoal(3, new KobblinRangedAttackGoal(1.25, 40, 60, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        targetSelector.addGoal(0, new HurtByTargetGoal(this) {@Override public boolean canUse() {return super.canUse() && !isEmerging();}});
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true) {@Override public boolean canUse() {return super.canUse() && !isEmerging();}});
    }
    @Override public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity entity) {
        return new ClientboundAddEntityPacket(this, entity, getPose().id());
    }
    @Override public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        if(packet.getData() == 0) setPose(Pose.STANDING);
        else if(packet.getData() == 13) setPose(Pose.EMERGING);
        else if(packet.getData() == 16) setPose(Pose.SHOOTING);
    }
    @Override public boolean isInvulnerableTo(DamageSource source) {return isEmerging() || super.isInvulnerableTo(source);}
    boolean isEmerging() {return hasPose(Pose.EMERGING);}
    @Override public void tick() {
        super.tick();
        if(hasPose(Pose.EMERGING)) {
            if(level().isClientSide) {
                clientDiggingParticles();
                if((tickCount & 3) == 0) level().playLocalSound(this, SoundEvents.ROOTED_DIRT_PLACE, SoundSource.HOSTILE, 1, 1);
            } if(tickCount > 20) setPose(Pose.STANDING);
        }
    }
    private void clientDiggingParticles() {
        RandomSource randomsource = getRandom();
        BlockState blockstate = getBlockStateOn();
        if(blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            double dx, dy, dz;
            for(int i = 0; i < 8; ++i) {
                dx = getX() + Mth.randomBetween(randomsource, -.3F, .3F);
                dy = getY();
                dz = getZ() + Mth.randomBetween(randomsource, -.3F, .3F);
                level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), dx, dy, dz, 0, 0, 0);
            }
        }
    }
    @Override public boolean ignoreExplosion(Explosion explosion) {return isEmerging();}
    @SuppressWarnings("deprecation")
    @Override public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        if(spawnType == MobSpawnType.TRIGGERED && level.getBlockState(getOnPos()).is(BlockTags.DIRT)) setPose(Pose.EMERGING);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
    @Override public EntityDimensions getDefaultDimensions(Pose pose) {
        EntityDimensions entitydimensions = super.getDefaultDimensions(pose);
        return isEmerging() ? EntityDimensions.fixed(entitydimensions.width(), 1) : entitydimensions;
    }
    @Override public boolean isPushable() {return !isEmerging() && super.isPushable();}
    @Override public void performRangedAttack(LivingEntity livingEntity, float v) {
        if(isAlive() && getTarget() != null && !level().isClientSide) {
            DivineThrownItem shot = EntityRegistry.THROWN_ITEM.get().create(level());
            shot.setItem(Blocks.COARSE_DIRT.asItem().getDefaultInstance());
            shot.setOwner(this);
            shot.setPos(getEyePosition());
            double d0 = getTarget().getX() - getX();
            double d1 = getTarget().getY(.3333333333333333) - shot.getY() - .25;
            double d2 = getTarget().getZ() - getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            shot.shoot(d0, d1 + d3 * .18, d2, 1.6F, .5F);
            level().addFreshEntity(shot);
        }
    }
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.KOBBLIN.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.KOBBLIN.get();}
    class KobblinRangedAttackGoal extends Goal {
        final double speedModifier;
        final int attackIntervalMin, attackIntervalMax;
        final float attackRadius, attackRadiusSqr;
        int attackTime, seeTime;
        LivingEntity target;
        public KobblinRangedAttackGoal(double speedModifier, int attackIntervalMin, int attackIntervalMax, float attackRadius) {
            this.speedModifier = speedModifier;
            this.attackIntervalMin = attackIntervalMin;
            this.attackIntervalMax = attackIntervalMax;
            this.attackRadius = attackRadius;
            attackRadiusSqr = attackRadius * attackRadius;
            setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }
        @Override public boolean canUse() {
            LivingEntity livingentity = getTarget();
            if(livingentity != null && livingentity.isAlive()) {
                target = livingentity;
                return prefersShooting && !isEmerging();
            } else return false;
        }
        @Override public boolean canContinueToUse() {return canUse() || target.isAlive() && !getNavigation().isDone();}
        @Override public void stop() {
            target = null;
            seeTime = 0;
            attackTime = -1;
            if(hasPose(Pose.SHOOTING)) setPose(Pose.STANDING);
        }
        @Override public boolean requiresUpdateEveryTick() {return true;}
        @Override public void tick() {
            double d0 = distanceToSqr(target.getX(), target.getY(), target.getZ());
            boolean hasSight = getSensing().hasLineOfSight(target);
            seeTime = hasSight ? seeTime + 1 : 0;
            if(!(d0 > attackRadiusSqr) && seeTime >= 5) getNavigation().stop();
            else getNavigation().moveTo(target, speedModifier);
            getLookControl().setLookAt(target, 30, 30);
            attackTime--;
            if(attackTime == 10) setPose(Pose.SHOOTING);
            else if(attackTime == 5) {
                if(!hasSight) return;
                performRangedAttack(target, Mth.clamp((float)Math.sqrt(d0) / attackRadius, .1F, 1));
            } else if(attackTime == 0) {
                setPose(Pose.STANDING);
                attackTime = Mth.floor((float)Math.sqrt(d0) / attackRadius * (attackIntervalMax - attackIntervalMin) + attackIntervalMin);
            } else if(attackTime < 0) attackTime = Mth.floor(Mth.lerp(Math.sqrt(d0) / attackRadius, attackIntervalMin, attackIntervalMax));
        }
    }
}