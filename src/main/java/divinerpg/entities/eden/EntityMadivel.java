package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityMadivel extends EntityDivineMob {

    public EntityMadivel(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.6F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.madivelHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.madivelDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.madivelSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.madivelFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.MADIVEL;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.MADIVEL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.MADIVEL_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_MADIVEL;
    }
}
