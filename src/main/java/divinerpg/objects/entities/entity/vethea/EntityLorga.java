package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.List;
public class EntityLorga extends VetheaMob {
	
    private int spawnTick;
    public boolean canSpawnMinions;
    
    public EntityLorga(World w) {
    	this(w, true);
    }

    public EntityLorga(World var1, boolean canSpawnMinions) {
        super(var1);
        addAttackingAI();
        this.canSpawnMinions = canSpawnMinions;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }
 
    @Override
    public int getSpawnLayer() {
    	return 1;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        List<EntityLorga> nearby = this.world.getEntitiesWithinAABB(EntityLorga.class, this.getEntityBoundingBox().expand(10, 10, 10));
        if (this.spawnTick == 0 && this.canSpawnMinions && !this.world.isRemote && nearby.size() < 12) {
            this.spawnTick = 260;
            EntityLorga var2 = new EntityLorga(this.world, false);
            var2.setLocationAndAngles(this.posX + 1, this.posY, this.posZ + 1, this.rotationYaw, this.rotationPitch);
            this.world.spawnEntity(var2);
        }
        else if (this.spawnTick > 0) {
            this.spawnTick--;
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
    	super.writeToNBT(tag);
    	tag.setBoolean("CanSpawnMinions", this.canSpawnMinions);
		return tag;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
    	super.readFromNBT(tag);
    	this.canSpawnMinions = tag.getBoolean("CanSpawnMinions");
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableRegistry.ENTITIES_LORGA;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LORGA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LORGA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LORGA_HURT;
    }
}
