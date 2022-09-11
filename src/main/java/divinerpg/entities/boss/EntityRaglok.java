package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EntityRaglok extends EntityDivineBoss {

    private int ability;
    private final int DEFAULT = 0, LIGHTNING = 1, BLIND = 2, BOMBS = 3, SLOW = 4;
    private double prevPlayerX, prevPlayerY, prevPlayerZ;
    private int abilityCooldown;
    private boolean loaded = false;
    private int rangedAttackCounter;
    private boolean avengeAbilityUsed = false;

    public EntityRaglok(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    @Override
    public void tick() {
        super.tick();
        if (!loaded && !this.level.isClientSide) {
            List<PlayerEntity> players = this.level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox().expandTowards(30, 30, 30));

            for (PlayerEntity p : players) {
                p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.raglok.dare"), p.getUUID());
            }

            this.playSound(SoundRegistry.RAGLOK_AWAKEN, 1.0F, 1.0F);
            loaded = true;
        }

        manageAbilities();
    }

    public void manageAbilities() {
        PlayerEntity player = this.level.getNearestPlayer(this, 64.0D);

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
                player.addEffect(new EffectInstance(Effects.BLINDNESS, 25, 0));
            }
        }
        if (ability == SLOW) {
            if (player != null) {
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 1));
            }
        }
        if (ability == LIGHTNING) {
            if (abilityCooldown % 40 == 0 && player != null) {
                LightningBoltEntity ent = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
                ent.setPos(prevPlayerX, prevPlayerY, prevPlayerZ);
                this.level.addFreshEntity(ent);
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
            if (abilityCooldown % 30 == 0 && player != null && this.isAlive()) {

                for (int i = 0; i < 4; i++) {
                    EntityRaglokBomb var2 = new EntityRaglokBomb(EntityRegistry.RAGLOK_BOMB, this.level);
                    var2.moveTo(player.xo, player.yo + 5, player.zo);
                    var2.setDeltaMovement((random.nextDouble() - random.nextDouble()) / 5, -0.14, (random.nextDouble() - random.nextDouble()) / 5);
                    this.level.addFreshEntity(var2);
                    ++this.rangedAttackCounter;
                }
            }
            if (this.rangedAttackCounter == 12) {
                ability = DEFAULT;
            }
        }
    }

    private void message() {
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().expandTowards(64.0D, 64.0D, 64.0D));
        for (int var1 = 0; var1 < list.size(); ++var1) {
            if (list.get(var1) instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) list.get(var1);
                switch (ability) {
                    case LIGHTNING:
                        this.playSound(SoundRegistry.RAGLOK_GUARDIAN, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.think"), player.getUUID());
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.great"), player.getUUID());
                        }
                        break;
                    case BLIND:
                        this.playSound(SoundRegistry.RAGLOK_DARK, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.future"), player.getUUID());
                        }
                        break;
                    case BOMBS:
                        this.playSound(SoundRegistry.RAGLOK_RAIN, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.rain"), player.getUUID());
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.kill"), player.getUUID());
                        }
                        break;
                    case SLOW:
                        this.playSound(SoundRegistry.RAGLOK_NOTHING, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "message.raglok.compare"), player.getUUID());
                        }
                        break;
                    default:
                        break;
                }
            }
        }
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

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.RAGLOK_AVENGE;
    }

    @Override
    public void die(DamageSource source) {
        if (!avengeAbilityUsed) {
            if (!level.isClientSide) {
                List<PlayerEntity> players = level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox().expandTowards(30, 30, 30));
                for (PlayerEntity p : players) {
                    p.sendMessage(LocalizeUtils.getClientSideTranslation(p, "message.raglok.avenge"), p.getUUID());
                }
            }
            PlayerEntity player = level.getNearestPlayer(this, 64.0D);
            if (player != null && !player.isCreative()) {
                LightningBoltEntity bolt = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, level);
                bolt.setPos(player.position().x, player.position().y, player.position().z);
                level.addFreshEntity(bolt);
            }

            avengeAbilityUsed = true;
        }

        super.die(source);
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.raglokHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.raglokDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.raglokSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.raglokFollowRange);
    }
}
