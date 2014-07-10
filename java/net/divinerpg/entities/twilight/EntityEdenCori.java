package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGFlying;
import net.divinerpg.entities.twilight.projectile.EntityCoriShot;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityEdenCori extends EntityDivineRPGFlying {
	
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;
    private ChunkCoordinates currentFlightTarget;
    
    public EntityEdenCori(World var1) {
        super(var1);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.edenCoriHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.edenCoriSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.edenCoriFollowRange);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
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
            		this.worldObj.playSoundAtEntity(this.targetedEntity, Sounds.getSoundName(Sounds.coriShoot), 1.0F, 1.0F);
            		EntityCoriShot shot = new EntityCoriShot(this.worldObj, this, 50);
            		this.worldObj.spawnEntityInWorld(shot);
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
    	return 1;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.coriIdle);
    }

    @Override
    protected String getHurtSound() {
        return Sounds.getSoundName(Sounds.coriHurt);
    }

    @Override
    protected String getDeathSound() {
        return Sounds.getSoundName(Sounds.coriHurt);
    }

    @Override
    protected Item getDropItem() {
        return TwilightItemsOther.edenSoul;
    }

	@Override
	public String mobName() {
		return "Eden Cori";
	}
}