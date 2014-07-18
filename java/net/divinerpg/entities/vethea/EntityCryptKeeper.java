package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityCryptKeeper extends EntityGive {

	public EntityCryptKeeper(World par1) {
		super(par1, VetheaItems.amthrimisLump, 5);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.cryptKeeperHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.cryptKeeperSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.cryptKeeperFollowRange);
	}

	@Override
	public void Interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			switch (this.rand.nextInt(5)) {
			case 0:
				Util.addChatMessage("Crypt Keeper: You're safer down here.");
				break;
			case 1:
				Util.addChatMessage("Crypt Keeper: Beware of the higher layers.");
				break;
			case 2:
				Util.addChatMessage("Crypt Keeper: Take this reward, use it wisely.");
				break;
			case 3:
				Util.addChatMessage("Crypt Keeper: What the future holds is dark.");
				break;
			case 4:
				Util.addChatMessage("Crypt Keeper: This isn't a nice world.");
				break;
			}
		}
	}

	@Override
	public String mobName() {
		return "Crypt Keeper";
	}
}