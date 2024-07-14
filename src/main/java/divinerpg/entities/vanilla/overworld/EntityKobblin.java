package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.nbt.*;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

import javax.annotation.*;

public class EntityKobblin extends EntityDivineMonster {
    private static final EntityDataAccessor<Boolean> PROVOKED = SynchedEntityData.defineId(EntityKobblin.class, EntityDataSerializers.BOOLEAN);

    public EntityKobblin(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public static boolean kobblinSpawnRule(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) && worldIn.canSeeSky(pos);
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
    @Override protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PROVOKED, false);
    }

    @Override
    public int getMaxSpawnClusterSize() {return 1;
    }
    
    @Override
    protected void registerGoals() {
    	super.registerGoals();
    	this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
    }

    @Override
    public void setDeltaMovement(double x, double y, double z) {
        if (this.getProvoked())
            super.setDeltaMovement(x, y, z);
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.level().isClientSide()) {
        	Player player = this.level().getNearestPlayer(this, 4.0D);
        	if(player == null) {
        		setProvoked(this.getTarget());
        	} else {
        		if(!getProvoked()) {
        			this.setDeltaMovement(0, 0.6, 0);
        		}
        		setProvoked(player);
        	}
        	if(!getProvoked()) setDeltaMovement(0, -0.3, 0);
        	setNoAi(!entityData.get(PROVOKED));
        }
        if (!this.getProvoked()) {
            this.xRotO = 0;
        }
    }
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.getBoolean("Provoked"))
            setProvoked(null);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Provoked", this.getProvoked());
    }

    public boolean getProvoked() {
        return entityData.get(PROVOKED);
    }

    @Nullable
    public void setProvoked(LivingEntity entity) {
    	if (entity == null || entity.distanceTo(this) > 16.0f) {
			calmDown();
		} else {
			if(entity instanceof Player) {
				Player player = (Player) entity;
				if(player.isCreative() || player.isSpectator()) {
					calmDown();
					return;
				}
			}
			entityData.set(PROVOKED, true);
			this.setTarget(entity);
		}
    }
    public void calmDown() {
		entityData.set(PROVOKED, false);
		this.setTarget(null);
	}
    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getDirectEntity();
        if (entity instanceof Player && !getProvoked()) {
            Player player = (Player) entity;
            this.setProvoked(player);
            this.setDeltaMovement(0, 0.6, 0);
        }
        return super.hurt(source, amount);
    }
    public boolean needsSpecialAI() {
        return true;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KOBBLIN.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.KOBBLIN.get();
    }

}