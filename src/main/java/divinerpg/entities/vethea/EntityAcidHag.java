package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import divinerpg.registries.BlockRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityAcidHag extends EntityVetheaMob {

    public EntityAcidHag(EntityType<? extends MobEntity> type, World world) {
        super(type, world);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.4F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.acidHagHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.acidHagDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.acidHagSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.acidHagFollowRange);
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
    public void tick() {
        super.tick();

        BlockPos current = new BlockPos((int)getX() - 1, (int)getY(), (int)getZ() - 1);
        BlockPos below = new BlockPos((int)getX() - 1, (int)getY() - 1, (int)getZ() - 1);
        BlockState belowState = this.level.getBlockState(below);

        if(this.level.getBlockState(current).getBlock() == Blocks.AIR) {
            if(belowState.isValidSpawn(level, below, EntityRegistry.ACID_HAG) && belowState.canOcclude()) {
                this.level.setBlockAndUpdate(current, BlockRegistry.acidBlock.defaultBlockState());
            }
        }
    }
    
    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ACID_HAG;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ACID_HAG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ACID_HAG_HURT;
    }
}