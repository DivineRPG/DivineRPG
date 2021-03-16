package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityWhale extends EntityDivineWaterMob {

    public EntityWhale(EntityType<? extends EntityWhale> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.4F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.whaleHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.whaleDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.whaleSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.whaleFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.WHALE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.WHALE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WHALE_HURT;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_WHALE;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isInWater()) {
            if (random.nextInt(2) == 0) {

                for (float x = -0.25F; x <= 0.25F; x += 0.125F) {
                    for (float z = -0.25F; z <= 0.25F; z += 0.125F) {
                        level.addParticle(ParticleTypes.DRIPPING_WATER, getX() + x, getY(), getZ() + z, 0, 0.4, 0);
                    }
                }


            }
        }
    }
}