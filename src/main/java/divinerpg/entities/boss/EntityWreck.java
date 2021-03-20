package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EntityWreck extends EntityDivineBoss {

    private final int MELEE = 0, ARCANA = 1, RANGED = 2;
    private final int DEFAULT = 0, CHARGE = 1, PULL = 2, FIRE = 3, BOUNCE = 4, FREEZE = 5, SPEED = 6, EXPLOSIONS = 7, STRENGTH = 8;
    private int waitTick;
    private int abilityTimer;
    private boolean dead = false;
    private boolean loaded = false;

    private int ability;
    private int abilityType;

    public EntityWreck(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public void manageAbilities() {
        PlayerEntity player = this.level.getNearestPlayer(this, 64.0D);
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
                    int var2 = (int) (((this.getX() - player.getX())) * i) / 5;
                    int var3 = (int) (((this.getZ() - player.getZ())) * i) / 5;
                    if (this.level.getBlockState(new BlockPos((int) this.getX() - var2, (int) this.getY(), (int) this.getZ() - var3)).getBlock() == Blocks.AIR) {
                        this.level.setBlock(new BlockPos((int) this.getX() - var2, (int) this.getY(), (int) this.getZ() - var3), Blocks.FIRE.defaultBlockState(), 1);
                    }
                }
                this.setAbility(DEFAULT);
            }
        }
        if (this.getAbility() == FREEZE) {
            if (player != null) {
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 5));
                this.setAbility(DEFAULT);
                abilityTimer = 100;
            }
        }
        if (!level.isClientSide) this.performRangedAttack(player);
    }

    private void message() {
        List list = level.getEntities(this, this.getBoundingBox().expandTowards(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) list.get(var1);

                switch (this.getAbility()) {
                    case CHARGE:
                        player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.charge"), player.getUUID());
                        break;
                    case PULL:
                        this.playSound(SoundRegistry.FEEL_SOUL_ARKSIANE, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.pull"), player.getUUID());
                        }
                            break;
                    case FIRE:
                        player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.fire"), player.getUUID());
                        break;
                    case FREEZE:
                        this.playSound(SoundRegistry.STOP_AT_ONCE, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.freeze"), player.getUUID());
                        }
                        break;
                    case SPEED:
                        this.playSound(SoundRegistry.WRECK_SPEED, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                        player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.speed"), player.getUUID());
                    }
                        break;
                    case EXPLOSIONS:
                        this.playSound(SoundRegistry.EXPLOSIONS, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                        player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.explosion"), player.getUUID());
                    }
                        break;
                    case STRENGTH:
                        this.playSound(SoundRegistry.WRECK_STRENGTH, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                        player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.wreck.strength"), player.getUUID());
                    }
                        break;
                    default:
                        break;
                }
            }
        }

    }

    @Override
    public void tick() {
        super.tick();
        if (!level.isClientSide && !loaded) {
            List<PlayerEntity> players = this.level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox().expandTowards(30, 30, 30));
            for (PlayerEntity p : players) {
                p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.wreck.run"), p.getUUID());
                p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.wreck.smell"), p.getUUID());
            }
            this.playSound(SoundRegistry.WRECK_INTRO, 1.0F, 1.0F);
            loaded = true;
        }

        if (dead) {
            return;
        } else {
            PlayerEntity player = this.level.getNearestPlayer(this, 64.0D);
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

        boolean var4 = par1Entity.hurt(DamageSource.mobAttack(this), amount);

        if (var4) {
            if (this.getAbility() == PULL) {
                this.setAbility(CHARGE);
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25);
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.5);
                knockback = 2;
            }
            if (knockback > 0) {
                par1Entity.setDeltaMovement(-MathHelper.sin(this.xRot * (float) Math.PI / 180.0F) * knockback * 0.5F, 0.1D, MathHelper.cos(this.yRot * (float) Math.PI / 180.0F) * knockback * 0.5F);

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
        if (entity == null) return;
        double tx = entity.getX() - this.getX();
        double ty = entity.getBoundingBox().minY - this.getY();
        double tz = entity.getZ() - this.getZ();
        switch (this.getAbility()) {
            case BOUNCE:
                //TODO - wreck projectiles
//                EntityWreckBouncingProjectile projectile = new EntityWreckBouncingProjectile(this.world, this, 35);
//                projectile.shoot(tx, ty, tz, 1.6f, 12f);
//                this.world.spawnEntity(projectile);
                this.setAbility(DEFAULT);
                break;
            case SPEED:
                if (this.abilityTimer % 5 == 0) {
//                    EntityWreckShot shot = new EntityWreckShot(this.world, this, 15);
//                    shot.shoot(tx, ty, tz, 1.6f, 12f);
//                    this.world.spawnEntity(shot);
                }
                if (this.abilityTimer <= 100) {
                    this.setAbility(DEFAULT);
                }
                break;
            case EXPLOSIONS:
                if ((this.abilityTimer % 40) == 0) {
//                    EntityWreckExplosiveShot shot = new EntityWreckExplosiveShot(this.world, this);
//                    shot.shoot(tx, ty, tz, 1.6f, 12f);
//                    this.world.spawnEntity(shot);
                }
                if (this.abilityTimer == 0) this.setAbility(DEFAULT);
                break;
            case STRENGTH:
                if ((this.abilityTimer % 40) == 0) {
//                    EntityWreckShot shot = new EntityWreckShot(this.world, this, 40);
//                    shot.shoot(tx, ty, tz, 1.6f, 12f);
//                    this.world.spawnEntity(shot);
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
        this.targetSelector.addGoal(0, new SwimGoal(this));
        this.targetSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.targetSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
        this.goalSelector.addGoal(1, new HurtByTargetGoal(this, PiglinEntity.class));
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
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

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.wreckHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.wreckDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.wreckSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.wreckFollowRange);
    }
}
