package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.objects.entities.entity.projectiles.EntityMandragoraProjectile;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
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
import net.minecraft.world.World;

public class Mandragora extends VetheaMob {

    public Mandragora(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 3f);
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer target = this.world.getClosestPlayerToEntity(this, 16);
        if(!world.isRemote && target != null && !target.isCreative() && this.ticksExisted % 20 == 0) {
            attackEntity(target);
        }
    }

    private void attackEntity(EntityLivingBase e) {
        double tx = e.posX - this.posX;
        double ty = e.getEntityBoundingBox().minY - this.posY;
        double tz = e.posZ - this.posZ;
        EntityMandragoraProjectile p = new EntityMandragoraProjectile(this.world, this);
        p.shoot(tx, ty, tz, 1.3f, 15);
        this.playSound(ModSounds.MANDRAGORA, 2.0F, 2.0F);
        if(!world.isRemote)this.world.spawnEntity(p);
    }

    @Override
    public int getSpawnLayer() {
        return 2;
    }
    
    @Override
	protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_MANDRAGORA;
    }    
    
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.MANDRAGORA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.MANDRAGORA;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.MANDRAGORA;
    }

    

}
