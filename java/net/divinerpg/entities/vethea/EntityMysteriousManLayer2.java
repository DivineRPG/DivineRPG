package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMysteriousManLayer2 extends EntityGive {

	public EntityMysteriousManLayer2(World par1)  {
		super(par1, VetheaItems.darvenLump, 6);
	}

	public int spawnLayer = 2;

	@Override
	public boolean getCanSpawnHere()  {
		return this.posY < 48.0D * this.spawnLayer  && this.posY > 48.0D * (this.spawnLayer - 1) && super.getCanSpawnHere();
	}

	@Override
	public void Interact(EntityPlayer var1) {
		switch (this.rand.nextInt(4)) {
		case 0:
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: You're progressing, good good."));
			break;
		case 1:
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: Can you hear the screams and roars from above?"));
			break;
		case 2:
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: Everytime you infuse something, the gods become stronger."));
			break;
		case 3:
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: The gods are using your dreams as a battlefield."));
		}
	}

	@Override
	public String mobName() {
		return "Mysterious Man";
	}
}