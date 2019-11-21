package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
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
import net.minecraft.world.World;

public class Zone extends VetheaMob {

    public Zone(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1.3f);
		this.setHealth(this.getMaxHealth());
	}

    @Override
	protected ResourceLocation getLootTable()
	{
		return DRPGLootTables.ENTITIES_ZONE;
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
        super.onLivingUpdate();

        EntityPlayer player = world.getClosestPlayerToEntity(this, 32);
        if(player != null && !player.isCreative()) {
            this.setAttackTarget(player);

            if(!this.world.isRemote && this.ticksExisted % 40 == 0) {
                this.shootEntity(this.getAttackTarget());
            }
        }
    }

    private void shootEntity(EntityLivingBase e) {
        EntityDivineArrow arrow = new EntityDivineArrow(this.world, ArrowType.KAROS_ARROW, this, e, 1.6f, 12);
        this.world.spawnEntity(arrow);
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
