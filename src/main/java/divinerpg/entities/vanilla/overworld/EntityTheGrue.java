package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityTheGrue extends EntityDivineMob {

    public EntityTheGrue(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.4F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.theGrueHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.theGrueDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.theGrueSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.theGrueFollowRange);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
        goalSelector.addGoal(0, new LeapAtTargetGoal(this, 0.6F));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_THE_GRUE;
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && getPosition().getY() <= 16 && super.canSpawn(worldIn, spawnReasonIn);
    }
}