package divinerpg.entities.boss;

import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.entities.vanilla.overworld.EntityWhale;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.*;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;

import java.util.*;

public class EntityEtherealcetus extends EntityWhale {
    private ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.WHITE,
        BossEvent.BossBarOverlay.PROGRESS));

    public EntityEtherealcetus(EntityType<? extends EntityWhale> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public BossEvent.BossBarColor getBarColor() {
        return BossEvent.BossBarColor.WHITE;
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

        //Spawn fish around it randomly
        if (this.level.random.nextInt(200) == 0) {
            double x = this.getX() + (this.level.random.nextDouble() - 0.5) * 8;
            double y = this.getY();
            double z = this.getZ() + (this.level.random.nextDouble() - 0.5) * 8;
            BlockPos pos = new BlockPos((int) x, (int) y, (int) z);
            if (this.level.getBlockState(pos).getFluidState().is(FluidTags.WATER)) {
                List<EntityType<?>> fishEntities = Arrays.asList(EntityType.COD, EntityType.SALMON, EntityType.TROPICAL_FISH, EntityType.PUFFERFISH, EntityRegistry.SHARK.get(), EntityRegistry.AEQUOREA.get(), EntityType.GLOW_SQUID, EntityType.TURTLE, EntityType.TADPOLE);
                EntityType<?> randomFishEntity = fishEntities.get(this.level.random.nextInt(fishEntities.size()));
                Mob fish = (Mob) randomFishEntity.create(this.level);
                fish.setPos(x, y, z);
                fish.setDeltaMovement(this.level.random.nextGaussian() * 0.1, this.level.random.nextGaussian() * 0.1, this.level.random.nextGaussian() * 0.1);
                if (this.level.noCollision(fish, fish.getBoundingBox().deflate(0.0625))) {
                    this.level.addFreshEntity(fish);
                }
            }
        }

        //Randomly add negative effects to nearby players
        List<Player> players = this.level.getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(16.0D));
        for (Player player : players) {
            if (!player.isSpectator() && !player.isCreative() && player.isAlive() && random.nextInt(500) == 3) {
                player.addEffect(getRandomNegativeEffect());
            }
        }

        //Break boats if the whale is nearby
        List<Boat> boats = this.level.getEntitiesOfClass(Boat.class, this.getBoundingBox().inflate(4.0D));
        for (Boat boat : boats) {
            if (boat.distanceTo(this) <= 4.0D) {
                boat.hurt(damageSources().generic(), 100.0F);
            }
        }



        // Spawn projectile out of its blowhole projectile once reaching 32 blocks traveled up will split and shoot bone fragments everywhere
        Player closestPlayer = this.level.getNearestPlayer(this, 16.0D);
        if (closestPlayer != null && this.random.nextInt(200) == 0) {
            double x = this.getX() + (this.random.nextFloat() - 0.5F) * this.getBbWidth();
            double y = this.getY() + this.random.nextFloat() * this.getBbHeight();
            double z = this.getZ() + (this.random.nextFloat() - 0.5F) * this.getBbWidth();
            if (closestPlayer.distanceToSqr(x, y, z) <= 256.0D) { // Only shoot bone projectile if player is within 16 blocks
                double motionX = 0.0D;
                double motionY = 1.75D; // set the arrow upward velocity
                double motionZ = 0.0D;
                this.hurt(damageSources().outOfWorld(), 16);
                EntityShooterBullet e = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level, BulletType.BONE_BOMB) {
                    @Override
                    public void onHitEntity(EntityHitResult result) {
                        super.onHitEntity(result);
                        if (result.getEntity() instanceof EntityEtherealcetus) {
                            ((EntityEtherealcetus) result.getEntity()).heal(16);
                        }
                    }

                    @Override
                    public void tick() {
                        super.tick();
                        // Ignore water friction
                        if (this.isInWater()) {
                            this.noPhysics = true;
                        } else {
                            this.noPhysics = false;
                        }
                        double radius = this.getBbWidth() * 1.5;
                        AABB aabb = new AABB(this.getX() - radius, this.getY() - radius, this.getZ() - radius,
                                this.getX() + radius, this.getY() + radius, this.getZ() + radius);

                        BlockPos.betweenClosedStream(aabb)
                                .forEach(blockPos -> {
                                    BlockState blockState = this.level.getBlockState(blockPos);
                                    if (blockState.is(BlockTags.ICE)) {
                                        this.level.destroyBlock(blockPos, true);
                                    }
                                });

                        if (tickCount == 39 && getOwner() != null) {
                            if (getOwner() instanceof LivingEntity) {
                                for (int i = 0; i < 64; i++) {
                                    double motionX = (this.random.nextDouble() - 0.5) * 2.0;
                                    double motionY = (this.random.nextDouble() - 0.5) * 2.0;
                                    double motionZ = (this.random.nextDouble() - 0.5) * 2.0;
                                    EntityShooterBullet e = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), (LivingEntity) getOwner(), level, BulletType.BONE_FRAGMENT) {
                                        @Override
                                        public void onHitEntity(EntityHitResult result) {
                                            super.onHitEntity(result);
                                            if (result.getEntity() instanceof EntityEtherealcetus) {
                                                ((EntityEtherealcetus) result.getEntity()).heal(6);
                                            }
                                        }

                                        @Override
                                        public void tick() {
                                            super.tick();
                                            // Ignore water friction
                                            if (this.isInWater()) {
                                                this.noPhysics = true;
                                            } else {
                                                this.noPhysics = false;
                                            }
                                        }
                                    };
                                    e.setOwner(this.getOwner());
                                    e.setPos(getOwner().getX(), getOwner().getY(), getOwner().getZ());
                                    e.shoot(motionX, motionY, motionZ, 1.0F, 0.0F);
                                    this.level.addFreshEntity(e);
                                }
                                this.kill();
                            }
                        }
                    }
                };
                e.setOwner(this);
                e.shoot(motionX, motionY, motionZ, 1.6F, 0);
                e.setPos(x, y, z);
                level.addFreshEntity(e);
            }

            // Calculate vector between whale and player
            double dx = closestPlayer.getX() - this.getX();
            double dy = closestPlayer.getY() - this.getY();
            double dz = closestPlayer.getZ() - this.getZ();

            // Normalize vector
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
            dx /= distance;
            dy /= distance;
            dz /= distance;

            // Move the whale along the vector by its regular swim speed
            double speed = this.getAttribute(Attributes.MOVEMENT_SPEED).getValue();
            double motionX = dx * speed;
            double motionY = dy * speed;
            double motionZ = dz * speed;

            // Apply motion to the whale
            this.setDeltaMovement(motionX, motionY, motionZ);
        }

        //Break ice
        if (this.isAlive() && this.isInWater()) {
            AABB box = this.getBoundingBox().inflate(1.0D);
            BlockPos.betweenClosedStream(
                    new BlockPos((int) box.minX, (int) box.minY, (int) box.minZ),
                    new BlockPos((int) box.maxX, (int) box.maxY, (int) box.maxZ)
            ).forEach((blockPos) -> {
                BlockState state = this.level.getBlockState(blockPos);

                if (state.is(BlockTags.ICE)) {
                    if (blockPos.getY() == this.level.getSeaLevel()) { // Check if the block is at sea level
                        this.level.setBlockAndUpdate(blockPos, Blocks.WATER.defaultBlockState()); // Replace ice with water
                    } else {
                        this.level.destroyBlock(blockPos, false); // Break ice block
                    }
                    this.playSound(SoundEvents.GLASS_BREAK, 1.0F, 1.0F);
                }
            });
        }

    }
    private MobEffectInstance getRandomNegativeEffect() {
        List<MobEffect> negativeEffects = Arrays.asList(MobEffects.BLINDNESS, MobEffects.HUNGER, MobEffects.POISON, MobEffects.WITHER, MobEffects.BAD_OMEN, MobEffects.CONFUSION, MobEffects.DIG_SLOWDOWN, MobEffects.WEAKNESS, MobEffects.UNLUCK);
        MobEffect negativeEffect = negativeEffects.get(this.random.nextInt(negativeEffects.size()));
        int duration = 20 * (this.random.nextInt(60) + 30); // 30-90 seconds
        int amplifier = this.random.nextInt(2); // Level 0-1
        return new MobEffectInstance(negativeEffect, duration, amplifier);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        //Can only be damaged via magic or arcana
        if (source.is(DamageTypes.MAGIC) || source == DamageSources.source(level, DamageSources.ARCANA) || source.is(DamageTypes.OUT_OF_WORLD) || source.is(DamageTypes.EXPLOSION) || source.is(DamageTypes.LIGHTNING_BOLT) || source.is(DamageTypes.DRAGON_BREATH) || source.is(DamageTypes.INDIRECT_MAGIC) || source.is(DamageTypes.WITHER)) {
            return super.hurt(source, amount);
        } else {
            return false;
        }
    }
}
