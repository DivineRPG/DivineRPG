package net.divinerpg.entities.twilight;

import net.divinerpg.api.entity.EntityDivineRPGBoss;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.minecraft.item.Item;
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
	}
	
	public Item getHeldItem(int arm) {
		switch(arm) {
		case 0:
			return TwilightItemsWeapons.haliteBow;
		case 1:
			return TwilightItemsWeapons.halitePhaser;
		case 2:
			return TwilightItemsWeapons.haliteBlitz;
		case 3:
			return TwilightItemsWeapons.haliteSlicer;
		case 4:
			return null;
		case 5:
			return TwilightItemsWeapons.haliteBlade;
		default:
			return null;
		}
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