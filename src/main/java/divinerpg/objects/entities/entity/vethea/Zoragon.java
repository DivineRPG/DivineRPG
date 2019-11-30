package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.objects.entities.entity.projectiles.EntityZoragonBomb;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Zoragon extends VetheaMob {

    private BlockPos currentFlightTarget;
    private int flyTimer;
    private int special;
    
    public Zoragon(World worldIn) {
		super(worldIn);
		this.setSize(1.5F, 2f);
	}

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_ZORAGON;
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
        
        if (target != null) {
            int targetX = (int) target.posX;
            int targetY = (int) target.posY;
            int targetZ = (int) target.posZ;
            currentFlightTarget = new BlockPos(targetX, targetY + 15, targetZ);
            if(target instanceof EntityPlayer && ((EntityPlayer)target).capabilities.isCreativeMode) target = null;
        }
        else if (flyTimer != 0) {
            flyTimer = 360;
            currentFlightTarget = new BlockPos((int)(this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F), (int)(this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F));
        }

        if (currentFlightTarget != null) {
            double distX = currentFlightTarget.getX() - this.posX;
            double distY = currentFlightTarget.getY() - this.posY;
            double distZ = currentFlightTarget.getZ() - this.posZ;

            if (Math.signum(distX) != 0 || Math.signum(distY) != 0 || Math.signum(distZ) != 0) {
                this.motionX += (Math.signum(distX) * 0.15D - this.motionX) * 0.10000000149011612D;
                this.motionY += (Math.signum(distY) * 1.699999988079071D - this.motionY) * 0.10000000149011612D;
                this.motionZ += (Math.signum(distZ) * 0.15D - this.motionZ) * 0.10000000149011612D;
                float var7 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
                //float var8 = MathHelper.wrapAngleTo180_float(var7 - this.rotationYaw);
                float var8 = MathHelper.wrapDegrees(var7 - this.rotationYaw);
                this.moveForward = 0.5F;
                this.rotationYaw += var8;
            }

            if (Math.abs(distX) < 3 && Math.abs(distY) < 3 && Math.abs(distZ) < 3) {
                if (special == 0) {
                    special = 120;
                    EntityZoragonBomb bomb = new EntityZoragonBomb(this.world, this.posX, this.posY - 1, this.posZ);
                    bomb.motionY=-0.1f;
                    this.world.spawnEntity(bomb);
                } else {
                    special--;
                }
            }

            flyTimer--;
        }

        super.onLivingUpdate();
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

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
}
