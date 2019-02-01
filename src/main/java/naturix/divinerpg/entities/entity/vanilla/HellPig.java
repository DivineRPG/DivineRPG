package naturix.divinerpg.entities.entity.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
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
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class HellPig extends EntityDivineRPGTameable {

    public HellPig(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 0.9F);
		this.setHealth(this.getMaxHealth());
	}

    @Override
    protected boolean canDespawn() {
        return true;
    }
    @Override
    public boolean getCanSpawnHere()
    {
    	return this.world.getDifficulty() != EnumDifficulty.PEACEFUL&& world.getBlockState(getPosition().down()) == Blocks.SOUL_SAND.getDefaultState();
    }
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
    }

    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/hell_pig");

    private ResourceLocation deathLootTable = LOOT;
    @Override
   	protected ResourceLocation getLootTable()
   	{
   		return this.LOOT;

   	}
    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }
    @Override
    protected void playStepSound(BlockPos pos, Block b) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, .15f, 1);
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}

}
