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
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityGorgosion extends VetheaMob {

    public EntityGorgosion(World worldIn) {
		super(worldIn);
		this.setSize(2F, 1.6f);
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer closestPlayer = this.world.getClosestPlayerToEntity(this, 10);
        if(closestPlayer != null && !closestPlayer.isCreative() && this.rand.nextInt(30) == 0) {
            this.addVelocity(0, 1, 0);
        }
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
        if(distance > 2) {
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3, false);
            return;
        }
        super.fall(distance, damageMultiplier);
    }

    @Override
    public int getSpawnLayer() {
        return 2;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_GORGOSION;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GORGOSION;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GORGOSION_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GORGOSION_HURT;
    }
}
