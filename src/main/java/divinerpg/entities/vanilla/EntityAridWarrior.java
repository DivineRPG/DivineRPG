package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import java.util.Random;

public class EntityAridWarrior extends EntityDivineMob implements IRangedAttackMob {

    public EntityAridWarrior(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.aridWarriorHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.aridWarriorDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.aridWarriorSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.aridWarriorFollowRange);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.25F;
    }
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.NATURAL;
    }
    @Override
    protected void registerGoals() {
        addAttackingAI();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 1, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        //TODO - Custom arrow
        this.world.addEntity(new ArrowEntity(world, this));
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ARID_WARRIOR;
    }

}
