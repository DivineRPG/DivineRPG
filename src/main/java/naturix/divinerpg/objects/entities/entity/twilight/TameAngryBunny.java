package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TameAngryBunny extends EntityTameable {

    public TameAngryBunny(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1f);
		this.setHealth(this.getHealth());
	}
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/bunny_angry_tamed");


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
       }

    protected void initEntityAI()
    {
    	this.tasks.addTask(4, new EntityAIFindEntityNearest(this, TameAngryBunny.class));
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
        //if(itemstack.getItem() == ModItems.edenSparklez) {
        //	this.heal(this.getMaxHealth());
        //	this.glowing=true;
        //}
        return super.processInteract(player, hand);
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
	@Override
	public void onLivingUpdate()
    {this.updateArmSwingProgress();
    float f = this.getBrightness();

    if (f > 0.5F)
    {
        this.idleTime += 2;
    }

    super.onLivingUpdate();
		if(rand.nextInt(50) == 2) {
		this.glowing=false;
    }
}
}
