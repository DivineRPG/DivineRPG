package net.divinerpg.api.entity;

import java.util.List;

import net.minecraft.entity.Entity;
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
import net.minecraft.world.World;

public abstract class EntityPeacefullUntillAttacked extends EntityDivineRPGMob {

	public EntityPeacefullUntillAttacked(World w) {
		super(w);
	}

	protected boolean isAIEnabled() {
		return false;
	}

	private int angerLevel = 0;
	public void writeEntityToNBT(NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
		var1.setShort("Anger", (short)this.angerLevel);
	}

	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
		this.angerLevel = var1.getShort("Anger");
	}

	protected Entity findPlayerToAttack() {
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
		if(par1DamageSource.getEntity() instanceof EntityPlayer){
			angerLevel = 400;
			addAttackingAI();
		}
		return super.attackEntityFrom(par1DamageSource, par2);
	}
}