package divinerpg.entities.boss;

import divinerpg.entities.projectile.bullet.BoneBomb;
import divinerpg.entities.vanilla.overworld.EntityWhale;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.scores.PlayerTeam;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class EntityKitra extends EntityWhale implements RangedAttackMob {
    //TODO: the fog appears/ends abruptly when getting close to or leaving the boss behind
    private final ServerBossEvent bossInfo = (ServerBossEvent) new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS).setCreateWorldFog(true);
    public EntityKitra(EntityType<? extends EntityWhale> type, Level worldIn) {super(type, worldIn);}
    @Override protected int getBaseExperienceReward() {return XP_REWARD_BOSS;}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new RangedAttackGoal(this, .27F, 80, 32));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    @Override public Component getDisplayName() {
        return PlayerTeam.formatNameForTeam(getTeam(), getName()).withStyle((s) -> s.withHoverEvent(createHoverEvent()).withInsertion(getStringUUID()).withBold(true).withColor(0xa4f4f9));
    }
//    @Override protected PathNavigation createNavigation(Level level) {
//    	return new KitraNavigation(this, level);
//    }
    @Override protected boolean shouldDespawnInPeaceful() {return true;}
    @Override public boolean removeWhenFarAway(double distanceToClosestPlayer) {return false;}
    @Override public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossInfo.addPlayer(player);
    }
    @Override public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        bossInfo.removePlayer(player);
    }
    @Override public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        bossInfo.setName(getDisplayName());
    }
    @Override public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(hasCustomName()) bossInfo.setName(getDisplayName());
    }
    @Override public void performRangedAttack(LivingEntity entity, float f) {
        if(isAlive() && getTarget() != null && !level().isClientSide) {
            BoneBomb e = EntityRegistry.BONE_BOMB.get().create(level());
            // Calculate vector between whale and target
            double dx = getTarget().getX() - getX(), dy = getTarget().getY() - getY(), dz = getTarget().getZ() - getZ();
            e.setOwner(this);
            e.shoot(dx, dy, dz, 1.5F, .8F);
            e.setPos(position().x, position().y + 1.5, position().z);
            level().addFreshEntity(e);
            hurt(damageSources().magic(), 10);
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
    @Override protected void customServerAiStep() {bossInfo.setProgress(getHealth() / getMaxHealth());}
    @Override public void tick() {
        super.tick();
        //Spawn fish around it randomly
        if(!level().isClientSide() && random.nextInt(500) == 0) {
            double x = getX() + (random.nextDouble() - .5) * 8, y = getY(), z = getZ() + (random.nextDouble() - .5) * 8;
            BlockPos pos = new BlockPos((int) x, (int) y, (int) z);
            BlockState state = level().getBlockState(pos);
            if(state.getFluidState().is(FluidTags.WATER)) {
                List<EntityType<?>> fishEntities = Arrays.asList(EntityType.PUFFERFISH, EntityRegistry.SHARK.get(), EntityRegistry.AEQUOREA.get(), EntityType.GLOW_SQUID);
                EntityType<?> randomFishEntity = fishEntities.get(level().getRandom().nextInt(fishEntities.size()));
                if(level().noCollision(randomFishEntity.getSpawnAABB(x, y, z).deflate(.0625))) randomFishEntity.spawn((ServerLevel) level(), pos, MobSpawnType.REINFORCEMENT);
            } else if(state.isAir() && level().noCollision(EntityRegistry.ALICANTO.get().getSpawnAABB(x, y, z))) EntityRegistry.ALICANTO.get().spawn((ServerLevel) level(), pos, MobSpawnType.REINFORCEMENT);
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
                    playSound(SoundEvents.GLASS_BREAK, 1, 1);
                }
            });
        }
    }
    private MobEffectInstance getRandomNegativeEffect() {
        //TODO: blindness and slow digging has some sync issue when drinking milk (they don't seem to be cleared, but after reloading the world they are)
        //TODO: also getting blindness for 1 minute is quite evil
        List<Holder<MobEffect>> negativeEffects = Arrays.asList(MobEffects.BLINDNESS, MobEffects.HUNGER, MobEffects.POISON, MobEffects.WITHER, MobEffects.BAD_OMEN, MobEffects.CONFUSION, MobEffects.DIG_SLOWDOWN, MobEffects.WEAKNESS, MobEffects.UNLUCK);
        Holder<MobEffect> negativeEffect = negativeEffects.get(random.nextInt(negativeEffects.size()));
        int duration = 20 * (random.nextInt(60) + 30); // 30-90 seconds
        int amplifier = random.nextInt(2); // Level 0-1
        return new MobEffectInstance(negativeEffect, duration, amplifier);
    }
    @Override public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || !(source.is(DamageTypes.MAGIC)
                || source.is(DamageRegistry.ARCANA.getKey())
                || source.is(DamageTypes.FELL_OUT_OF_WORLD)
                || source.is(DamageTypes.EXPLOSION)
                || source.is(DamageTypes.LIGHTNING_BOLT)
                || source.is(DamageTypes.DRAGON_BREATH)
                || source.is(DamageTypes.INDIRECT_MAGIC)
                || source.is(DamageTypes.WITHER)
                || source.is(DamageTypes.GENERIC_KILL));
    }
    @Override public boolean canBeHitByProjectile() {return true;}
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