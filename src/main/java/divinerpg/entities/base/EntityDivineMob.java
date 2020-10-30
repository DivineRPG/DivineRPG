package divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityDivineMob extends MonsterEntity {
    public EntityDivineMob(EntityType<? extends MobEntity> type, World worldIn) {
        super((EntityType<? extends MonsterEntity>) type, worldIn);
    registerGoals();
    }
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        BlockPos blockpos = pos.down();
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(blockpos).canEntitySpawn(worldIn, blockpos, typeIn);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return true;
    }

    public boolean isNotColliding(IWorldReader worldIn) {
        return !worldIn.containsAnyLiquid(this.getBoundingBox()) && worldIn.checkNoEntityCollision(this);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.27D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue()));
    if(!needsSpecialAI()){
        addBasicAI();
    }
    }
    public boolean needsSpecialAI() {
        return false;
    }
    protected void addBasicAI() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue()));

    }

    protected void addAttackingAI() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }
}
