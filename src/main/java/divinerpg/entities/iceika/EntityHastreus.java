package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import java.util.List;

public class EntityHastreus extends EntityDivineMob {


    public EntityHastreus(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.3F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.hastreusHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.hastreusDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.hastreusSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.hastreusFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }


    @Override
    public void livingTick() {
        List<Entity> e = this.world.getEntitiesWithinAABBExcludingEntity(this,
                this.getBoundingBox().expand(5, 5, 5));

        for (Entity entity : e) {
            if (entity instanceof PlayerEntity && this.canEntityBeSeen(entity)) {
                PlayerEntity player = (PlayerEntity)entity;

                if(!player.isCreative() && !player.isSpectator()) {
                    player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 12, 18, true, false));
                }
            }
        }

        super.livingTick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HASTREUS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HASTREUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HASTREUS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_HASTREUS;
    }
}
