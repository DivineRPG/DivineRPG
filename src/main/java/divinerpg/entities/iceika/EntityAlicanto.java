package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityAlicanto extends EntityDivineFlyingMob {
    public EntityAlicanto(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.fallDistance = 0;
        this.setPathPriority(PathNodeType.WATER, -1.0F);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.3F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.alicantoHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.alicantoDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.alicantoSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.alicantoFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : SoundRegistry.ALICANTO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ALICANTO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ALICANTO_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ALICANTO;
    }

}
