package divinerpg.entities.apalachia;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityEnchantedWarrior extends EntityDivineMob {

    public EntityEnchantedWarrior(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.7F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.apalachiaCadillionHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.apalachiaCadillionDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.apalachiaCadillionSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.apalachiaCadillionFollowRange);
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        if (this.level.isDay() && !this.level.isClientSide) {
            float lightLevel = this.getBrightness();
            if (lightLevel > 0.5F
                    && this.level.canSeeSky(new BlockPos(MathHelper.floor(this.getX()), MathHelper.floor(this.getY()),
                            MathHelper.floor(this.getZ())))
                    && this.random.nextFloat() * 30.0F < (lightLevel - 0.4F) * 2.0F) {
                this.setSecondsOnFire(8);
            }
        }
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HISS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT;
    }

}
