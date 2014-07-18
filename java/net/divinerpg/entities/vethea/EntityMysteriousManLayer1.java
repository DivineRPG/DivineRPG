package net.divinerpg.entities.vethea;

import net.divinerpg.api.entity.EntityGive;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMysteriousManLayer1 extends EntityGive {

	public EntityMysteriousManLayer1(World par1)  {
		super(par1, VetheaItems.teakerLump, 3);
	}

	public int spawnLayer = 1;

	@Override
	public boolean getCanSpawnHere() {
		return this.posY < 64.0D * this.spawnLayer  && this.posY > 64.0D * (this.spawnLayer - 1) && super.getCanSpawnHere();
	}

	@Override
	public void Interact(EntityPlayer var1) {
		if (!this.worldObj.isRemote) {
			switch (this.rand.nextInt(3)){
			case 0:
				Util.addChatMessage("Mysterious Man: You look new around here. Be careful.");
				break;
			case 1:
				Util.addChatMessage("Mysterious Man: Take these, use them at an infusion table.");
				break;
			case 2:
				Util.addChatMessage("Mysterious Man: Don't tell anybody you saw me.");
				break;
			}
		}
	}

	@Override
	public String mobName() {
		return "Mysterious Man";
	}
}