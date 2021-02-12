package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntitySunArcher extends EntityDivineMob implements IRangedAttackMob {
    public EntitySunArcher(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.0F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.sunArcherHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.sunArcherDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.sunArcherSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.sunArcherFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    addAttackingAI();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 1, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEFINED;
    }


    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float f) {
        //TODO - ranged attack sun archer
//        this.world
//                .spawnEntity(new EntityDivineArrow(this.world, ArrowType.SUN_ARCHER_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SUN_ARCHER;
    }
}