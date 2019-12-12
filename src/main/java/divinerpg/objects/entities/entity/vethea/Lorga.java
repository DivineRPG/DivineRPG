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

import java.util.List;

public class Lorga extends VetheaMob {

    private int spawnTick;
    private boolean canSpawnMinions;

    public Lorga(World worldIn) {
		this(worldIn, false); //lorgas sterile for now
	}

	private Lorga(World worldIn, boolean canSpawnMinions) {
        super(worldIn);
        this.setSize(1F, 2.4f);
        this.canSpawnMinions = canSpawnMinions;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        List<Lorga> nearby = this.world.getEntitiesWithinAABB(Lorga.class, this.getEntityBoundingBox().expand(10, 10, 10));
        if(!this.canSpawnMinions) {
            return;
        }
        else {
            if (!this.world.isRemote && this.spawnTick == 0 && nearby.size() < 12) {
                this.spawnTick = 260;
                Lorga var2 = new Lorga(this.world, false);
                var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                this.world.spawnEntity(var2);
            }
            else if (this.spawnTick > 0) {
                this.spawnTick--;
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
        return DRPGLootTables.ENTITIES_LORGA;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.LORGA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.LORGA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.LORGA_HURT;
    }
}
