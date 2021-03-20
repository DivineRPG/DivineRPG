package divinerpg.entities.mortum;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityMortumCadillion extends EntityDivineMob {

    public EntityMortumCadillion(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward=40;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.3F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.mortumCadillionHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.mortumCadillionDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.mortumCadillionSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.mortumCadillionFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.MORTUM_WORLD;
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CADILLION;
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