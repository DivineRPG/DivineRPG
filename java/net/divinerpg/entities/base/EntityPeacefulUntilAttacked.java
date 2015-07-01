package net.divinerpg.entities.base;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityPeacefulUntilAttacked extends EntityDivineRPGMob {

	public EntityPeacefulUntilAttacked(World w) {
		super(w);
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1F, false));
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
	protected Entity findPlayerToAttack() {
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float par2) {
		if(source.getEntity() instanceof EntityPlayer) this.makeAngryAt((EntityPlayer)source.getEntity());
		return super.attackEntityFrom(source, par2);
	}
	
	public void makeAngryAt(EntityPlayer p) {
	    if(!p.capabilities.isCreativeMode) {
	        angerLevel = 400;
	        this.entityToAttack = p;
            this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
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