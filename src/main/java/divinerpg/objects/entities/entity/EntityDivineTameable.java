package divinerpg.objects.entities.entity;

import divinerpg.config.Config;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public abstract class EntityDivineTameable extends EntityTameable {
	public EntityDivineTameable(World world) {
        super(world);
        setTamed(false);
    }

    @Override
    protected void initEntityAI() {
    	this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1, true));
        this.tasks.addTask(5, new EntityAIOwnerWithoutTeleport(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(1, new EntityAIFollowOwner(this, 1.0D, 30.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
        Config.initEntityAttributes(this);
    }

    /**
     * Increased health if tamable
     */
    protected void increaseHealthIfTimable() {
        if (this.isTamed()) {
            IAttributeInstance attribute = getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
            attribute.setBaseValue(attribute.getAttributeValue() * 2);
        }
    }

    @Override
    public EntityLivingBase getAttackTarget() {
        return this.isTamed() || this.isAngry() ? super.getAttackTarget() : null;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            Entity entity = source.getTrueSource();

            if (this.aiSit != null)
            {
                this.aiSit.setSitting(false);
            }

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }
    
    @Override
    public boolean attackEntityAsMob(Entity e) {
        boolean attack = super.attackEntityAsMob(e);
        if (attack && e instanceof EntityLiving) {
            ((EntityLiving) e).setRevengeTarget(this);
        }

        e.attackEntityFrom(DamageSource.causeMobDamage(this),
                (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());

        return attack;
    }

    public boolean isAngry() {
        return false;
    }

    @Override
    public boolean getCanSpawnHere() {
        return (this.world.getDifficulty() != EnumDifficulty.PEACEFUL);
    }

    protected void playTameEffect(boolean play) {
        EnumParticleTypes enumparticletypes = EnumParticleTypes.HEART;

        if (!play) {
            enumparticletypes = EnumParticleTypes.SMOKE_NORMAL;
        }

        for (int i = 0; i < 7; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.spawnParticle(enumparticletypes, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
        }
    }
    
    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed())
        {
            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack))
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget((EntityLivingBase)null);
            }
        }
        else if (!this.isAngry() && !this.world.isRemote)
            {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player))
                {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
                return true;
            }


        return super.processInteract(player, hand);
    }
}