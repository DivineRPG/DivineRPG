package divinerpg.entities.vanilla.end;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityEnderTriplets extends EntityDivineFlyingMob {
    public EntityEnderTriplets(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 5;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.enderTripletsHealth).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.enderTripletsSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.enderTripletsFollowRange);
    }
    @Override
    public boolean isImmuneToFire() {
        return true;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.0F;
    }@Override
    protected float getSoundVolume() {
        return 10.0F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_GHAST_SCREAM;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ENDER_TRIPLETS;
    }
    //TODO - Ender triplets fireball attack
//    @Nullable
//    @Override
//    protected AIDivineFireballAttack createShootAI() {
//        return new AIDivineFireballAttack(this,
//                (world1, parent, x, y, z, fireballStrength) -> new EntityEnderTripletsFireball(world, parent, x, y, z));
//    }
}
