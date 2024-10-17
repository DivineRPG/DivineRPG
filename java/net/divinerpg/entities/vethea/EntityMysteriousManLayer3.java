package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.divinerpg.utils.MessageLocalizer;

public class EntityMysteriousManLayer3 extends EntityGive {

	public EntityMysteriousManLayer3(World par1) {
		super(par1, VetheaItems.pardimalLump, 10);
	}

	public int spawnLayer = 3;

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 48.0D * this.spawnLayer  && this.posY > 48.0D * (this.spawnLayer - 1) && super.getCanSpawnHere();
	}

	@Override
	public void Interact(EntityPlayer var1) {
		switch (this.rand.nextInt(4)) {
		case 0:
			var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.mysteriousman3.1")));
			break;
		case 1:
			var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.mysteriousman3.2")));
			break;
		case 2:
			var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.mysteriousman3.3")));
			break;
		case 3:
			var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.mysteriousman3.4")));
			break;
		}
	}

	@Override
	public String mobName() {
		return "Mysterious Man";
	}
}
