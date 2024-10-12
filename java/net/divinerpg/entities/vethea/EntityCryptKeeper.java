package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.divinerpg.utils.MessageLocalizer;

public class EntityCryptKeeper extends EntityGive {

	public EntityCryptKeeper(World par1) {
		super(par1, VetheaItems.amthirmisLump, 5);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.cryptKeeperHealth);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.cryptKeeperSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.cryptKeeperFollowRange);
	}

	@Override
	public void Interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			switch (this.rand.nextInt(5)) {
			case 0:
				var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.cryptkeeper.1")));
				break;
			case 1:
				var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.cryptkeeper.2")));
				break;
			case 2:
				var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.cryptkeeper.3")));
				break;
			case 3:
				var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.cryptkeeper.4")));
				break;
			case 4:
				var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.cryptkeeper.5")));
				break;
			}
		}
	}
	
	@Override
	public boolean canDespawn() {
	    return false;
	}

	@Override
	public String mobName() {
		return "Crypt Keeper";
	}
}
