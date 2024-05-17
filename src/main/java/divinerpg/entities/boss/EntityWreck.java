package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.*;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.Nullable;
import java.util.List;

public class EntityWreck extends EntityDivineBoss {

    private final int MELEE = 0, ARCANA = 1, RANGED = 2;
    private final int DEFAULT = 0, CHARGE = 1, PULL = 2, FIRE = 3, BOUNCE = 4, FREEZE = 5, SPEED = 6, EXPLOSIONS = 7, STRENGTH = 8;
//    private int waitTick;
    private int abilityTimer;
    private boolean dead = false;
    private boolean loaded = false;

    private int ability;
    private int abilityType;

    public EntityWreck(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public void manageAbilities() {
        Player player = this.level().getNearestPlayer(this, 64.0D);
        if (getHealth() < 1024 / 3) {
            this.setAbilityType(RANGED);
        } else if (getHealth() < 1024 * 2 / 3 && getHealth() > 1024 / 3) {
            this.setAbilityType(ARCANA);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1);
            this.setSpeed((float) this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
        } else {
            this.setAbilityType(MELEE);
        }

        if (abilityTimer > 0) {
            abilityTimer--;
        }

        if ((this.getAbilityType() == 1 && (this.getAbility() == CHARGE || this.getAbility() == PULL)) || (this.getAbilityType() == 2 && (this.getAbility() == FIRE || this.getAbility() == BOUNCE || this.getAbility() == FREEZE)))
            this.setAbility(DEFAULT);

        if (this.getAbility() == DEFAULT && abilityTimer == 0) {
            abilityTimer = 200;
            switch (this.getAbilityType()) {
                case MELEE:
                    switch (this.random.nextInt(2)) {
                        case 0:
                            this.setAbility(PULL);
                            this.setSpeed(0);
                            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32D);
                            break;
                        case 1:
                            this.setAbility(CHARGE);
                            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5D);
                            break;
                        default:
                            break;
                    }
                    break;
                case ARCANA:
                    switch (this.random.nextInt(3)) {
                        case 0:
                            this.setAbility(FIRE);
                            break;
                        case 1:
                            this.setAbility(BOUNCE);
                            break;
                        case 2:
                            this.setAbility(FREEZE);
                            break;
                        default:
                            break;
                    }
                    break;
                case RANGED:
                    switch (this.random.nextInt(3)) {
                        case 0:
                            this.setAbility(SPEED);
                            break;
                        case 1:
                            this.setAbility(EXPLOSIONS);
                            break;
                        case 2:
                            this.setAbility(STRENGTH);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

            this.message();
        }

        if (this.getAbility() == CHARGE && this.abilityTimer == 0) {
            this.setAbility(DEFAULT);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        }

        if (this.getAbility() == FIRE) {
            if (player != null) {
                for (int i = 1; i < 20; ++i) {
                    int var2 = (int) (((this.blockPosition().getX() - player.blockPosition().getX())) * i) / 5;
                    int var3 = (int) (((this.blockPosition().getZ() - player.blockPosition().getZ())) * i) / 5;
                    if (this.level().getBlockState(new BlockPos((int) this.blockPosition().getX() - var2, (int) this.blockPosition().getY(), (int) this.blockPosition().getZ() - var3)) == Blocks.AIR.defaultBlockState()) this.level().setBlock(new BlockPos((int) this.blockPosition().getX() - var2, (int) this.blockPosition().getY(), (int) this.blockPosition().getZ() - var3), Blocks.FIRE.defaultBlockState(), 0);
                }
                this.setAbility(DEFAULT);
            }
        }
        if (this.getAbility() == FREEZE) {
            if (player != null) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 5));
                this.setAbility(DEFAULT);
                abilityTimer = 100;
            }
        }
        if (!level().isClientSide()) this.performRangedAttack(player);
    }

    private void message() {
        List<Entity> list = level().getEntities(this, this.getBoundingBox().expandTowards(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof Player) {
                Player player = (Player) list.get(var1);

                switch (this.getAbility()) {
                    case CHARGE:
                        player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.charge"), true);
                        break;
                    case PULL:
                        this.playSound(SoundRegistry.FEEL_SOUL_ARKSIANE.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.pull"), true);
                        }
                            break;
                    case FIRE:
                        player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.fire"), true);
                        break;
                    case FREEZE:
                        this.playSound(SoundRegistry.STOP_AT_ONCE.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.freeze"), true);
                        }
                        break;
                    case SPEED:
                        this.playSound(SoundRegistry.WRECK_SPEED.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                        player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.speed"), true);
                    }
                        break;
                    case EXPLOSIONS:
                        this.playSound(SoundRegistry.EXPLOSIONS.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                        player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.explosion"), true);
                    }
                        break;
                    case STRENGTH:
                        this.playSound(SoundRegistry.WRECK_STRENGTH.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                        player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.strength"), true);
                    }
                        break;
                    default:
                        break;
                }
            }
        }

    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.6875F;
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide() && !loaded) {
            List<Player> players = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().expandTowards(30, 30, 30));
            for (Player p : players) {
                p.displayClientMessage(LocalizeUtils.getClientSideTranslation(p, "message.wreck.run"), true);
                p.displayClientMessage(LocalizeUtils.getClientSideTranslation(p, "message.wreck.smell"), true);
            }
            this.playSound(SoundRegistry.WRECK_INTRO.get(), 1.0F, 1.0F);
            loaded = true;
        }

        if (dead) {
            return;
        } else {
            Player player = this.level().getNearestPlayer(this, 64.0D);
            if (this.getAbility() == PULL) {
                if (player != null && !player.isCreative()) {
                    player.setDeltaMovement((this.getX() - player.getX()) * 0.069, (this.getY() - player.getY()) * 0.069, (this.getZ() - player.getZ()) * 0.069);
                }
            }
            manageAbilities();
        }
    }

    @Override
    public boolean doHurtTarget(Entity par1Entity) {
        if (this.getAbilityType() != MELEE) return false;
        float amount = (float) getAttribute(Attributes.ATTACK_DAMAGE).getValue();

        int knockback = 0;

        boolean var4 = par1Entity.hurt(par1Entity.level().damageSources().mobAttack(this), amount);

        if (var4) {
            if (this.getAbility() == PULL) {
                this.setAbility(CHARGE);
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25);
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                knockback = 2;
            }
            if (knockback > 0) {
                par1Entity.setDeltaMovement(-Mth.sin(this.xRot * (float) Math.PI / 180.0F) * knockback * 0.5F, 0.1D, Mth.cos(this.yRot * (float) Math.PI / 180.0F) * knockback * 0.5F);

                setDeltaMovement(getDeltaMovement().x * 0.6D, getDeltaMovement().y, getDeltaMovement().z*0.6D);
            }

            int var5 = EnchantmentHelper.getFireAspect(this);

            if (var5 > 0) {
                par1Entity.setSecondsOnFire(var5 * 4);
            }
        }

        return var4;
    }

    public void performRangedAttack(LivingEntity entity) {
        if (!isAlive() || getTarget() == null || level().isClientSide())  return;
        double x = getTarget().getX() - this.getX();
        double z = getTarget().getZ() - this.getZ();
        switch (this.getAbility()) {
            case BOUNCE:
                    ThrowableProjectile projectile = new EntityBouncingProjectile(EntityRegistry.BOUNCING_PROJECTILE.get(), this, level(), BulletType.WRECK_BOUNCING_SHOT);
                    double bounceY = getTarget().getY(0.3333333333333333D) - projectile.getY();
                    double d3 = Mth.sqrt((float) (x * x + z * z));
                    projectile.shoot(x, bounceY + d3 * (double) 0.2F, z, 1.6F, 0.5F);
                    this.level().addFreshEntity(projectile);
                this.setAbility(DEFAULT);
                break;
            case SPEED:
                if (this.abilityTimer % 5 == 0) {
                    ThrowableProjectile shot = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this,  level(), BulletType.WRECK_SHOT);
                    double shotY = getTarget().getY(0.3333333333333333D) - shot.getY();
                    double ws3 = Mth.sqrt((float) (x * x + z * z));
                    shot.shoot(x, shotY + ws3 * (double) 0.2F, z, 1.6F, 0.5F);
                    this.level().addFreshEntity(shot);
                }
                if (this.abilityTimer <= 100) {
                    this.setAbility(DEFAULT);
                }
                break;
            case EXPLOSIONS:
                if ((this.abilityTimer % 40) == 0) {
                    ThrowableProjectile explosiveShot = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this,  level(), BulletType.WRECK_EXPLOSIVE_SHOT);
                    double explodeY = getTarget().getY(0.3333333333333333D) - explosiveShot.getY();
                    double e3 = Mth.sqrt((float) (x * x + z * z));
                    explosiveShot.shoot(x, explodeY + e3 * (double) 0.2F, z, 1.6F, 0.5F);
                    this.level().addFreshEntity(explosiveShot);
                    explosiveShot.shoot(x, explodeY + e3 * (double) 0.2F, z, 1.6F, 0.5F);
                    this.level().addFreshEntity(explosiveShot);
                }
                if (this.abilityTimer == 0) this.setAbility(DEFAULT);
                break;
            case STRENGTH:
                if ((this.abilityTimer % 40) == 0) {
                    EntityShooterBullet strengthShot = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.WRECK_STRONG_SHOT);
                    double strengthY = getTarget().getY(0.3333333333333333D) - strengthShot.getY();
                    double s3 = Mth.sqrt((float) (x * x + z * z));
                    strengthShot.shoot(x, strengthY + s3 * (double) 0.2F, z, 1.6F, 0.5F);
                }
                if (this.abilityTimer == 0) this.setAbility(DEFAULT);
                break;
            default:
                break;
        }
    }

    public int getAbilityType() {
        return this.abilityType;
    }

    public void setAbilityType(int type) {
        this.abilityType = type;
    }

    public int getAbility() {
        return this.ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }


    protected void registerGoals() {
        this.targetSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.targetSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
        this.goalSelector.addGoal(1, new HurtByTargetGoal(this, Piglin.class));
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 3;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
}
