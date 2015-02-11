package net.divinerpg.api.entity;

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
		this.tasks.addTask(5, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0F, false));
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
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
		if(source.getEntity() instanceof EntityPlayer){
			angerLevel = 400;
			if(source.getEntity() instanceof EntityPlayer && !((EntityPlayer)source.getEntity()).capabilities.isCreativeMode) {
				this.entityToAttack = source.getEntity();
				this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
			}
		}
		return super.attackEntityFrom(source, par2);
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) && this.worldObj.checkNoEntityCollision(this.boundingBox) && (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()) && (!this.worldObj.isAnyLiquid(this.boundingBox));
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