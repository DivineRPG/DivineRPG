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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityTocaxin extends VetheaMob {

    private int hurtTimer;

    public EntityTocaxin(World worldIn) {
		super(worldIn);
		this.setSize(1F, 3.3f);
		this.hurtTimer = 10;
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(65.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityLivingBase var1 = this.getAttackTarget();
        if(var1 != null) {
            if(this.getDistance(var1) > 8 || this.hurtTimer != 0) {
                this.hurtTimer--;
            }
            else {
                this.hurtTimer = 10;
                var1.attackEntityFrom(DamageSource.causeMobDamage(this), (int) (8 - this.getDistance(var1)));
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_TOCAXIN;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.TOCAXIN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.TOCAXIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.TOCAXIN_HURT;
    }
}
