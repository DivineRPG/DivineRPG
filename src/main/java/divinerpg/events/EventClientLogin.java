package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.config.GeneralConfig;
import divinerpg.utils.MessageUtils;
import divinerpg.utils.UpdateChecker;
import divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, value = Side.CLIENT)
public class EventClientLogin {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt) {
        EntityPlayer player = evt.player;

        if (!player.world.isRemote) {
            //Send welcome messages
            if(GeneralConfig.generalOptions.welcomeMessages) {
                if (Utils.isDeveloperName(player.getUniqueID())) {
                    MessageUtils.sendMessageToPlayer(player, "Welcome DivineRPG developer " + player.getName() + "!", TextFormatting.DARK_RED);
                } else if (Utils.isTesterName(player.getUniqueID())) {
                    MessageUtils.sendMessageToPlayer(player, "Welcome DivineRPG tester " + player.getName() + "!", TextFormatting.DARK_BLUE);
                } else if (Utils.isPatreon(player.getUniqueID())) {
                    MessageUtils.sendMessageToPlayer(player, "Welcome DivineRPG donator " + player.getName() + "!", TextFormatting.YELLOW);
                }
            }

            // Update checker
            sendUpdateCheckerMessage(player);
        }
    }

    private void sendUpdateCheckerMessage(EntityPlayer player) {
        if(UpdateChecker.isUpdateAvailable()) {
            MessageUtils.sendMessageToPlayer(player, "DivineRPG is out of date. The latest version is " + UpdateChecker.getUpdateTarget(), TextFormatting.RED);
        }
    }
}