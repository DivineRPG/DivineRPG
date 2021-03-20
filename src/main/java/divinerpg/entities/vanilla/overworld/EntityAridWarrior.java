package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityAridWarrior extends EntityDivineMob implements IRangedAttackMob {

    public EntityAridWarrior(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.aridWarriorHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.aridWarriorDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.aridWarriorSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.aridWarriorFollowRange);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.25F;
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == World.OVERWORLD;
    }

    @Override
    protected void registerGoals() {
        addAttackingAI();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 1, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        //TODO - Custom arrow
        this.level.addFreshEntity(new ArrowEntity(level, this));
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ARID_WARRIOR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ARID_WARRIOR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ARID_WARRIOR_HURT;
    }

}
