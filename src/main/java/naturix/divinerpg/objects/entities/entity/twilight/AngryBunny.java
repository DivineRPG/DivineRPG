package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AngryBunny extends EntityMob {

    public AngryBunny(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 0.7f);
		this.setHealth(this.getHealth());
	}
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/bunny_angry");


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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(55.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    protected void initEntityAI()
    {
    	this.tasks.addTask(4, new EntityAIFindEntityNearest(this, AngryBunny.class));
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

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        BlockPos spawnmobat = this.getPosition();
        TameAngryBunny bunny = new TameAngryBunny(this.getEntityWorld());
        /**if(itemstack.getItem() == ModItems.edenSparklez) {
        	bunny.setLocationAndAngles(getPosition().getX(), getPosition().getY(), getPosition().getZ(), this.prevRotationYaw, this.rotationPitch);
        	bunny.setPosition(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ());
        	if(!world.isRemote) {
        		world.spawnEntity(bunny);
        		this.isDead = true;
        		}
        }*/
        return super.processInteract(player, hand);
    }
	@Override
	public void onLivingUpdate()
    {
		this.updateArmSwingProgress();
        float f = this.getBrightness();

        if (f > 0.5F)
        {
            this.idleTime += 2;
        }

        super.onLivingUpdate();
		if(rand.nextInt(5000) == 2) {
			Bunny bunny = new Bunny(this.getEntityWorld());
			bunny.setLocationAndAngles(getPosition().getX(), getPosition().getY(), getPosition().getZ(), this.prevRotationYaw, this.rotationPitch);
        	
			if(!world.isRemote) {
        		world.spawnEntity(bunny);
        		this.isDead = true;
        		}
    }
    }
}
