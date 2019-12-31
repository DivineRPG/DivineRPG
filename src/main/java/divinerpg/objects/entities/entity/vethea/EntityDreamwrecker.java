package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
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
import net.minecraft.world.World;

public class EntityDreamwrecker extends VetheaMob {

    public EntityDreamwrecker(World worldIn) {
		super(worldIn);
		this.setSize(1F, 4.4f);
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer var1 = this.world.getClosestPlayerToEntity(this, 64.0D);

        if(var1 != null && !var1.isCreative() && var1.getDistance(this) < 20) {
            this.setAttackTarget(var1);
        }

        Entity attackTarget = this.getAttackTarget();
        if(attackTarget != null && attackTarget instanceof EntityPlayer && !((EntityPlayer)attackTarget).isCreative() && !attackTarget.isDead && this.canEntityBeSeen(attackTarget)) {
            attackTarget.addVelocity(Math.signum(this.posX - attackTarget.posX) * 0.029, 0, Math.signum(this.posZ - attackTarget.posZ) * 0.029);
        }
        else {
            this.setAttackTarget(null);
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_DREAMWRECKER;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DREAMWRECKER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DREAMWRECKER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DREAMWRECKER_HURT;
    }
}
