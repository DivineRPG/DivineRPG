package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityShark extends EntityDivineWaterMob {

    public EntityShark(EntityType<? extends EntityShark> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.3F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.sharkHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.sharkDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.sharkSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.sharkFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SHARK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SHARK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SHARK_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SHARK;
    }
}