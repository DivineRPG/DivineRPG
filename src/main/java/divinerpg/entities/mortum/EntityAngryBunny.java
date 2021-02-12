package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.*;

public class EntityAngryBunny extends EntityDivineMob {


    public EntityAngryBunny(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue=40;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.4F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.angryBunnyHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.angryBunnyDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.angryBunnySpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.angryBunnyFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 12);
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ANGRY_BUNNY;
    }
}