package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityGive;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTempleGuardian extends EntityGive {
	
	private static final String[] MESSAGE = {"message.guardian.up", "message.guardian.places", "message.guardian.doing", "message.guardian.temples", "message.guardian.closer"};

	public EntityTempleGuardian(World par1)  {
		super(par1, VetheaItems.cermileLump, 10);
	}

	@Override
	public void Interact(EntityPlayer p) {
		p.addChatMessage(Util.getChatComponent("Temple Guardian: " + MessageLocalizer.normal(MESSAGE[rand.nextInt(5)])));
	}
	

    @Override
    public boolean canDespawn() {
        return false;
    }

	@Override
	public String mobName() {
		return "Temple Guardian";
	}
}