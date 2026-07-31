package divinerpg.entities.boss;

import divinerpg.entities.projectile.bullet.BoneBomb;
import divinerpg.entities.vanilla.overworld.EntityWhale;
import divinerpg.registries.DamageRegistry;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class EntityKitra extends EntityWhale implements RangedAttackMob {
    // TODO: the fog appears/ends abruptly when getting close to or leaving the boss behind
    private final ServerBossEvent bossInfo = (ServerBossEvent) new ServerBossEvent(uuid, getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS).setCreateWorldFog(true);

    public EntityKitra(EntityType<? extends EntityWhale> type, Level level) {
        super(type, level);
    }

    @Override
    protected int getBaseExperienceReward(ServerLevel level) {
        return XP_REWARD_BOSS;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new RangedAttackGoal(this, 0.27F, 80, 32.0F));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((style) -> style
                .withHoverEvent(createHoverEvent())
                .withInsertion(getStringUUID())
                .withBold(true)
                .withColor(0xA4F4F9));
    }

    @Override
    public boolean isPersistenceRequired() {
        return false;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        bossInfo.removePlayer(player);
    }

    @Override
    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossInfo.setName(getDisplayName());
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        if (hasCustomName()) {
            bossInfo.setName(getDisplayName());
        }
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level().isClientSide()) {
            BoneBomb boneBomb = EntityRegistry.BONE_BOMB.get().create(level(), EntitySpawnReason.MOB_SUMMONED);
            if (boneBomb != null) {
                double dx = getTarget().getX() - getX();
                double dy = getTarget().getY() - getY();
                double dz = getTarget().getZ() - getZ();
                boneBomb.setOwner(this);
                boneBomb.shoot(dx, dy, dz, 1.5F, 0.8F);
                boneBomb.setPos(position().x, position().y + 1.5D, position().z);
                level().addFreshEntity(boneBomb);
            }

            if (level() instanceof ServerLevel serverLevel) {
                hurtServer(serverLevel, damageSources().magic(), 10.0F);
            }

            double dx = getTarget().getX() - getX();
            double dy = getTarget().getY() - getY();
            double dz = getTarget().getZ() - getZ();

            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (distance > 0.0D) {
                dx /= distance;
                dy /= distance;
                dz /= distance;
            }

            double speed = getAttributeValue(Attributes.MOVEMENT_SPEED);
            double motionX = dx * speed;
            double motionY = dy * speed;
            double motionZ = dz * speed;

            setDeltaMovement(getDeltaMovement().add(motionX, motionY, motionZ));
        }
    }

    @Override
    protected void customServerAiStep(ServerLevel level) {
        super.customServerAiStep(level);
        bossInfo.setProgress(getHealth() / getMaxHealth());
    }

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide() && level() instanceof ServerLevel serverLevel && random.nextInt(500) == 0) {
            double x = getX() + (random.nextDouble() - 0.5D) * 8.0D;
            double y = getY();
            double z = getZ() + (random.nextDouble() - 0.5D) * 8.0D;
            BlockPos pos = BlockPos.containing(x, y, z);
            BlockState state = level().getBlockState(pos);

            if (state.getFluidState().is(FluidTags.WATER)) {
                List<EntityType<?>> fishEntities = Arrays.asList(
                        EntityTypes.PUFFERFISH,
                        EntityRegistry.SHARK.get(),
                        EntityRegistry.AEQUOREA.get(),
                        EntityTypes.GLOW_SQUID
                );
                EntityType<?> randomFishEntity = fishEntities.get(level().getRandom().nextInt(fishEntities.size()));
                if (level().noCollision(randomFishEntity.getSpawnAABB(x, y, z).deflate(0.0625D))) {
                    randomFishEntity.spawn(serverLevel, pos, EntitySpawnReason.REINFORCEMENT);
                }
            } else if (state.isAir() && level().noCollision(EntityRegistry.ALICANTO.get().getSpawnAABB(x, y, z))) {
                EntityRegistry.ALICANTO.get().spawn(serverLevel, pos, EntitySpawnReason.REINFORCEMENT);
            }
        }

        for (Player player : level().getEntitiesOfClass(Player.class, getBoundingBox().inflate(16.0D))) {
            if (!player.isSpectator() && !player.isCreative() && player.isAlive() && random.nextInt(500) == 0) {
                player.addEffect(getRandomNegativeEffect());
            }
        }

        if (level() instanceof ServerLevel serverLevel) {
            for (Boat boat : level().getEntitiesOfClass(Boat.class, getBoundingBox().inflate(4.0D))) {
                boat.hurtServer(serverLevel, damageSources().generic(), 100.0F);
            }
        }

        if (isAlive()) {
            AABB box = getBoundingBox().inflate(1.5D);
            BlockPos.betweenClosedStream(
                    BlockPos.containing(box.minX, box.minY, box.minZ),
                    BlockPos.containing(box.maxX, box.maxY, box.maxZ)
            ).forEach((blockPos) -> {
                BlockState state = level().getBlockState(blockPos);
                if (state.is(BlockTags.ICE)) {
                    if (blockPos.getY() == level().getSeaLevel()) {
                        level().setBlockAndUpdate(blockPos, Blocks.WATER.defaultBlockState());
                    } else {
                        level().destroyBlock(blockPos, false);
                    }
                    playSound(SoundEvents.GLASS_BREAK, 1.0F, 1.0F);
                }
            });
        }
    }

    private MobEffectInstance getRandomNegativeEffect() {
        // TODO: blindness and slow digging has some sync issue when drinking milk
        List<Holder<MobEffect>> negativeEffects = Arrays.asList(
                MobEffects.BLINDNESS,
                MobEffects.HUNGER,
                MobEffects.POISON,
                MobEffects.WITHER,
                MobEffects.BAD_OMEN,
                MobEffects.NAUSEA,
                MobEffects.MINING_FATIGUE,
                MobEffects.WEAKNESS,
                MobEffects.UNLUCK
        );
        Holder<MobEffect> negativeEffect = negativeEffects.get(random.nextInt(negativeEffects.size()));
        int duration = 20 * (random.nextInt(60) + 30);
        int amplifier = random.nextInt(2);
        return new MobEffectInstance(negativeEffect, duration, amplifier);
    }

    @Override
    public boolean isInvulnerableTo(ServerLevel level, DamageSource source) {
        return super.isInvulnerableTo(level, source) || !(source.is(DamageTypes.MAGIC)
                || source.is(DamageRegistry.ARCANA)
                || source.is(DamageTypes.FELL_OUT_OF_WORLD)
                || source.is(DamageTypes.EXPLOSION)
                || source.is(DamageTypes.LIGHTNING_BOLT)
                || source.is(DamageTypes.DRAGON_BREATH)
                || source.is(DamageTypes.INDIRECT_MAGIC)
                || source.is(DamageTypes.WITHER)
                || source.is(DamageTypes.GENERIC_KILL));
    }

    @Override
    public boolean canBeHitByProjectile() {
        return true;
    }
}