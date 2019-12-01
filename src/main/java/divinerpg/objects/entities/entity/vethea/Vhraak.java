package divinerpg.objects.entities.entity.vethea;

import javax.annotation.Nullable;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
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
import net.minecraft.world.World;

public class Vhraak extends VetheaMob {

    private int spawnTick = 80;
    
    public Vhraak(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1f);
	}

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(!world.isRemote) {
            if(this.getAttackTarget() != null) {
                if (this.spawnTick == 0) {
                    FakeVhraak var2 = new FakeVhraak(this.world);
                    var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(var2);

                    var2 = new FakeVhraak(this.world);
                    var2.setLocationAndAngles(this.posX - 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(var2);

                    var2 = new FakeVhraak(this.world);
                    var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(var2);

                    var2 = new FakeVhraak(this.world);
                    var2.setLocationAndAngles(this.posX - 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                    this.world.spawnEntity(var2);
                    this.spawnTick = 80;
                }
                else {
                    this.spawnTick--;
                }
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_VHRAAK;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.VHRAAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.VHRAAK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.VHRAAK_HURT;
    }
}
