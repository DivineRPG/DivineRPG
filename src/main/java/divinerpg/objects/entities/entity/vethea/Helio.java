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

public class Helio extends VetheaMob {

    public Helio(World worldIn) {
        super(worldIn);
        this.setSize(1F, 2f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(140.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40.0D);
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        if(super.attackEntityAsMob(target)) {
            target.addVelocity(MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 7.0F * 0.5F, 0.4D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 7.0F * 0.5F);
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_HELIO;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.HELIO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.HELIO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.HELIO_HURT;
    }
}
