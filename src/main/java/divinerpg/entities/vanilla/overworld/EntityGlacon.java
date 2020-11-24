package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityGlacon extends EntityDivineMob {

    public EntityGlacon(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.glaconHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.glaconDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.glaconSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.glaconFollowRange);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.3F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GLACIDE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GLACIDE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GLACIDE_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_GLACON;
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && super.canSpawn(worldIn, spawnReasonIn);
    }
}
