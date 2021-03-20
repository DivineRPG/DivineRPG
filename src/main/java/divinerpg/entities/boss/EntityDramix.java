package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityDramix extends EntityDivineBoss {
    public EntityDramix(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.7F;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.dramixHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.dramixDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.dramixSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.dramixFollowRange);
    }

    @Override
    public void tick() {
        if (this.tickCount % 600 < 300) {
            this.addEffect(new EffectInstance(Effects.INVISIBILITY, 5, 0, true, false));
        }
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DRAMIX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.DRAMIX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DRAMIX_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.BLUE;
    }
}
