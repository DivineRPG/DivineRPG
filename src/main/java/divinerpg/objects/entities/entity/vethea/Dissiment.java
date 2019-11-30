package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.objects.entities.entity.projectiles.EntityDissimentShot;
import divinerpg.registry.DRPGLootTables;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class Dissiment extends EntityMob {

    private static final double spawnLayer = 4;
    public int courseChangeCooldown = 0;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private int aggroCooldown = 0;
    public int prevAttackCounter = 0;
    public int attackCounter = 0;

    public Dissiment(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1f);
        this.setHealth(this.getMaxHealth());
    }

    @Override
	protected ResourceLocation getLootTable()
	{
		return DRPGLootTables.ENTITIES_DISSIMENT;
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);

    }

    @Override
    public void onLivingUpdate() {
        EntityLivingBase target = this.getAttackTarget();
        
        if(!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if(!this.world.isRemote) {
            this.prevAttackCounter = this.attackCounter;

            if (target != null && target.isDead) {
                this.setAttackTarget(null);
            }

            if (target == null || this.aggroCooldown-- <= 0) {
                target = this.world.getClosestPlayerToEntity(this, 100.0D);

                if (target != null && !((EntityPlayer) target).isCreative()) {
                    this.aggroCooldown = 200;
                }
            }

            double var9 = 128.0D;

            if (target != null && target.getDistanceSq(this) < var9 * var9) {
                double var11 = target.posX - this.posX;
                double var13 = target.getEntityBoundingBox().minY + target.height / 2.0F - (this.posY + this.height / 2.0F);
                double var15 = target.posZ - this.posZ;
                this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(var11, var15)) * 180.0F / (float)Math.PI;

                if (this.canEntityBeSeen(target)) {
                    if (this.attackCounter == 0) {
                        EntityDissimentShot var17 = new EntityDissimentShot(this.world, this);
                        double var18 = 4.0D;
                        Vec3d var20 = this.getLook(1.0F);
                        var17.posX = this.posX + var20.x * var18;
                        var17.posY = this.posY + this.height / 2.0F + 0.5D;
                        var17.posZ = this.posZ + var20.z * var18;
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
            AxisAlignedBB var17 = var15.offset(var9, var11, var13);

            if (!this.world.getCollisionBoxes(this, var17).isEmpty())
                return false;
        }

        return true;
    }

    
    protected void initEntityAI()
    {
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
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityPigZombie.class}));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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
}
