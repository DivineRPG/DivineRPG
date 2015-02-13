package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

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
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: Infuse this, I can feel the stength when you do."));
			break;
		case 1:
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: Thank you for aiding me in my plan."));
			break;
		case 2:
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: The surface is just above us."));
			break;
		case 3:
			var1.addChatMessage(Util.getChatComponent("Mysterious Man: Can you believe that we're submerged so far?"));
			break;
		}
	}

	@Override
	public String mobName() {
		return "Mysterious Man";
	}
}