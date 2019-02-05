package naturix.divinerpg.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityPeacefulUntilAttacked extends EntityDivineRPGMob {

	public EntityPeacefulUntilAttacked(World w) {
		super(w);
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1F, true));
	}

	public int angerLevel = 0;
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setShort("Anger", (short)this.angerLevel);
	}

	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.angerLevel = tag.getShort("Anger");
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
        Entity entity = source.getTrueSource();
		if(entity instanceof EntityPlayer) this.makeAngryAt((EntityPlayer)entity);
		return super.attackEntityFrom(source, amount);
	}

    public void makeAngryAt(EntityPlayer p) {
	    if(!p.capabilities.isCreativeMode) {
	        angerLevel = 400;
	        this.setAttackTarget(p);
	        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	    }
	}

	@Override
	public boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if(this.angerLevel > 0)return super.attackEntityAsMob(entity);
		return false;
	}
}