package divinerpg.entities.skythern;


import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.*;

public class EntityAdvancedCori extends EntityDivineFlyingMob {


    public EntityAdvancedCori(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //TODO - advanced cori shot
//    @Override
//    protected AIDivineFireballAttack createShootAI() {
//        return new AIDivineFireballAttack(this,
//                new ILaunchThrowable() {
//
//                    @Override
//                    public float getInaccuracy(World world) {
//                        return 0;
//                    }
//
//                    @Override
//                    public EntityThrowable createThowable(World world, EntityLivingBase parent, double x, double y, double z) {
//                        return new EntityCoriShot(world, parent, (float) parent.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
//                    }
//                },
//                SoundRegistry.CORI_SHOOT);
//    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.8F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.skythernCoriHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.skythernCoriDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.skythernCoriSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.skythernCoriFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ADVANCED_CORI;
    }
}