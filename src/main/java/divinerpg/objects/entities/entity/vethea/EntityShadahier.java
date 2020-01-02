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
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityShadahier extends VetheaMob {

    public EntityShadahier(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 1.3f);
		addAttackingAI();
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(.28);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
     }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        if(super.attackEntityAsMob(target)) {
            if(!this.world.isRemote && target instanceof EntityLivingBase) {
                ((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 1, 1));
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_SHADAHIER;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SHADAHIER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SHADAHIER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SHADAHIER_HURT;
    }

}
