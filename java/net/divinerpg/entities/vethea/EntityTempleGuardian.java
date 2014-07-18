package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTempleGuardian extends EntityGive {

	public EntityTempleGuardian(World par1)  {
		super(par1, VetheaItems.cermileLump, 10);
	}

	@Override
	public void Interact(EntityPlayer var1) {
		if(!this.worldObj.isRemote) {
			switch (this.rand.nextInt(5)) {
			case 0:
				Util.addChatMessage("Temple Guardian: You are moving upwards, beware of the imminent danger.");
				break;
			case 1:
				Util.addChatMessage("Temple Guardian: These places aren't for you.");
				break;
			case 2:
				Util.addChatMessage("Temple Guardian: This is dangerous, what are you doing here?");
				break;
			case 3:
				Util.addChatMessage("Temple Guardian: Temples are suited for humans.");
				break;
			case 4:
				Util.addChatMessage("Temple Guardian: They are getting closer to killing you.");
				break;
			}
		}
	}

	@Override
	public String mobName() {
		return "Temple Guardian";
	}
}