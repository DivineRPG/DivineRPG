package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityDungeonPrisoner extends EntityDivineMob {
    public EntityDungeonPrisoner(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.dungeonPrisonerHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.dungeonPrisonerDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.dungeonPrisonerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.dungeonPrisonerFollowRange);
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
    public boolean doHurtTarget(Entity entity) {
        if(level.isClientSide) {
            EntityDungeonDemon demon = new EntityDungeonDemon(null, level);
            this.playSound(SoundRegistry.DUNGEON_PRISONER_CHANGE, 1, 1);
            demon.moveTo(this.getX(), this.getY(), this.getZ(), this.xRot, 0.0F);
            this.level.addFreshEntity(demon);
        }
        super.doHurtTarget(entity);
        this.kill();
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUNGEON_PRISONER;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUNGEON_PRISONER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUNGEON_PRISONER_HURT;
    }

}