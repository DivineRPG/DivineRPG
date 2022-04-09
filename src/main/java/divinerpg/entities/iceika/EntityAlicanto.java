package divinerpg.entities.iceika;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityAlicanto extends EntityDivineFlyingMob {
    public EntityAlicanto(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.fallDistance = 0;
        this.setPathfindingMalus(PathNodeType.WATER, -1.0F);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.3F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.alicantoHealth).add(Attributes.FLYING_SPEED, EntityStats.alicantoSpeed).add(Attributes.ATTACK_DAMAGE, EntityStats.alicantoDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.alicantoSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.alicantoFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.getBiome(blockPosition()).shouldSnow(worldIn, blockPosition());
    }

    @Override
    protected float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextInt(4) != 0 ? null : SoundRegistry.ALICANTO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ALICANTO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ALICANTO_HURT;
    }

}
