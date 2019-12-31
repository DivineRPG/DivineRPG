package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;


import divinerpg.api.java.divinerpg.api.Reference;
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
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityBiphron extends VetheaMob {
	
    private boolean gravMove;

    public EntityBiphron(World var1) {
        super(var1);
        addAttackingAI();
        this.setSize(0.4F, 2.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.rand.nextInt(50) == 0) {
            if (!this.gravMove) {
                this.gravMove = true;
            } else {
                this.gravMove = false;
            }
        }

        if (this.gravMove) {
            this.motionY = 0.4;
        }
    }
 
    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    public int getSpawnLayer() {
    	return 2;
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BIPHRON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BIPHRON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BIPHRON_HURT;
    }


}
