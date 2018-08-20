package naturix.divinerpg.entities.entity;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
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
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LandShark extends EntityWaterMob {

    public LandShark(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 2);
		this.setHealth(40);
	}
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/shark.json");


    protected boolean isMaster() {
        return false;
    }

    @Override
    protected boolean canDespawn() {
        return true;
    }

    private ResourceLocation deathLootTable = LOOT;

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.1D);
        if (isMaster()) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
            //this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
            //this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6.0D);
        } else {
            //this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
        }
    }

    protected void initEntityAI()
    {
    	this.tasks.addTask(4, new EntityAIFindEntityNearest(this, LandShark.class));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIFollow(this, 1, 1, 1));
        this.tasks.addTask(10, new EntityAISwimming(this));
        this.applyEntityAI();
    }

    private void applyEntityAI() {
        }


    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    @Override
    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);
        if (entitylivingbaseIn instanceof EntityPlayer) {
            
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        super.playStepSound(pos, blockIn);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return super.getAmbientSound();
    }
    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;

	}
}
