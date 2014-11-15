package net.divinerpg.entities.vanilla;

import net.divinerpg.api.entity.EntityDivineRPGFlying;
import net.divinerpg.entities.vanilla.projectile.EntityFrostShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityFrost extends EntityDivineRPGFlying {
	
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;
    private ChunkCoordinates currentFlightTarget;
    
    public EntityFrost(World var1) {
        super(var1);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.frostHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.frostSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.frostFollowRange);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }
    
    @Override
	public void onUpdate() {
    	super.onUpdate();
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
                this.motionY += d1 / d3 * 0.03D;
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
        if(this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < 32*32) {
            double d5 = this.targetedEntity.posX - this.posX;
            double d6 = this.targetedEntity.boundingBox.minY + (double)(this.targetedEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double d7 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0F / (float)Math.PI;
            
                ++this.attackCounter;

                if(this.attackCounter == 6 || this.attackCounter == 7 || this.attackCounter == 8) {
            		this.worldObj.playSoundAtEntity(this.targetedEntity, Sounds.getSoundName(Sounds.frost), 1.0F, 1.0F);
            		if(!this.worldObj.isRemote){
            			EntityFrostShot shot = new EntityFrostShot(this.worldObj, this.targetedEntity.posX, this.targetedEntity.posY, this.targetedEntity.posZ);
            			this.worldObj.spawnEntityInWorld(shot);
            			shot.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0);
            			shot.setThrowableHeading(this.targetedEntity.posX, this.targetedEntity.posY, this.targetedEntity.posZ, 0, 0);
            		}
            		this.attackCounter = -5;
                }
            }
            else if(this.attackCounter > 0) {
                --this.attackCounter;
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
        double var9 = (this.waypointX - this.posX) / par7;
        double var11 = (this.waypointY - this.posY) / par7;
        double var13 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB var15 = this.boundingBox.copy();

        for(int var16 = 1; (double)var16 < par7; ++var16) {
            var15.offset(var9, var11, var13);

            if(!this.worldObj.getCollidingBoundingBoxes(this, var15).isEmpty()) {
                return false;
            }
        }

        return true;
    }
    
    @Override
    public int getMaxSpawnedInChunk() {
    	return 2;
    }

    @Override
    protected String getLivingSound() {
        return "mod.blaze.breathe";
    }

    @Override
    protected String getHurtSound() {
        return "mob.blaze.hit";
    }

    @Override
    protected String getDeathSound() {
        return "mod.blaze.death";
    }

    @Override
    protected void dropFewItems(boolean var1, int var2) {
        int var3 = this.rand.nextInt(2 + var2);
        int var4;

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(ItemsFood.tomato, 2);
        }

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(IceikaItems.iceShards, 5);
        }

        for(var4 = 0; var4 < var3; ++var4) {
            this.dropItem(IceikaItems.iceStone, 1);
        }
    }

	@Override
	public String mobName() {
		return "Frost";
	}
}