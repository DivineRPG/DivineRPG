package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.BossInfo.*;

public class EntityDensos extends EntityDivineBoss {
    public EntityDensos(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2F;
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
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DENSOS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DENSOS_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.densosHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.densosDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.densosSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.densosFollowRange);
    }
}
