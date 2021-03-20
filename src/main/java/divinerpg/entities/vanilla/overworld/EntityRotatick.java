package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityRotatick extends EntityDivineMob {

    public EntityRotatick(EntityType<? extends EntityRotatick> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.75F;
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.rotatickHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.rotatickDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.rotatickSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.rotatickFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ROTATICK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ROTATICK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ROTATICK_HURT;
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == World.OVERWORLD && super.canSpawn(worldIn, spawnReasonIn);
    }
}
