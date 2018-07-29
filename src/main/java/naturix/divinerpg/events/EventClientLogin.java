package naturix.divinerpg.events;

import java.io.IOException;

import naturix.divinerpg.utils.Config;
import naturix.divinerpg.utils.MessageLocalizer;
import naturix.divinerpg.utils.UpdateChecker;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventClientLogin {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt) {
        EntityPlayer p = evt.player;
        if (!p.world.isRemote) {
            if (Config.UpdateChecker) {
                if (!UpdateChecker.isOnline() && !Config.canShowOverlay) {
                    p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.version.internet", Utils.LIGHT_PURPLE)));
                } else if (UpdateChecker.isOnline() && UpdateChecker.isUpdateAvailable() && !Config.canShowOverlay) {
                    p.sendMessage(Utils.getChatComponent("message.version.update", Utils.RED));
                    try {
                        p.sendMessage(Utils.getChatComponent(MessageLocalizer.version(UpdateChecker.getCurrentVersion())));
                    } catch (IOException e) {
                        p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.version.unable", Utils.RED)));
                    }
                }

            }
            if (Utils.isDeveloperName(p.getCommandSenderEntity().getDisplayName())) {
                p.sendMessage(Utils.getChatComponent(MessageLocalizer.normal("message.developer")));
            } else {
                p.sendMessage(Utils.addChatMessage(p.getDisplayName()));
            }
        }
    }  
}