package divinerpg.objects.entities.entity.boss;

import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class EntityQuadro extends EntityDivineBoss implements IRangedAttackMob {

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

    private QuadroAbility ability;
    private int abilityCooldown;
    private int rangedAttackCounter;
    public boolean dir;

    public EntityQuadro(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 2.2f);
        this.ability = getRandomAbility();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_QUADRO;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);


    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIAttackMelee(this, 1, true));
        this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityPigZombie.class));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget() instanceof EntityLivingBase)
            this.attackEntityWithRangedAttack(this.getAttackTarget(), 0);
        if (this.abilityCooldown <= 0) {
            this.ability = getRandomAbility();
            this.abilityCooldown = 500;
            this.rangedAttackCounter = 0;
            this.dir = true;
            int s = this.rand.nextInt(9);
            List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(30, 30, 30));
            for (EntityPlayer p : players) {

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

                this.world.playSound(p, p.getPosition(), sound, SoundCategory.HOSTILE, 1.0F, 1.0F);

                if (!world.isRemote)
                    p.sendMessage(LocalizeUtils.getClientSideTranslation(p, chatMessage));

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
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
            this.setAIMoveSpeed(0.48F);
        } else if (ability == QuadroAbility.MELEE_FAST) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.48D);
            this.setAIMoveSpeed(0.32F);
        } else if (ability == QuadroAbility.RANGED_SLOW) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
            this.setAIMoveSpeed(0);
        } else if (ability == QuadroAbility.RANGED_FAST) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
            this.setAIMoveSpeed(0);
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase par1, float par2) {
        switch (ability) {
            case RANGED_FAST:
                if ((this.rangedAttackCounter % 5) == 0) {
                    //1
                    EntityDivineArrow var2 = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, par1, 1.6f, 12);
                    this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                    this.world.spawnEntity(var2);
                }
                this.rangedAttackCounter++;
                break;
            case RANGED_SLOW:
                if ((this.rangedAttackCounter % 15) == 0) {
                    //2
                    EntityDivineArrow var4 = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, par1, 1.6f, 12);
                    this.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
                    this.world.spawnEntity(var4);
                }
                this.rangedAttackCounter++;
                break;
            default:
                break;
        }
    }

    @Override
    public void setSwingingArms(boolean b) {
    }


    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }

    private QuadroAbility getRandomAbility() {
        switch (this.rand.nextInt(4)) {
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
