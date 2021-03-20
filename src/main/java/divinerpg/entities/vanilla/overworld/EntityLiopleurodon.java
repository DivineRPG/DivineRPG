package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityLiopleurodon extends EntityDivineWaterMob {

    public EntityLiopleurodon(EntityType<? extends EntityLiopleurodon> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.7F;
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.liopleurodonHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.liopleurodonDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.liopleurodonSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.liopleurodonFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LIOPLEURODON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LIOPLEURODON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LIOPLEURODON_HURT;
    }

}