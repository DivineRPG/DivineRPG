package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;

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

public class EntityGalroid extends VetheaMob {

    private int protectionTimer;

    public EntityGalroid(World worldIn) {
        super(worldIn);
        this.setSize(1F, 3f);
        this.protectionTimer = 200;
        this.addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(25.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.getProtectionTimer() <= 0 && !this.getIsInvulnerable()) {
            this.setProtectionTimer(200);
            this.setEntityInvulnerable(true);
        }
        else if (this.getIsInvulnerable() && this.getProtectionTimer() <= 0) {
            this.setProtectionTimer(200);
            this.setEntityInvulnerable(false);
        }
        this.setProtectionTimer(this.getProtectionTimer()-1);
    }

    private int getProtectionTimer() {
        return this.protectionTimer;
    }

    private void setProtectionTimer(int value) {
        this.protectionTimer = value;
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_GALROID;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GALROID;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.GALROID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.GALROID_HURT;
    }
}