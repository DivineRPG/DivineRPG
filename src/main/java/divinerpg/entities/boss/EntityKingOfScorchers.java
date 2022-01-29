package divinerpg.entities.boss;

import divinerpg.entities.ai.*;
import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityKingOfScorchers extends EntityDivineBoss implements ILaunchThrowable {
    public EntityKingOfScorchers(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.kingOfScorchersHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.kingOfScorchersDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.kingOfScorchersSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.kingOfScorchersFollowRange);
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

        // regular shoots
        this.goalSelector.addGoal(7, new AIDivineFireballAttack(
                this,
                this::createFireball,
                15,
                64,
                null,
                SoundEvents.BLAZE_SHOOT));
//
        this.goalSelector.addGoal(8, new AIDivineFireballAttack(
                this,
                this::createMeteors,
                20 * 60,
                64,
                null,
                SoundEvents.BLAZE_SHOOT));
    }

        protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
            return 1F;
        }

    public Entity createMeteors(LivingEntity parent, Entity victim) {
        if (!(victim instanceof LivingEntity))
            return null;

        List<Entity> meteors = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            EntityKingOfScorchersMeteor meteor = new EntityKingOfScorchersMeteor(EntityRegistry.KING_OF_SCORCHERS_METEOR, ((LivingEntity) victim), level);

            Random rand = meteor.level.random;

            meteor.xo = rand.nextDouble() - rand.nextDouble() * 2;
            meteor.xo += 10;
            meteor.zo = rand.nextDouble() - rand.nextDouble() * 2;

            meteor.setDeltaMovement((rand.nextDouble() - rand.nextDouble()) / 5, -0.7, (rand.nextDouble() - rand.nextDouble()) / 5);

            meteors.add(meteor);
        }

        while (meteors.size() > 1) {
            level.addFreshEntity(meteors.get(0));
            meteors.remove(0);
        }


        return meteors.get(0);
    }

    @Override
    public ThrowableEntity createThowable(World world, LivingEntity parent, double x, double y, double z) {
        return new EntityKingOfScorchersShot(EntityRegistry.KING_OF_SCORCHERS_SHOT, parent, world);
    }

    @Override
    public float getInaccuracy(World world) {
        return 1;
    }

    public Entity createFireball(LivingEntity parent, Entity victim) {
        if (!(victim instanceof LivingEntity))
            return null;

        List<Entity> meteors = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            EntityKingOfScorchersShot meteor = new EntityKingOfScorchersShot(EntityRegistry.KING_OF_SCORCHERS_SHOT, ((LivingEntity) victim), level);

            Random rand = meteor.level.random;

            meteor.xo = rand.nextDouble() - rand.nextDouble() * 2;
            meteor.xo += 10;
            meteor.zo = rand.nextDouble() - rand.nextDouble() * 2;

            meteor.setDeltaMovement((rand.nextDouble() - rand.nextDouble()) / 5, -0.7, (rand.nextDouble() - rand.nextDouble()) / 5);

            meteors.add(meteor);
        }

        while (meteors.size() > 1) {
            level.addFreshEntity(meteors.get(0));
            meteors.remove(0);
        }


        return meteors.get(0);
    }


    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public boolean hurt(DamageSource source, float par2) {
        if (source.isExplosion())
            return false;
        return super.hurt(source, par2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.KING_OF_SCORCHERS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KING_OF_SCORCHERS_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }
    
}
