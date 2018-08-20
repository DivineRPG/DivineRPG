package naturix.divinerpg.events;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventArmorSet {
	private Item boots = null;
    private Item body = null;
    private Item legs = null;
    private Item helmet = null;
    private EntityPlayer player;
    
    
    @SubscribeEvent
    public void onJump(LivingJumpEvent evt) {
    	PlayerCapabilities capabilities = player.capabilities;
		
    	if(helmet == ModItems.angelicHelmet && body == ModItems.angelicChestplate && legs == ModItems.angelicLeggings && boots == ModItems.angelicBoots) {
			
			if (capabilities.isCreativeMode) return;
			{
					capabilities.allowFlying = false;
					capabilities.isFlying = false;
					player.sendPlayerAbilities();
				}
			} else {

				if (!capabilities.allowFlying) {
					capabilities.allowFlying = true;
					player.sendPlayerAbilities();
				}
			}
    }
}