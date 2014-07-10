package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.entities.vanilla.projectile.EntityTripletProjectile;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAyeraco extends EntityDivineRPGBoss {
	
    private String colour;
    private int waitTick;
    private ChunkCoordinates currentFlightTarget;
    private boolean attacks;
    private double moveX;
    private double moveZ;
    private boolean halfHp;
    public float moveSpeed = 0.3F;
    
    public EntityAyeraco(World var1, String par3) {
        super(var1);
        this.setSize(3.0F, 1.9F);
        this.colour = par3;
        this.waitTick = 0;
        this.attacks = false;
        this.moveX = this.rand.nextGaussian() * 0.25  - 0.125;
        this.moveZ = this.rand.nextGaussian() * 0.25 - 0.125;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.ayeracoHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.ayeracoDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.ayeracoSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.ayeracoFollowRange);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Integer(100));
    }
    
    public String getEntityName() {
        return "Ayeraco " + this.colour;
    }

    @Override
    protected boolean isAIEnabled() {
        return true;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.ayeraco);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.ayeracoHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.ayeracoHurt);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if(getHealth() * 2 < getMaxHealth()) {
            this.tickAbility();
            if (this.halfHp = false) {
                this.worldObj.playSoundAtEntity(this, Sounds.getSoundName(Sounds.ayeracoHalfHealth), 20.0F,  0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
            }
        }

        if(this.waitTick == 0) {
            if (this.getAttackTarget() != null) {
                int var1 = (int) this.getAttackTarget().posX;
                int var2 = (int) this.getAttackTarget().posY;
                int var3 = (int) this.getAttackTarget().posZ;
                this.currentFlightTarget = new ChunkCoordinates(var1, var2, var3);
            }

            this.motionY = 0;

            if(this.currentFlightTarget != null) {
                double var1 = this.currentFlightTarget.posX - this.posX;
                double var3 = this.currentFlightTarget.posY - this.posY;
                double var5 = this.currentFlightTarget.posZ - this.posZ;

                if (Math.signum(var1) != 0 || Math.signum(var3) != 0 || Math.signum(var5) != 0) {
                    this.motionX = Math.signum(var1) * moveSpeed;
                    this.motionY += (Math.signum(var3) * 5.699999988079071D - this.motionY) * 0.10000000149011612D;
                    this.motionZ = Math.signum(var5) * moveSpeed;
                    float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                    float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
                    this.moveForward = 0.5F;
                    this.rotationYaw += var8;
                }
            }
        } else {
            this.waitTick--;
            this.motionY = 0.3;
            this.motionX = this.moveX;
            this.motionZ = this.moveZ;
        }

        if (!this.attacks) {
            this.waitTick = 80;
            this.attacks = true;
            if (this.canTeleport()) {
                this.waitTick = 0;
                this.teleportRandomUp(this.worldObj);
            }
        }

    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected void fall(float par1) {}

    @Override
    protected void updateFallState(double par1, boolean par3) {}

    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if (this.isEntityInvulnerable())
            return false;
        else if (par1DamageSource.getSourceOfDamage() instanceof EntityTripletProjectile)
            return false;
        else if (par1DamageSource.isProjectile() && this.canBlockProjectiles())
            return false;
        else {
            if (par1DamageSource.getSourceOfDamage() instanceof EntityPlayer) {
                this.attacks = false;
            }
            return super.attackEntityFrom(par1DamageSource, par2);
        }
    }
 
    @Override
    protected void dropFewItems(boolean var1, int var2) {
        this.dropItem(VanillaItemsOther.divineShards, 2 + this.rand.nextInt(2));
        if (this.rand.nextInt(100) < 2) {
            switch (this.rand.nextInt(2)) {
                case 0:
                    this.dropItem(VanillaItemsArmor.divineBody, 1);
                case 1:
                    this.dropItem(VanillaItemsArmor.divineLegs, 1);
            }
        }

        if (this.rand.nextInt(100) < 5) {
            this.dropItem(VanillaItemsArmor.divineBoots, 1);
        }


        if (this.rand.nextInt(100) < 3) {
            this.dropItem(VanillaItemsArmor.divineHelmet, 1);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        this.attacks = false;
        return super.attackEntityAsMob(par1Entity);
    }

    protected void tickAbility(){}

    protected boolean canBlockProjectiles() {
        return true;
    }

    protected boolean canTeleport() {
        return true;
    }

    public boolean abilityActive() {
        if (getHealth() * 2 <= getMaxHealth() && !this.isDead)
            return true;
        return false;
    }

    protected void teleportRandomUp(World par1) {
        par1.playSoundAtEntity(this, Sounds.ayeracoTeleport.getPrefixedName(), 2.0F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
        this.motionY = 20;
        this.motionX = this.rand.nextInt(5);
        this.motionZ = this.rand.nextInt(5);
    }

	@Override
	public IChatComponent func_145748_c_() {
		return null;
	}

	protected Item getDropItem() {
		return VanillaItemsOther.divineShards;
    }
	
	@Override
	public String mobName() {
		return "Ayeraco " + colour;
	}

	@Override
	public String name() {
		return mobName();
	}

	@Override
	public IChatComponent chat() {
		return null;
	}
}
