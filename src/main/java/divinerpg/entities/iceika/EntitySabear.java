package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;

public class EntitySabear extends EntityDivineMonster {

    public EntitySabear(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
    	targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityMamoth.class, 10, true, true, (entity) -> entity.isBaby()));
    }
    @Override
    public boolean isAggressive() {
        return true;
    }
    @Override
    public int getMaxSpawnClusterSize() {
    	return 2;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 1;
    }
    @Override
    public void tick() {
        super.tick();

        if (this.isAlive()) {
            boolean playerNearby = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(8.0D)).size() > 0;
            if (playerNearby) {
                Player nearestPlayer = this.level().getNearestPlayer(this, 8.0D);
                if (nearestPlayer != null && !nearestPlayer.isCreative() && !nearestPlayer.isSpectator()) {
                    Vec3 playerPos = new Vec3(nearestPlayer.getX(), nearestPlayer.getY(), nearestPlayer.getZ());
                    Vec3 sabearPos = new Vec3(this.getX(), this.getY(), this.getZ());
                    AABB box = new AABB(playerPos, sabearPos).inflate(1.0D);

                    BlockPos.betweenClosedStream(
                            new BlockPos((int) box.minX, (int) box.minY, (int) box.minZ),
                            new BlockPos((int) box.maxX, (int) box.maxY, (int) box.maxZ)
                    ).forEach((blockPos) -> {
                        if (blockPos.getY() < this.blockPosition().getY()) {
                            return;
                        }
                        BlockState state = this.level().getBlockState(blockPos);
                        if (state.getBlock() != Blocks.AIR && state.getBlock().defaultDestroyTime() < 1.0F) {
                            if (blockPos.equals(this.blockPosition().below())) {
                                return;
                            }
                            this.level().destroyBlock(blockPos, true);
                            this.playSound(SoundEvents.SNOW_BREAK, 1.0F, 1.0F);
                        } else if (state.is(BlockTags.ICE)) {
                            if (blockPos.getY() == this.level().getSeaLevel()) {
                                this.level().setBlockAndUpdate(blockPos, Blocks.WATER.defaultBlockState());
                            } else {
                                if (state.getBlock() != Blocks.AIR && blockPos.getY() > blockPosition().below().getY()) {
                                    this.level().destroyBlock(blockPos, true);
                                }
                            }
                            this.playSound(SoundEvents.GLASS_BREAK, 1.0F, 1.0F);
                        }
                    });
                }
            }
        }
    }
    @Override
    protected SoundEvent getAmbientSound() {
    	return SoundEvents.POLAR_BEAR_AMBIENT;
    }
    @Override
    protected SoundEvent getDeathSound() {
    	return SoundEvents.POLAR_BEAR_DEATH;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
    	return SoundEvents.POLAR_BEAR_HURT;
    }
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
    	playSound(SoundEvents.POLAR_BEAR_STEP, .15F, 1F);
	}
}