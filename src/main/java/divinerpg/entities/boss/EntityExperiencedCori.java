package divinerpg.entities.boss;

import divinerpg.entities.ai.*;
import divinerpg.entities.base.*;
import divinerpg.entities.eden.*;
import divinerpg.entities.projectile.*;
import divinerpg.entities.skythern.*;
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
import net.minecraft.world.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.server.*;

public class EntityExperiencedCori extends EntityDivineFlyingMob {
    private ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE,
            BossInfo.Overlay.PROGRESS));
//    private int deathTicks;

    public EntityExperiencedCori(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward=2000;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.8F;
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
                        return new EntityCoriShot(EntityRegistry.CORI_SHOT, world, parent, (float) parent.getAttribute(Attributes.ATTACK_DAMAGE).getValue());
                    }
                },
                SoundRegistry.CORI_SHOOT);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, false));
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

    @Override
    public boolean removeWhenFarAway(double dist) {
        return false;
    }

    public Color getBarColor() {
        return Color.WHITE;
    }

    @Override
    public void startSeenByPlayer(ServerPlayerEntity player) {
        super.startSeenByPlayer(player);
        bossInfo.setColor(getBarColor());
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayerEntity player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }
    
    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        if (this.isAlive() && this.random.nextInt(1000) < this.ambientSoundTime++)
        {
            this.playAmbientSound();
            if(!this.level.isClientSide) {
                EntityWeakCori weak = new EntityWeakCori(EntityRegistry.WEAK_CORI, level);
                EntityAdvancedCori advanced = new EntityAdvancedCori(EntityRegistry.ADVANCED_CORI, level);
                weak.moveTo(this.getX() + random.nextInt(8), this.getY(), this.getZ() + random.nextInt(8), this.xRot, this.yRot);
                advanced.moveTo(this.getX() + random.nextInt(4), this.getY(), this.getZ() + random.nextInt(4), this.xRot, this.yRot);
                if (random.nextInt(10) == 1) {
                    level.addFreshEntity(weak);
                }
                if (random.nextInt(20) == 1) {
                    level.addFreshEntity(advanced);
                }
            }
        }
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1150).add(Attributes.ATTACK_DAMAGE, 16)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.skythernCoriSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.skythernCoriFollowRange);
    }
}