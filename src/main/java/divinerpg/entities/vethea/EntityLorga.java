package divinerpg.entities.vethea;

import java.util.List;
import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityLorga extends EntityVetheaMob {
	
    private int spawnTick;
    public boolean canSpawnMinions;
    
    public EntityLorga(EntityType<? extends MobEntity> type, World worldIn) {
    	this(type, worldIn, true);
    }

    public EntityLorga(EntityType<? extends MobEntity> type, World worldIn, boolean canSpawnMinions) {
        super(type, worldIn);
        this.canSpawnMinions = canSpawnMinions;
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.lorgaHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.lorgaDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.lorgaSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.lorgaFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
 
    @Override
    public int getSpawnLayer() {
    	return 1;
    }

    @Override
    public void tick() {
        super.tick();
        List<Entity> nearby = level.getEntities(this, this.getBoundingBox().expandTowards(10D, 10D, 10D));
        if (this.spawnTick == 0 && this.canSpawnMinions && !this.level.isClientSide && nearby.size() < 12) {
            this.spawnTick = 260;
            EntityLorga var2 = new EntityLorga(EntityRegistry.LORGA, this.level, false);
            var2.moveTo(this.getX() + 1, this.getY(), this.getZ() + 1, this.xRot, this.yRot);
            this.level.addFreshEntity(var2);
        }
        else if (this.spawnTick > 0) {
            this.spawnTick--;
        }
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
        return SoundRegistry.LORGA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LORGA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LORGA_HURT;
    }
}