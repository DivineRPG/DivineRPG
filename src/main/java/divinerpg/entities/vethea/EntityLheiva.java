package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityLheiva extends EntityVetheaMob {

    public EntityLheiva(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.2F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.lheivaHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.lheivaDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.lheivaSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.lheivaFollowRange);
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
    public boolean hurt(DamageSource source, float par2) {
        Entity var1 = source.getDirectEntity();
        if (var1 != null && var1 instanceof PlayerEntity) {
            if (((PlayerEntity)var1).inventory.contains(new ItemStack(ItemRegistry.bandOfHeivaHunting)))
                return super.hurt(source, par2);
        } else if(source == DamageSource.OUT_OF_WORLD) return super.hurt(source, par2);
        return false;
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LHEIVA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LHEIVA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LHEIVA_HURT;
    }
}