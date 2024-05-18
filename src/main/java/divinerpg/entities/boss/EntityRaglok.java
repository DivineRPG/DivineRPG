package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class EntityRaglok extends EntityDivineBoss {

    private int ability;
    private final int DEFAULT = 0, LIGHTNING = 1, BLIND = 2, BOMBS = 3, SLOW = 4;
    private double prevPlayerX, prevPlayerY, prevPlayerZ;
    private int abilityCooldown;
    private boolean loaded = false;
    private int rangedAttackCounter;
    private boolean avengeAbilityUsed = false;

    public EntityRaglok(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public void tick() {
        super.tick();
        if (!loaded && !this.level().isClientSide) {
            List<Player> players = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().expandTowards(30, 30, 30));

            for (Player p : players) {
                p.displayClientMessage(LocalizeUtils.getClientSideTranslation(p, "message.raglok.dare"), true);
            }

            this.playSound(SoundRegistry.RAGLOK_AWAKEN.get(), 1.0F, 1.0F);
            loaded = true;
        }

        if(this.isAlive()) {
            manageAbilities();
        }
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 5.0F;
    }

    public void manageAbilities() {
        Player player = this.level().getNearestPlayer(this, 64.0D);

        if (player == null || player.isCreative() || avengeAbilityUsed) {
            return;
        }

        if (abilityCooldown == 0 || ability == DEFAULT) {
            abilityCooldown = 400;
            switch (this.random.nextInt(4)) {
                case 0:
                    ability = LIGHTNING;
                    this.rangedAttackCounter = 0;
                    this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
                    break;
                case 1:
                    ability = BLIND;
                    this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
                    break;
                case 2:
                    ability = BOMBS;
                    this.rangedAttackCounter = 0;
                    this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
                    break;
                case 3:
                    ability = SLOW;
                    this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
                    break;
                default:
                    break;
            }
            this.message();
        } else if (abilityCooldown > 0) {
            abilityCooldown--;
        }

        if (ability == BLIND) {
            if (player != null) {
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 25, 1));
            }
        }
        if (ability == SLOW) {
            if (player != null) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 1));
            }
        }
        if (ability == LIGHTNING) {
            if (abilityCooldown % 40 == 0 && player != null) {
                LightningBolt ent = new LightningBolt(EntityType.LIGHTNING_BOLT, level());
                ent.setPos(prevPlayerX, prevPlayerY, prevPlayerZ);
                this.level().addFreshEntity(ent);
                this.rangedAttackCounter++;
            } else if (abilityCooldown % 40 != 0 && abilityCooldown % 20 == 0 && player != null) {
                this.prevPlayerX = player.getX();
                this.prevPlayerY = player.getY();
                this.prevPlayerZ = player.getZ();
            }
            if (this.rangedAttackCounter == 10) {
                ability = DEFAULT;
            }
        }
        if (ability == BOMBS) {
            if (abilityCooldown % 30 == 0 && player != null) {

                for (int i = 0; i < 4; i++) {


                    ThrowableProjectile var2 = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.RAGLOK_BOMB);
                    var2.moveTo(player.xo, player.yo + 5, player.zo);
                    var2.setDeltaMovement((random.nextDouble() - random.nextDouble()) / 5, -0.14, (random.nextDouble() - random.nextDouble()) / 5);
                    this.level().addFreshEntity(var2);
                    ++this.rangedAttackCounter;
                }
            }
            if (this.rangedAttackCounter == 12) {
                ability = DEFAULT;
            }
        }
    }

    private void message() {
        List<Entity> list = this.level().getEntities(this, this.getBoundingBox().expandTowards(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof Player) {
                Player player = (Player) list.get(var1);
                switch (ability) {
                    case LIGHTNING:
                        this.playSound(SoundRegistry.RAGLOK_GUARDIAN.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.think"), true);
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.great"), true);
                        }
                        break;
                    case BLIND:
                        this.playSound(SoundRegistry.RAGLOK_DARK.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.future"), true);
                        }
                        break;
                    case BOMBS:
                        this.playSound(SoundRegistry.RAGLOK_RAIN.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.rain"), true);
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.kill"), true);
                        }
                        break;
                    case SLOW:
                        this.playSound(SoundRegistry.RAGLOK_NOTHING.get(), 1.0F, 1.0F);
                        if (!level().isClientSide) {
                            player.displayClientMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.compare"), true);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
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

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAGLOK_AVENGE.get();
    }

    @Override
    public void die(DamageSource source) {
        if (!avengeAbilityUsed) {
            if (!level().isClientSide()) {
                List<Player> players = level().getEntitiesOfClass(Player.class, this.getBoundingBox().expandTowards(30, 30, 30));
                for (Player p : players) {
                    p.displayClientMessage(LocalizeUtils.getClientSideTranslation(p, "message.raglok.avenge"), true);
                }
            }
            Player player = level().getNearestPlayer(this, 64.0D);
            if (player != null && !player.isCreative()) {
                LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level());
                bolt.setPos(player.position().x, player.position().y, player.position().z);
                level().addFreshEntity(bolt);
            }

            avengeAbilityUsed = true;
        }

        super.die(source);
    }
}
