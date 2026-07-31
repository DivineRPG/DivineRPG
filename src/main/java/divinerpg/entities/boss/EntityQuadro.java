package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import divinerpg.entities.projectile.arrows.PardimalArrow;
import divinerpg.registries.ItemRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class EntityQuadro extends EntityDivineBoss implements RangedAttackMob {
    private QuadroAbility ability;
    private int abilityCooldown;
    private int rangedAttackCounter;
    public boolean dir;

    public EntityQuadro(EntityType<? extends EntityQuadro> type, Level worldIn) {
        super(type, worldIn);
        this.ability = getRandomAbility();
    }

    enum QuadroAbility {
        RANGED_SLOW, RANGED_FAST, MELEE_SLOW, MELEE_FAST
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
        if(!this.level().isClientSide() && this.getTarget() != null && this.getTarget() instanceof LivingEntity)
            this.performRangedAttack(this.getTarget(), 0);
        if(this.abilityCooldown <= 0) {
            this.ability = getRandomAbility();
            this.abilityCooldown = 500;
            this.rangedAttackCounter = 0;
            this.dir = true;
            int s = this.random.nextInt(9);
            List<Player> players = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().expandTowards(30, 30, 30));
            for(Player p : players) {
                SoundEvent sound;
                String chatMessage = switch(s) {
                    case 0 -> {
                        sound = SoundRegistry.QUADRO_DIE_BEFORE.get();
                        yield "message.quadro.die";
                    }
                    case 1 -> {
                        sound = SoundRegistry.QUADRO_ENOUGH.get();
                        yield "message.quadro.enough";
                    }
                    case 2 -> {
                        sound = SoundRegistry.QUADRO_INCOMING_PUNCH.get();
                        yield "message.quadro.punch";
                    }
                    case 3 -> {
                        sound = SoundRegistry.QUADRO_IS_NEXT.get();
                        yield "message.quadro.next";
                    }
                    case 4 -> {
                        sound = SoundRegistry.QUADRO_KILL_MINE.get();
                        yield "message.quadro.mine";
                    }
                    case 5 -> {
                        sound = SoundRegistry.QUADRO_MY_KILL.get();
                        yield "message.quadro.kill";
                    }
                    case 6 -> {
                        sound = SoundRegistry.QUADRO_NO_DIE.get();
                        yield "message.quadro.no";
                    }
                    case 7 -> {
                        sound = SoundRegistry.QUADRO_SIT_DOWN.get();
                        yield "message.quadro.sit";
                    }
                    default -> {
                        sound = SoundRegistry.QUADRO_TASTE_FIST.get();
                        yield "message.quadro.taste";
                    }
                };

                this.level().playSound(p, p.blockPosition(), sound, SoundSource.HOSTILE, 1.0F, 1.0F);

                if (!level().isClientSide())
                    p.sendSystemMessage(LocalizeUtils.getClientSideTranslation(chatMessage));

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
            if (isAlive() && !level().isClientSide()) {
                switch (ability) {
                    case RANGED_FAST:
                        if ((this.rangedAttackCounter % 5) == 0) {
                            PardimalArrow abstractarrow = new PardimalArrow(level(), this, new ItemStack(ItemRegistry.pardimal_arrow.get()), new ItemStack(ItemRegistry.pardimal_bow.get()));
                            abstractarrow.powerMultiplier = 1.2F;
                            double d0 = target.getX() - getX(), d1 = target.getY(0.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
                            abstractarrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, 14F - (level().getDifficulty().getId() << 2));
                            playSound(SoundEvents.SKELETON_SHOOT, 1F, 1F / (getRandom().nextFloat() * .4F + .8F));
                            level().addFreshEntity(abstractarrow);
                        }
                        this.rangedAttackCounter++;
                        break;
                    case RANGED_SLOW:
                        if ((this.rangedAttackCounter % 15) == 0) {
                            PardimalArrow abstractarrow = new PardimalArrow(level(), this, new ItemStack(ItemRegistry.pardimal_arrow.get()), new ItemStack(ItemRegistry.pardimal_bow.get()));
                            abstractarrow.powerMultiplier = 1.2F;
                            double d0 = target.getX() - getX(), d1 = target.getY(0.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
                            abstractarrow.shoot(d0, d1 + d3 * 0.2, d2, 1.6F, 14F - (level().getDifficulty().getId() << 2));
                            playSound(SoundEvents.SKELETON_SHOOT, 1F, 1F / (getRandom().nextFloat() * .4F + .8F));
                            level().addFreshEntity(abstractarrow);
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
        return switch(this.random.nextInt(4)) {
            case 0 -> QuadroAbility.RANGED_SLOW;
            case 1 -> QuadroAbility.RANGED_FAST;
            case 2 -> QuadroAbility.MELEE_SLOW;
            case 3 -> QuadroAbility.MELEE_FAST;
            default -> null;
        };
    }
}