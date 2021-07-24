package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityLorgaflight extends EntityVetheaMob {
	
    private BlockPos currentFlightTarget;
    private int flyTimer, spawnTick;
    public boolean canSpawnMinions;

    public EntityLorgaflight(EntityType<? extends MobEntity> type, World worldIn) {
    	this(type, worldIn, true);
    }
    
    public EntityLorgaflight(EntityType<? extends MobEntity> type, World worldIn, boolean canSpawnMinions) {
    	super(type, worldIn);
        this.canSpawnMinions = canSpawnMinions;
        this.flyTimer = 0;
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.lorgaFlightHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.lorgaFlightDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.lorgaFlightSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.lorgaFlightFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }
    
    @Override
    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    @Override
    public void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }
    
    @Override
    protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
    	return 0;
    }

    @Override
    public void tick() {
        super.tick();
        this.setDeltaMovement(getDeltaMovement().x, 0.6000000238418579D, getDeltaMovement().y);

        if (this.spawnTick == 0 && this.canSpawnMinions && !this.level.isClientSide) {
            this.spawnTick = 200;
            EntityLorgaflight var2 = new EntityLorgaflight(EntityRegistry.LORGA_FLIGHT, this.level, false);
            var2.moveTo(this.getX() + 1, this.getY(), this.getZ() + 1, this.xRot, this.yRot);
            this.level.addFreshEntity(var2);
        }
        else if (this.spawnTick > 0) {
            this.spawnTick--;
        }
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        if (this.getTarget() != null) {
            int var1 = (int) this.getTarget().getX();
            int var2 = (int) this.getTarget().getY();
            int var3 = (int) this.getTarget().getZ();
            this.currentFlightTarget = new BlockPos(var1, var2, var3);
        }
        else if (this.flyTimer != 0) {
            this.flyTimer = 120;
            this.currentFlightTarget = new BlockPos((int)(this.getX() + this.random.nextInt(16)) - 8, (int)(this.getY() + this.random.nextInt(32)) - 16, (int)(this.getZ() + this.random.nextInt(16)) - 8);
        }

        if (this.currentFlightTarget != null) {
            double var1 = this.currentFlightTarget.getX() - this.getX();
            double var3 = this.currentFlightTarget.getY() - this.getY();
            double var5 = this.currentFlightTarget.getZ() - this.getZ();

            if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                this.setDeltaMovement((Math.signum(var1) * 0.15D - this.getDeltaMovement().x) * 0.10000000149011612D, (Math.signum(var3) * 1.699999988079071D - this.getDeltaMovement().y) * 0.10000000149011612D, (Math.signum(var5) * 0.15D - this.getDeltaMovement().z) * 0.10000000149011612D);
                float var7 = (float)(Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().z) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapDegrees(var7 - this.xRot);
                this.walkDist = 0.5F;
                this.xRot += var8;
            }
            flyTimer--;
        }
        addAttackingAI();
    }
    
    @Override
    public void addAdditionalSaveData(CompoundNBT tag) {
    	super.addAdditionalSaveData(tag);
    	tag.putBoolean("CanSpawnMinions", this.canSpawnMinions);
    }
    
    @Override
    public void readAdditionalSaveData(CompoundNBT tag) {
    	super.readAdditionalSaveData(tag);
    	this.canSpawnMinions = tag.getBoolean("CanSpawnMinions");
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LORGAFLIGHT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LORGAFLIGHT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LORGAFLIGHT_HURT;
    }

}