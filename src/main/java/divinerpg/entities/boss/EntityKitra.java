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
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.HitResult.Type;

import java.util.*;

public class EntityKitra extends EntityWhale implements RangedAttackMob {
    private ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS));
    public EntityKitra(EntityType<? extends EntityWhale> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, 0.27F, 100, 32));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
//    @Override
//    protected PathNavigation createNavigation(Level level) {
//    	return new KitraNavigation(this, level);
//    }
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
        bossInfo.addPlayer(player);
    }
    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        bossInfo.removePlayer(player);
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float f) {
    	if(isAlive() && getTarget() != null && !level().isClientSide) {
    		EntityShooterBullet e = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.BONE_BOMB) {
    			@Override
                public void onHitEntity(EntityHitResult result) {
    				if(!(result.getEntity() instanceof EntityKitra)) super.onHitEntity(result);
                }
    			@Override
    			public void onHit(HitResult result) {
    				super.onHit(result);
    				if(result.getType() != Type.MISS) {
    					for(int i = 0; i < 64; i++) {
                            double motionX = (random.nextDouble() - .5) * 2D, motionY = (random.nextDouble() - .5) * 2D, motionZ = (random.nextDouble() - .5) * 2D;
                            EntityShooterBullet e = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), (LivingEntity) getOwner(), level(), BulletType.BONE_FRAGMENT) {
                                @Override
                                public void onHitEntity(EntityHitResult result) {
                                    if(!(result.getEntity() instanceof EntityKitra)) super.onHitEntity(result);
                                }
                                @Override
                                public void tick() {
                                    super.tick();
                                    if(isInWater()) noPhysics = true;
                                    else noPhysics = false;
                                }
                            };
                            e.setOwner(getOwner());
                            e.setPos(result.getLocation());
                            e.shoot(motionX, motionY, motionZ, 1F, 0F);
                            level().addFreshEntity(e);
                        } kill();
    				}
    			}
    			@Override
                public void tick() {
                    super.tick();
                    if(isInWater()) noPhysics = true;
                    else noPhysics = false;
                    double radius = getBbWidth() * 1.5;
                    AABB aabb = new AABB(getX() - radius, getY() - radius, getZ() - radius, getX() + radius, getY() + radius, getZ() + radius);
                    BlockPos.betweenClosedStream(aabb).forEach(blockPos -> {
                        BlockState blockState = level().getBlockState(blockPos);
                        if(blockState.is(BlockTags.ICE)) level().destroyBlock(blockPos, true);
                    });
                }
    		};
    		// Calculate vector between whale and target
            double dx = getTarget().getX() - getX(), dy = getTarget().getY() - getY(), dz = getTarget().getZ() - getZ();
            e.setOwner(this);
            e.shoot(dx, dy, dz, 1.5F, 0.8F);
            e.setPos(position().x, position().y + 1.5D, position().z);
            level().addFreshEntity(e);
            actuallyHurt(damageSources().magic(), 10F);
            // Normalize vector
            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
            dx /= distance;
            dy /= distance;
            dz /= distance;
            // Move the whale along the vector by its regular swim speed
            double speed = getAttribute(Attributes.MOVEMENT_SPEED).getValue();
            double motionX = dx * speed, motionY = dy * speed, motionZ = dz * speed;
            // Apply motion to the whale
            setDeltaMovement(getDeltaMovement().x + motionX, getDeltaMovement().y + motionY, getDeltaMovement().z + motionZ);
    	}
    }
    @Override
    public void tick() {
        super.tick();
        bossInfo.setProgress(getHealth() / getMaxHealth());
        //Spawn fish around it randomly
        if(!level().isClientSide() && random.nextInt(500) == 0) {
            double x = getX() + (random.nextDouble() - .5) * 8D, y = getY(), z = getZ() + (random.nextDouble() - .5) * 8D;
            BlockPos pos = new BlockPos((int) x, (int) y, (int) z);
            BlockState state = level().getBlockState(pos);
            if(state.getFluidState().is(FluidTags.WATER)) {
                List<EntityType<?>> fishEntities = Arrays.asList(EntityType.PUFFERFISH, EntityRegistry.SHARK.get(), EntityRegistry.AEQUOREA.get(), EntityType.GLOW_SQUID);
                EntityType<?> randomFishEntity = fishEntities.get(level().getRandom().nextInt(fishEntities.size()));
                if(level().noCollision(randomFishEntity.getAABB(x, y, z).deflate(0.0625))) randomFishEntity.spawn((ServerLevel) level(), pos, MobSpawnType.REINFORCEMENT);
            } else if(state.isAir() && level().noCollision(EntityRegistry.ALICANTO.get().getAABB(x, y, z))) EntityRegistry.ALICANTO.get().spawn((ServerLevel) level(), pos, MobSpawnType.REINFORCEMENT);
        }
        //Randomly add negative effects to nearby players
        for(Player player : level().getEntitiesOfClass(Player.class, getBoundingBox().inflate(16D))) if(!player.isSpectator() && !player.isCreative() && player.isAlive() && random.nextInt(500) == 0)
            player.addEffect(getRandomNegativeEffect());
        //Break boats if the whale is nearby
        for(Boat boat : level().getEntitiesOfClass(Boat.class, getBoundingBox().inflate(4D))) boat.hurt(damageSources().generic(), 100F);
        //Break ice
        if(isAlive()) {
            AABB box = getBoundingBox().inflate(1.5);
            BlockPos.betweenClosedStream(
                    new BlockPos((int) box.minX, (int) box.minY, (int) box.minZ),
                    new BlockPos((int) box.maxX, (int) box.maxY, (int) box.maxZ)
            ).forEach((blockPos) -> {
                BlockState state = level().getBlockState(blockPos);
                if(state.is(BlockTags.ICE)) {
                    if(blockPos.getY() == level().getSeaLevel()) level().setBlockAndUpdate(blockPos, Blocks.WATER.defaultBlockState()); // Replace ice with water
                    else level().destroyBlock(blockPos, false); // Break ice block
                    playSound(SoundEvents.GLASS_BREAK, 1F, 1F);
                }
            });
        }
    }
    private MobEffectInstance getRandomNegativeEffect() {
        List<MobEffect> negativeEffects = Arrays.asList(MobEffects.BLINDNESS, MobEffects.HUNGER, MobEffects.POISON, MobEffects.WITHER, MobEffects.BAD_OMEN, MobEffects.CONFUSION, MobEffects.DIG_SLOWDOWN, MobEffects.WEAKNESS, MobEffects.UNLUCK);
        MobEffect negativeEffect = negativeEffects.get(random.nextInt(negativeEffects.size()));
        int duration = 20 * (random.nextInt(60) + 30); // 30-90 seconds
        int amplifier = random.nextInt(2); // Level 0-1
        return new MobEffectInstance(negativeEffect, duration, amplifier);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        //Can only be damaged via magic or arcana
        if (source.is(DamageTypes.MAGIC) || source == DamageSources.source(level(), DamageSources.ARCANA) || source.is(DamageTypes.FELL_OUT_OF_WORLD) || source.is(DamageTypes.EXPLOSION) || source.is(DamageTypes.LIGHTNING_BOLT) || source.is(DamageTypes.DRAGON_BREATH) || source.is(DamageTypes.INDIRECT_MAGIC) || source.is(DamageTypes.WITHER)) {
            return super.hurt(source, amount);
        } else return false;
    }
    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }
//    public static class KitraNavigation extends WaterBoundPathNavigation {
//    	public KitraNavigation(Mob mob, Level level) {
//    		super(mob, level);
//    	}
//    	@Override
//    	protected PathFinder createPathFinder(int p_26598_) {
//    		nodeEvaluator = new SwimNodeEvaluator(true);
//    		return new PathFinder(nodeEvaluator, p_26598_);
//    	}
//    }
//    public static class KitraNodeEvaluator extends SwimNodeEvaluator {
//		public KitraNodeEvaluator() {
//			super(true);
//		}
//    	@Override
//    	protected Node findAcceptedNode(int p_263032_, int p_263066_, int p_263105_) {
//    		Node node = null;
//    		BlockPathTypes blockpathtypes = getCachedBlockType(p_263032_, p_263066_, p_263105_);
//    		if(blockpathtypes == BlockPathTypes.BREACH || blockpathtypes == BlockPathTypes.WATER || blockpathtypes == BlockPathTypes.OPEN) {
//    			float f = mob.getPathfindingMalus(blockpathtypes);
//    			if(f >= 0F) {
//    				node = getNode(p_263032_, p_263066_, p_263105_);
//    	            node.type = blockpathtypes;
//    	            node.costMalus = Math.max(node.costMalus, f);
//	            }
//			} return node;
//    	}
//    	@Override
//    	public BlockPathTypes getBlockPathType(BlockGetter p_77472_, int x, int y, int z, Mob p_77476_) {
//    		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//    		for(int i = x; i < x + entityWidth; ++i) for(int j = y; j < y + entityHeight; ++j) for(int k = z; k < z + entityDepth; ++k) {
//    			FluidState fluidstate = p_77472_.getFluidState(blockpos$mutableblockpos.set(i, j, k));
//    			BlockState blockstate = p_77472_.getBlockState(blockpos$mutableblockpos.set(i, j, k));
//    			if(fluidstate.isEmpty() && blockstate.isAir()) return BlockPathTypes.BREACH;
//    			if(!fluidstate.is(FluidTags.WATER)) return BlockPathTypes.BLOCKED;
//			} BlockState state = p_77472_.getBlockState(blockpos$mutableblockpos);
//    		return state.isPathfindable(p_77472_, blockpos$mutableblockpos, PathComputationType.WATER) ? BlockPathTypes.WATER
//    				: (state.isPathfindable(p_77472_, blockpos$mutableblockpos, PathComputationType.LAND) ? BlockPathTypes.OPEN : BlockPathTypes.BLOCKED);
//    	}
//    }
}