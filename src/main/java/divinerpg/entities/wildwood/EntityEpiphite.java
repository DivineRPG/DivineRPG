package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityEpiphite extends EntityPeacefulUntilAttacked {
    public EntityEpiphite(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue=40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
    return 1.1F;
}
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.epiphiteHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.epiphiteDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.epiphiteSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.epiphiteFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    public boolean isImmuneToFire() {
        return true;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
        if (this.rand.nextInt(5) == 0)
            bolt.setPosition(entity.getPosX(), entity.getPosY(), entity.getPosZ());
        if(world.isRemote) {
            world.addEntity(bolt);
        }
        return super.attackEntityAsMob(entity);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GROWL;
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
        return LootTableRegistry.ENTITIES_EPIPHITE;
    }
}