package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.divinerpg.utils.MessageLocalizer;

public class EntityMysteriousManLayer1 extends EntityGive {

	public EntityMysteriousManLayer1(World par1)  {
		super(par1, VetheaItems.teakerLump, 3);
	}

	public int spawnLayer = 1;

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 48.0D * this.spawnLayer  && this.posY > 48.0D * (this.spawnLayer - 1) && super.getCanSpawnHere();
	}

	@Override
	public void Interact(EntityPlayer var1) {
		switch (this.rand.nextInt(3)){
		case 0:
			var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.mysteriousman1.1")));
			break;
		case 1:
			var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.mysteriousman1.2")));
			break;
		case 2:
			var1.addChatMessage(Util.getChatComponent(MessageLocalizer.normal("message.mysteriousman1.3")));
			break;
		}
	}

	@Override
	public String mobName() {
		return "Mysterious Man";
	}
}
