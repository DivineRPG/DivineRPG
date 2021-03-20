package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityCaveclops extends EntityDivineMob implements IRangedAttackMob {

    public EntityCaveclops(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.5F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.caveclopsHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.caveclopsDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.caveclopsSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.caveclopsFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return getY() < 20 && level.dimension() == World.OVERWORLD;
    }
    @Override
    protected void registerGoals() {
        addAttackingAI();
        goalSelector.addGoal(0, new RangedAttackGoal(this, 0.27F, 30, 10));

    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYCLOPS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        //TODO - Caveclops attack
//        EntityCaveRock rock = new EntityCaveRock(this.world, this);
//        double d0 = target.posX - this.posX;
//        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - rock.posY;
//        double d2 = target.posZ - this.posZ;
//        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
//        rock.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 12.0F);
//        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
//        this.world.addEntity(rock);
    }
}