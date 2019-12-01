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
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Cymesoid extends VetheaMob {

    public Cymesoid(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 2f);
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        EntityPlayer var1 = this.world.getClosestPlayerToEntity(this, 64.0D);

        if (var1 == null || var1.isCreative())
            return;
        else {
            Vec3d var3 = var1.getLook(1.0F).normalize();
            Vec3d var4 = new Vec3d(this.posX - var1.posX, this.getEntityBoundingBox().minY + this.height / 2.0F - (var1.posY + var1.getEyeHeight()), this.posZ - var1.posZ);
            double var5 = var4.lengthVector();
            var4 = var4.normalize();
            double var7 = var3.dotProduct(var4);
            if( var7 > 1.0D - 0.025D / var5 && var1.canEntityBeSeen(this)) {
                this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 200, 1));
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_CYMESOID;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CYMESOID;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CYMESOID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CYMESOID_HURT;
    }
}
