package net.divinerpg.entities.vanilla;

import java.util.List;

import net.divinerpg.api.entity.EntityDivineRPGMob;
import net.divinerpg.api.entity.EntityPeacefullUntillAttacked;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWhale extends EntityPeacefullUntillAttacked {

	public EntityWhale(World var1) {
		super(var1);
		this.setSize(2.0F, 3.0F);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.whaleHealth);
	    this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.api.entity.EntityStats.whaleDamage);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.whaleSpeed);
	    this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.whaleFollowRange);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	protected String getLivingSound() {
		return Sounds.getSoundName(Sounds.whale);
	}

	@Override
	protected String getHurtSound() {
		return Sounds.getSoundName(Sounds.whaleHurt);
	}

	@Override
	protected String getDeathSound() {
		return Sounds.getSoundName(Sounds.whaleHurt);
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	protected void dropFewItems(boolean var1, int var2) {
		int var3 = this.rand.nextInt(3 + var2) + 1;

		for (int var4 = 0; var4 < var3; ++var4) {
			this.entityDropItem(new ItemStack(VanillaItemsOther.whaleFin), 0.0F);
		}
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if(isInWater()) this.setAir(300);
		else this.setAir(0);
			
	}

	@Override
	public boolean isInWater() {
		return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
	}

	@Override
	protected void fall(float var1) {}

	@Override
	public String mobName() {
		return "Whale";
	}
}