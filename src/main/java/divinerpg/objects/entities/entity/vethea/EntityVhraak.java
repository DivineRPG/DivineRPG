package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityVhraak extends VetheaMob {
	
    private int waitTick, lifeTick, spawnTick;

    public EntityVhraak(World var1) {
        super(var1);
        addAttackingAI();
        this.lifeTick = -1;
    }
    
    public EntityVhraak(World var1, int life) {
        this(var1);
        this.lifeTick = life;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(30);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public int getSpawnLayer() {
    	return 4;
    }

    @Override
    protected void updateAITasks() {
        if (this.getAttackTarget() != null && this.getDistance(this.getAttackTarget()) < 0.5) {
            this.waitTick = 30;
        }
        else if (this.waitTick == 0) {
            if (this.spawnTick == 0 && this.lifeTick == -1) {
                EntityVhraak var2 = new EntityVhraak(this.world, 30);
                var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                this.world.spawnEntity(var2);

                var2 = new EntityVhraak(this.world, 30);
                var2.setLocationAndAngles(this.posX - 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
                this.world.spawnEntity(var2);

                var2 = new EntityVhraak(this.world, 30);
                var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                this.world.spawnEntity(var2);

                var2 = new EntityVhraak(this.world, 30);
                var2.setLocationAndAngles(this.posX - 1, this.posY, this.posZ - 1, this.rotationYaw, this.rotationPitch);
                this.world.spawnEntity(var2);
                this.spawnTick = 50;
            }
            else if (this.spawnTick > 0) {
                this.spawnTick--;
            }
            super.updateAITasks();
        } else {
            --this.waitTick;
        }
    }
 
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.lifeTick > 0) 
            this.lifeTick--;
        else if (this.lifeTick == 0 && !this.world.isRemote) 
            this.setDead();
    }
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
	    super.writeToNBT(tag);
	    tag.setInteger("LifeTick", lifeTick);
		return tag;
	}
	
	@Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        lifeTick = tag.getInteger("LifeTick");
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
