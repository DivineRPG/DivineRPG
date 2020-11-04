package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.Random;

public class EntityWildfire extends EntityDivineMob implements IRangedAttackMob {

    public EntityWildfire(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.wildFireHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.wildFireDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.wildFireSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.wildFireFollowRange);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    @Override
    protected void registerGoals() {
        addAttackingAI();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 1, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        //TODO - Wildfire arrow
        ArrowEntity arrow = new ArrowEntity(world, this);
        arrow.setFire(100);
        double d0 = target.getPosX() - this.getPosX();
        double d1 = target.getBoundingBox().minY + target.getHeight() / 3.0F - this.getPosY();
        double d2 = target.getPosZ() - this.getPosZ();
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        arrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 12.0F);
        this.world.addEntity(arrow);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.WILDFIRE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WILDFIRE_HURT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.WILDFIRE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_WILDFIRE;
    }

}
