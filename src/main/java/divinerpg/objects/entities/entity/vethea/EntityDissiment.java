package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityDivineRPGFlying;
import divinerpg.objects.entities.entity.projectiles.EntityDissimentShot;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDissiment extends EntityDivineRPGFlying {
	
    private static final double spawnLayer = 4;
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity = null;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;

    public EntityDissiment(World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.experienceValue = 5;
        this.setSize(4.0F, 4.0F);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 48.0D * spawnLayer && this.posY > 48.0D * (spawnLayer - 1) && super.getCanSpawnHere();
    }
    private static final DataParameter<Integer> INTNeedsWork = EntityDataManager.<Integer>createKey(EntityDissiment.class,
            DataSerializers.VARINT);
    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(INTNeedsWork, Integer.valueOf(100));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(70);
    }
    
    @Override
    public void onLivingUpdate() {
    	if(!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    	if(!this.world.isRemote) {
        this.prevAttackCounter = this.attackCounter;
                
        if (this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
        }

        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.world.getClosestPlayerToEntity(this, 100.0D);

            if (this.targetedEntity != null) {
                this.aggroCooldown = 200;
            }
        }

        double var9 = 128.0D;

        if (this.targetedEntity != null && this.targetedEntity.getDistanceSq(this) < var9 * var9) {
            double var11 = this.targetedEntity.posX - this.posX;
            double var13 = this.targetedEntity.getEntityBoundingBox().minY + this.targetedEntity.height / 2.0F - (this.posY + this.height / 2.0F);
            double var15 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(var11, var15)) * 180.0F / (float)Math.PI;

            if (this.canEntityBeSeen(this.targetedEntity)) {
                if (this.attackCounter == 0) {
                    EntityDissimentShot var17 = new EntityDissimentShot(this.world, this);
                    double var18 = 4.0D;
                    Vec3d var20 = this.getLook(1.0F);
                    var17.posX = this.posX + var20.x * var18;
                    var17.posY = this.posY + this.height / 2.0F + 0.5D;
                    var17.posZ = this.posZ + var20.x * var18;
                    this.world.spawnEntity(var17);
                    this.attackCounter = 5;
                }
            }
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        } else {
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI;

            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
    	}
        super.onLivingUpdate();
    }

    private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
        double var9 = (this.waypointX - this.posX) / par7;
        double var11 = (this.waypointY - this.posY) / par7;
        double var13 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB var15 = this.getEntityBoundingBox();

        for (int var16 = 1; var16 < par7; ++var16) {
            var15.offset(var9, var11, var13);

            if (!this.world.getCollisionBoxes(this, var15).isEmpty())
                return false;
        }

        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DISSIMENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DISSIMENT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DISSIMENT_HURT;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_DISSIMENT;
    }
    
    @Override
    protected float getSoundVolume() {
        return 10.0F;
    }

}
