package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityGreenfeet extends EntityDivineMob {

    public EntityGreenfeet(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.greenfeetHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.greenfeetDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.greenfeetSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.greenfeetFollowRange);
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
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        if (this.world.isDaytime() && !this.world.isRemote) {
            float lightLevel = this.getBrightness();
            if (lightLevel > 0.5F
                    && this.world.canBlockSeeSky(new BlockPos(MathHelper.floor(this.getPosX()), MathHelper.floor(this.getPosY()),
                    MathHelper.floor(this.getPosZ())))
                    && this.rand.nextFloat() * 30.0F < (lightLevel - 0.4F) * 2.0F) {
                this.setFire(8);
            }
        }
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.NESRO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.NESRO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.NESRO_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_GREENFEET;
    }
}
