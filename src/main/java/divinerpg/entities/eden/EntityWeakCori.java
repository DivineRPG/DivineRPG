package divinerpg.entities.eden;

import divinerpg.entities.ai.*;
import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityWeakCori extends EntityDivineFlyingMob {

    public EntityWeakCori(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.8F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.edenCoriHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.edenCoriDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.edenCoriSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.edenCoriFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.EDEN_WORLD;
    }

    @Override
    protected AIDivineFireballAttack createShootAI() {
        return new AIDivineFireballAttack(this,
                new ILaunchThrowable() {

                    @Override
                    public float getInaccuracy(World world) {
                        return 0;
                    }

                    @Override
                    public ThrowableEntity createThowable(World world, LivingEntity parent, double x, double y, double z) {
                        return new EntityCoriShot(EntityRegistry.CORI_SHOT, world, parent, (float) parent.getAttributeValue(Attributes.ATTACK_DAMAGE));
                    }
                },
                SoundRegistry.CORI_SHOOT);
    }


    @Override
    public int getMaxSpawnClusterSize() {return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CORI_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CORI_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CORI_HURT;
    }

}
