package naturix.divinerpg.entities.entity.vanilla;


import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public class AncientEntity extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/ancient_entity");

    public AncientEntity(World worldIn) {
		super(worldIn);
		this.setSize(4.0F, 6.5F);
		this.setHealth(this.getMaxHealth());
	}

    @Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
    	addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(800.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    @Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_IRONGOLEM_HURT;
	}

    @Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRONGOLEM_DEATH;
    }

    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;
	}
}
