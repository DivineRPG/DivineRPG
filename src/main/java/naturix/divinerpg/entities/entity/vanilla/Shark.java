package naturix.divinerpg.entities.entity.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.EntityDivineRPGSwimming;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearest;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Shark extends EntityDivineRPGSwimming {
    public static final ResourceLocation LOOT = new ResourceLocation(DivineRPG.modId, "entities/shark");

    public Shark(World worldIn) {
		super(worldIn);
		this.setSize(1.4F, 0.6f);
		this.setHealth(this.getMaxHealth());
	}

    @Override
	protected ResourceLocation getLootTable()
	{
		return this.LOOT;
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SHARK;
    }
    
    @Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return ModSounds.SHARK_HURT;
	}

    @Override
	protected SoundEvent getDeathSound() {
		return ModSounds.SHARK_HURT;
    }
}
