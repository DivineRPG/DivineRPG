package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGFlying;
import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.entities.vanilla.projectile.EntityTripletProjectile;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityEnderTriplets extends EntityDivineRPGFlying {
	
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;

    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;

    public EntityEnderTriplets(World par1World) {
        super(par1World);
        this.setSize(4.0F, 4.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
    }

    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        if(this.isEntityInvulnerable()) {
            return false;
        }
        else if("fireball".equals(par1DamageSource.getDamageType()) && par1DamageSource.getEntity() instanceof EntityPlayer) {
            super.attackEntityFrom(par1DamageSource, 1000.0F);
            EntityPlayer player = (EntityPlayer)par1DamageSource.getEntity();
            player.triggerAchievement(DivineRPGAchievements.tripleDanger);
            return true;
        } else {
            return super.attackEntityFrom(par1DamageSource, par2);
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.enderTripletsHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.enderTripletsSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.enderTripletsFollowRange);
    }

    @Override
    protected void updateEntityActionState() {
        if(!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }

        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;

        if(d3 < 1.0D || d3 > 3600.0D) {
            this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if(this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d3 = (double)MathHelper.sqrt_double(d3);

            if(this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
                this.motionX += d0 / d3 * 0.1D;
                this.motionY += d1 / d3 * 0.1D;
                this.motionZ += d2 / d3 * 0.1D;
            } else {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }

        if(this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
        }

        if(this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);

            if(this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }

        double d4 = 64.0D;

        if(this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < d4 * d4) {
            double d5 = this.targetedEntity.posX - this.posX;
            double d6 = this.targetedEntity.boundingBox.minY + (double)(this.targetedEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double d7 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0F / (float)Math.PI;

            if(this.canEntityBeSeen(this.targetedEntity)) {
                if(this.attackCounter == 10) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1007, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                }

                ++this.attackCounter;

                if(this.attackCounter == 20) {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1008, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
                    EntityTripletProjectile entitylargefireball = new EntityTripletProjectile(this.worldObj, this, d5, d6, d7);
                    double d8 = 4.0D;
                    Vec3 vec3 = this.getLook(1.0F);
                    entitylargefireball.posX = this.posX + vec3.xCoord * d8;
                    entitylargefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                    entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
                    this.worldObj.spawnEntityInWorld(entitylargefireball);
                    this.attackCounter = -40;
                }
            }
            else if(this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI;

            if(this.attackCounter > 0) {
                --this.attackCounter;
            }
        }

        if(!this.worldObj.isRemote) {
            byte b1 = this.dataWatcher.getWatchableObjectByte(16);
            byte b0 = (byte)(this.attackCounter > 10 ? 1 : 0);

            if(b1 != b0) {
                this.dataWatcher.updateObject(16, Byte.valueOf(b0));
            }
        }
    }

    private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
        double d4 = (this.waypointX - this.posX) / par7;
        double d5 = (this.waypointY - this.posY) / par7;
        double d6 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();

        for(int i = 1; (double)i < par7; ++i) {
            axisalignedbb.offset(d4, d5, d6);

            if(!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty()) {
                return false;
            }
        }
        return true;
    }
 
    @Override
    protected String getHurtSound() {
        return "mob.ghast.scream";
    }
 
    @Override
    protected String getDeathSound() {
        return "mob.ghast.death";
    }

    @Override
    protected Item getDropItem() {
        return VanillaItemsOther.enderShard;
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {

    	int j, k;
        j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

        for (k = 0; k < j; ++k) {
            this.dropItem(VanillaItemsOther.enderShard, 3);
        }
    }

    @Override
    protected float getSoundVolume() {
        return 10.0F;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

	@Override
	public String mobName() {
		return "Ender Triplet";
	}
}