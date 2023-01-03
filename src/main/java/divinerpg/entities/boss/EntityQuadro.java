package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class EntityQuadro extends EntityDivineBoss implements RangedAttackMob {
    private QuadroAbility ability;
    private int abilityCooldown;
    private int rangedAttackCounter;
    public boolean dir;

    public EntityQuadro(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.ability = getRandomAbility();
    }

    enum QuadroAbility {
        RANGED_SLOW(0), RANGED_FAST(1), MELEE_SLOW(2), MELEE_FAST(3);

        private int numVal;

        QuadroAbility(int numVal) {
            this.numVal = numVal;
        }

        public int value() {
            return numVal;
        }
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        this.targetSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(8, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(8, new FollowMobGoal(this, 1, 1, 1));
        this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.getTarget() != null && this.getTarget() instanceof LivingEntity)
            this.performRangedAttack(this.getTarget(), 0);
        if (this.abilityCooldown <= 0) {
            this.ability = getRandomAbility();
            this.abilityCooldown = 500;
            this.rangedAttackCounter = 0;
            this.dir = true;
            int s = this.random.nextInt(9);
            List<Player> players = this.level.getEntitiesOfClass(Player.class, this.getBoundingBox().expandTowards(30, 30, 30));
            for (Player p : players) {

                SoundEvent sound;
                String chatMessage;
                switch (s) {
                    case 0:
                        sound = SoundRegistry.QUADRO_DIE_BEFORE.get();
                        chatMessage = "message.quadro.die";
                        break;
                    case 1:
                        sound = SoundRegistry.QUADRO_ENOUGH.get();
                        chatMessage = "message.quadro.enough";
                        break;
                    case 2:
                        sound = SoundRegistry.QUADRO_INCOMING_PUNCH.get();
                        chatMessage = "message.quadro.punch";
                        break;
                    case 3:
                        sound = SoundRegistry.QUADRO_IS_NEXT.get();
                        chatMessage = "message.quadro.next";
                        break;
                    case 4:
                        sound = SoundRegistry.QUADRO_KILL_MINE.get();
                        chatMessage = "message.quadro.mine";
                        break;
                    case 5:
                        sound = SoundRegistry.QUADRO_MY_KILL.get();
                        chatMessage = "message.quadro.kill";
                        break;
                    case 6:
                        sound = SoundRegistry.QUADRO_NO_DIE.get();
                        chatMessage = "message.quadro.no";
                        break;
                    case 7:
                        sound = SoundRegistry.QUADRO_SIT_DOWN.get();
                        chatMessage = "message.quadro.sit"; //deserve
                        break;
                    default:
                        sound = SoundRegistry.QUADRO_TASTE_FIST.get();
                        chatMessage = "message.quadro.taste";
                        break;
                }

                this.level.playSound(p, p.blockPosition(), sound, SoundSource.HOSTILE, 1.0F, 1.0F);

                if (!level.isClientSide)
                    p.displayClientMessage(LocalizeUtils.getClientSideTranslation(p, chatMessage), true);

            }
        }
        if (this.abilityCooldown == 480) {
            this.abilityCooldown--;
            this.dir = false;
        }
        if (this.abilityCooldown > 0) {
            this.abilityCooldown--;
        }

        if (ability == QuadroAbility.MELEE_SLOW) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32D);
            this.setSpeed(0.48F);
        } else if (ability == QuadroAbility.MELEE_FAST) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.48D);
            this.setSpeed(0.32F);
        } else if (ability == QuadroAbility.RANGED_SLOW) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
            this.setSpeed(0);
        } else if (ability == QuadroAbility.RANGED_FAST) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
            this.setSpeed(0);
        }
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (getTarget() != null) {
            if (isAlive() && !level.isClientSide) {
                switch (ability) {
                    case RANGED_FAST:
                        if ((this.rangedAttackCounter % 5) == 0) {
                            double tx = getTarget().getX() - this.getX();
                            double ty = getTarget().getBoundingBox().minY - this.getY();
                            double tz = getTarget().getZ() - this.getZ();
                            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level, ArrowType.KAROS_ARROW, this, target, 2.6F, 3.0F);
                            projectile.shoot(tx, ty, tz, 2.6f, 3.0F);
                            this.level.addFreshEntity(projectile);
                        }
                        this.rangedAttackCounter++;
                        break;
                    case RANGED_SLOW:
                        if ((this.rangedAttackCounter % 15) == 0) {
                            double tx = getTarget().getX() - this.getX();
                            double ty = getTarget().getBoundingBox().minY - this.getY();
                            double tz = getTarget().getZ() - this.getZ();
                            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level, ArrowType.KAROS_ARROW, this, target, 2.6F, 0.8F);
                            projectile.shoot(tx, ty, tz, 2.6f, 0.8F);
                            this.level.addFreshEntity(projectile);
                        }
                        this.rangedAttackCounter++;
                        break;
                    default:
                        break;
                }
            }
        }
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

    private QuadroAbility getRandomAbility() {
        switch (this.random.nextInt(4)) {
            case 0:
                return QuadroAbility.RANGED_SLOW;
            case 1:
                return QuadroAbility.RANGED_FAST;
            case 2:
                return QuadroAbility.MELEE_SLOW;
            case 3:
                return QuadroAbility.MELEE_FAST;
            default:
                return null;
        }
    }
}
