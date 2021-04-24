package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class EntityQuadro extends EntityDivineBoss implements IRangedAttackMob {
    private QuadroAbility ability;
    private int abilityCooldown;
    private int rangedAttackCounter;
    public boolean dir;

    public EntityQuadro(EntityType<? extends MobEntity> type, World worldIn) {
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
            List<PlayerEntity> players = this.level.getEntitiesOfClass(PlayerEntity.class, this.getBoundingBox().expandTowards(30, 30, 30));
            for (PlayerEntity p : players) {

                SoundEvent sound;
                String chatMessage;
                switch (s) {
                    case 0:
                        sound = SoundRegistry.QUADRO_DIE_BEFORE;
                        chatMessage = "message.quadro.die";
                        break;
                    case 1:
                        sound = SoundRegistry.QUADRO_ENOUGH;
                        chatMessage = "message.quadro.enough";
                        break;
                    case 2:
                        sound = SoundRegistry.QUADRO_INCOMING_PUNCH;
                        chatMessage = "message.quadro.punch";
                        break;
                    case 3:
                        sound = SoundRegistry.QUADRO_IS_NEXT;
                        chatMessage = "message.quadro.next";
                        break;
                    case 4:
                        sound = SoundRegistry.QUADRO_KILL_MINE;
                        chatMessage = "message.quadro.mine";
                        break;
                    case 5:
                        sound = SoundRegistry.QUADRO_MY_KILL;
                        chatMessage = "message.quadro.kill";
                        break;
                    case 6:
                        sound = SoundRegistry.QUADRO_NO_DIE;
                        chatMessage = "message.quadro.no";
                        break;
                    case 7:
                        sound = SoundRegistry.QUADRO_SIT_DOWN;
                        chatMessage = "message.quadro.sit"; //deserve
                        break;
                    default:
                        sound = SoundRegistry.QUADRO_TASTE_FIST;
                        chatMessage = "message.quadro.taste";
                        break;
                }

                this.level.playSound(p, p.blockPosition(), sound, SoundCategory.HOSTILE, 1.0F, 1.0F);

                if (!level.isClientSide)
                    p.sendMessage(LocalizeUtils.getClientSideTranslation(p, chatMessage), p.getUUID());

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
    public void performRangedAttack(LivingEntity par1, float par2) {
        switch (ability) {
            case RANGED_FAST:
                if ((this.rangedAttackCounter % 5) == 0) {
                    //1
                    //TODO - Quadro projectiles
//                    EntityDivineArrow var2 = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, par1, 1.6f, 12);
//                    this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
//                    this.world.spawnEntity(var2);
                }
                this.rangedAttackCounter++;
                break;
            case RANGED_SLOW:
                if ((this.rangedAttackCounter % 15) == 0) {
                    //2
//                    EntityDivineArrow var4 = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, par1, 1.6f, 12);
//                    this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
//                    this.world.spawnEntity(var4);
                }
                this.rangedAttackCounter++;
                break;
            default:
                break;
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
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.quadroHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.quadroAttack)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.quadroSpeedSlow).add(Attributes.FOLLOW_RANGE, EntityStats.quadroFollowRange);
    }
}
