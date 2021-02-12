package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityTermid extends EntityDivineMob {


    public EntityTermid(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.1F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.termidHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.termidDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.termidSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.termidFollowRange);
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
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.UNDEFINED;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_WOOD_BREAK;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_TERMID;
    }

    @Override
    protected int calculateFallDamage(float distance, float damageMultiplier) {
        return 0;
    }
}
