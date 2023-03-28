package divinerpg.entities.boss;

import divinerpg.entities.vanilla.overworld.EntityWhale;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.*;

public class EntityGhostWhale extends EntityWhale {
    private ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.WHITE,
        BossEvent.BossBarOverlay.PROGRESS));

    public EntityGhostWhale(EntityType<? extends EntityWhale> type, Level worldIn) {
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

        //Spawn projectile out of its blowhole projectile once reaching 32 blocks traveled up will split and shoot bone fragments everywhere
        if (this.random.nextInt(200) == 0) {
            double x = this.getX();
            double y = this.getY() + 2.0D; // set the arrow spawn height
            double z = this.getZ();
            double motionX = 0.0D;
            double motionY = 0.5D; // set the arrow upward velocity
            double motionZ = 0.0D;
//            Arrow arrow = new Arrow(this.level, this);
//            arrow.shoot(motionX, motionY, motionZ, 1.6F, 0.0F); // set the arrow velocity and inaccuracy
//            arrow.setPos(x, y, z);
//            this.level.addFreshEntity(arrow);
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
        if (source.is(DamageTypes.MAGIC) || source == DamageSources.source(level, DamageSources.ARCANA)) {
            return super.hurt(source, amount);
        } else {
            return false;
        }
    }
}
