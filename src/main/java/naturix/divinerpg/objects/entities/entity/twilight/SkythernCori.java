package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGFlying;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class SkythernCori extends EntityDivineRPGFlying {
    
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;
    private BlockPos currentFlightTarget;
    
    public SkythernCori(World var1) {
        super(var1);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.skythernCoriHealth);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.skythernCoriSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.skythernCoriFollowRange);
    }

    protected void entityInit() {
        super.entityInit();
        //FIXME - Data watcher stuff
//        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
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
            d3 = (double)MathHelper.sqrt(d3);

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
            this.targetedEntity = this.world.getClosestPlayerToEntity(this, 100.0D);

            if(this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }

        double d4 = 64.0D;

        if(this.targetedEntity != null && this.targetedEntity.getDistanceSq(this) < d4 * d4) {
            double d5 = this.targetedEntity.posX - this.posX;
            double d6 = this.targetedEntity.getEntityBoundingBox().minY+1 - this.posY;
            double d7 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0F / (float)Math.PI;

            if(this.canEntityBeSeen(this.targetedEntity)) {
                ++this.attackCounter;

                if(this.attackCounter == 20) {
                    //FIXME - Sound and projectile
//                    this.world.playSoundAtEntity(this.targetedEntity, Sounds.getSoundName(Sounds.coriShoot), 1.0F, 1.0F);
//                    EntityCoriShot shot = new EntityCoriShot(this.world, this, 100);
//                    shot.setThrowableHeading(d5, d6, d7, 1.6f, 4);
//                    if(!this.world.isRemote)this.world.spawnEntityInWorld(shot);
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

        if(!this.world.isRemote) {
            //FIXME - Data watcher stuff
//            byte b1 = this.dataWatcher.getWatchableObjectByte(16);
//            byte b0 = (byte)(this.attackCounter > 10 ? 1 : 0);
//
//            if(b1 != b0) {
//                this.dataWatcher.updateObject(16, Byte.valueOf(b0));
//            }
        }
    }

    private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
        double var9 = (this.waypointX - this.posX) / par7;
        double var11 = (this.waypointY - this.posY) / par7;
        double var13 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB var15 = this.getEntityBoundingBox();

        for(int var16 = 1; (double)var16 < par7; ++var16) {
            var15.offset(var9, var11, var13);

            if(!this.world.collidesWithAnyBlock(var15)) {
                return false;
            }
        }

        return true;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.CORI_IDLE;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CORI_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CORI_HURT;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/skythern_cori");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    public int getMaxSpawnedInChunk() {
        return 1;
    }
}