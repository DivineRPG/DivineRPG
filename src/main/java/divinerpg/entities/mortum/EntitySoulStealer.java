package divinerpg.entities.mortum;

import divinerpg.entities.base.*;
import divinerpg.registries.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntitySoulStealer extends EntityDivineMonster {

    public EntitySoulStealer(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.75F;
    }
    @Override public boolean fireImmune() {return true;}
    @Override public boolean isAggressive() {return true;}
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 12 * 20, 0, false, false));
                ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 12 * 20, 0, false, false));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT.get();
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }

}