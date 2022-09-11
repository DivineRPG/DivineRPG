package divinerpg.entities.vethea;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityTwins extends EntityVetheaMob implements IRangedAttackMob {

    public static final int SLOW = 0, FAST = 1;
    public static int ability;
    private int abilityCoolDown;
    private Goal rangedAI;
    private int rangedAttackCounter;

    public EntityTwins(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
        
        ability = SLOW;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 4.0F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.entHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.entDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.entSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.entFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        rangedAI = new RangedAttackGoal(this, 0.25F, 10, 64.0F);
        this.targetSelector.addGoal(5, rangedAI);
        addAttackingAI();
        this.manageAbilities();
    }
    
    @Override
    public int getSpawnLayer() {
    	return 2;
    }

    public void manageAbilities() {
        if (ability == SLOW && abilityCoolDown == 0) {
            ability = FAST;
            abilityCoolDown = 50;
            this.rangedAttackCounter = 0;
        }
        else if (ability == FAST && abilityCoolDown == 0) {
            ability = SLOW;
            abilityCoolDown = 60;
            this.rangedAttackCounter = 0;
        }
        else if (abilityCoolDown > 0) {
            abilityCoolDown--;
        }
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    public void performRangedAttack(LivingEntity entity, float par2) {
        if (getTarget() != null && this.isAlive()) {
            ArrowEntity entityarrow = new ArrowEntity(EntityType.ARROW, this.level);//this.getArrow(64);
            double d0 = entity.getX() - this.getX();
            double d1 = entity.getBoundingBox().minY + (double) (entity.getBbHeight() / 3.0F) - entityarrow.getY();
            double d2 = entity.getZ() - this.getZ();
            double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
            switch (ability) {
                case FAST:
                    this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
                    entityarrow.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
                    this.level.addFreshEntity(entityarrow);
                    break;
                case SLOW:
                    this.rangedAttackCounter++;
                    if ((this.rangedAttackCounter & 4) == 0) {
                        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
                        entityarrow.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
                        this.level.addFreshEntity(entityarrow);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    /*protected ArrowEntity getArrow(float p_190726_1_)
    {
        TippedArrow entitytippedarrow = new TippedArrow(Schema.getType(), this);
        entitytippedarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
        return entitytippedarrow;
    }*/

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUO_HURT;
    }

}