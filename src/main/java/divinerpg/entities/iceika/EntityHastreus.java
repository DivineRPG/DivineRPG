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
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityHastreus extends EntityDivineMob {


    public EntityHastreus(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.3F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.hastreusHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.hastreusDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.hastreusSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.hastreusFollowRange);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }


    @Override
    public void tick() {
        List<Entity> e = this.level.getEntities(this,
                this.getBoundingBox().expandTowards(5, 5, 5));

        for (Entity entity : e) {
            if (entity instanceof PlayerEntity && this.canSee(entity)) {
                PlayerEntity player = (PlayerEntity)entity;

                if(!player.isCreative() && !player.isSpectator()) {
                    player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 12, 18, true, false));
                }
            }
        }

        super.tick();
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

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }
}
