package naturix.divinerpg.entities.entity.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityPeacefulUntilAttacked;
import naturix.divinerpg.registry.ModSounds;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class Cyclops extends EntityPeacefulUntilAttacked  {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/cyclops");

    public Cyclops(World worldIn) {
		super(worldIn);
		this.setSize(1.5F, 3.9F);
		this.setHealth(this.getMaxHealth());
		this.experienceValue = 40;
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
	public boolean isValidLightLevel() {
/*
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.boundingBox.minY);
        int k = MathHelper.floor(this.posZ);

        if (this.world.getSavedLightValue(EnumSkyBlock.SKY, i, j, k) > this.rand.nextInt(32)) return false;
        else {
            int l = this.worldObj.getBlockLightValue(i, j, k);

            if (this.world.isThundering()) {
                int i1 = this.world.skylightSubtracted;
                this.world.skylightSubtracted = 10;
                l = this.world.getBlockLightValue(i, j, k);
                this.world.skylightSubtracted = i1;
            }

            return l <= this.rand.nextInt(8);
        }
        */
        return world.canSeeSky(getPosition());
    }

    @Override
    protected SoundEvent getAmbientSound() {
		return ModSounds.CYCLOPS;
    }
    
    @Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.CYCLOPS_HURT;
	}

    @Override
	protected SoundEvent getDeathSound() {
		return ModSounds.CYCLOPS_HURT;
    }

    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;
	}

    @Override
    public boolean getCanSpawnHere() {
    	return this.getPosition().getY() > world.getSeaLevel();
    }
}
