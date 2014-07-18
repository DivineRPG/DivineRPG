package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityGive;
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
		return this.posY < 64.0D * this.spawnLayer  && this.posY > 64.0D * (this.spawnLayer - 1) && super.getCanSpawnHere();
	}

	@Override
	public void Interact(EntityPlayer var1) {
		if (!this.worldObj.isRemote) {
			switch (this.rand.nextInt(4)) {
			case 0:
				Util.addChatMessage("Mysterious Man: You're progressing, good good.");
				break;
			case 1:
				Util.addChatMessage("Mysterious Man: Can you hear the screams and roars from above?");
				break;
			case 2:
				Util.addChatMessage("Mysterious Man: Everytime you infuse something, the gods become stronger.");
				break;
			case 3:
				Util.addChatMessage("Mysterious Man: The gods are using your dreams as a battlefield.");
			}
		}
	}

	@Override
	public String mobName() {
		return "Mysterious Man";
	}
}