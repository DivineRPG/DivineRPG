package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.entities.vanilla.projectile.EntityDivineArrow;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityEternalArcher extends EntityDivineRPGBoss{
	
	private int armSelected;
	private int abilityTick;

	public EntityEternalArcher(World world) {
		super(world);
		this.setSize(5, 5);
		this.addAttackingAI();
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if(this.abilityTick > 0) this.abilityTick--;
		if(this.abilityTick == 0) {
			if(this.armSelected > 5) this.armSelected++;
			else if(this.armSelected == 5) this.armSelected = 0;
			this.abilityTick = 400;
		}
		
		if(this.armSelected == 0 && this.abilityTick%60 == 0 && this.entityToAttack != null) {
			this.worldObj.spawnEntityInWorld(new EntityDivineArrow(this.worldObj, this, (EntityLivingBase)this.entityToAttack, 1.6f, 12, 30, "furyArrow"));
		}
	}
	
	@Override
	public ItemStack getHeldItem() {
		return new ItemStack(TwilightItemsWeapons.haliteBow);
	}

	@Override
	public String name() {
		return "Eternal Archer";
	}

	@Override
	public IChatComponent chat() {
		return null;
	}

	@Override
	public String mobName() {
		return "Eternal Archer";
	}

}