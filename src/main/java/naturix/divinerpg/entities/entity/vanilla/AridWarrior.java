package naturix.divinerpg.entities.entity.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityDivineRPGMob;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.client.audio.Sound;
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
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class AridWarrior extends EntityDivineRPGMob {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/arid_warrior");

    public AridWarrior(World worldIn) {
		super(worldIn);
		this.setSize(1.6F, 1.6f);
		this.setHealth(this.getMaxHealth());
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    protected void initEntityAI()
    {
    	super.initEntityAI();
    	addAttackingAI();
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

/*
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.world.isRemote) {
            this.attackingPlayer = this.world.getClosestPlayerToEntity(this, 16);
            if(this.attackingPlayer != null && this.ticksExisted%18==0) this.attackEntityWithRangedAttack((EntityLivingBase)this.attackingPlayer);
        }
    }

    public void attackEntityWithRangedAttack(EntityLivingBase e) {
        EntityArrow arrow = new EntityArrow(this.world, this, e, 1.6F, 4.5F);
        arrow.setDamage(1.5);

        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(arrow);
    }
    */

    @Override
    protected SoundEvent getAmbientSound() {
		return ModSounds.ARID_WARRIOR;
    }
    
    @Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.ARID_WARRIOR_HURT;
	}

    @Override
	protected SoundEvent getDeathSound() {
		return ModSounds.ARID_WARRIOR_HURT;
    }
    
    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;
	}
}
