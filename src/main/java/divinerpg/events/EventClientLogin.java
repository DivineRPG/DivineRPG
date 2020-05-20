package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.api.Reference;
import divinerpg.config.Config;
import divinerpg.config.MainConfig;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.UpdateChecker;
import divinerpg.utils.Utils;
import divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Reference.MODID, value = Side.CLIENT)
public class EventClientLogin {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt) {
        EntityPlayer player = evt.player;

        if (!player.world.isRemote) {
            //Send welcome messages
            if(MainConfig.welcomeMessages) {
                if (Utils.isDeveloperName(player.getUniqueID())) {
                    Logging.message(player, TextFormatting.DARK_RED + LocalizeUtils.normal("Welcome DivineRPG developer! " + player.getName() + " is on the DivineRPG dev team"));
                } else if (Utils.isTesterName(player.getUniqueID())) {
                    Logging.message(player, TextFormatting.BLUE + LocalizeUtils.normal("Welcome DivineRPG tester! " + player.getName() + " kindly offered their time to help test DivineRPG. Thank you for your service!"));
                } else if (Utils.isPatreon(player.getUniqueID())) {
                    Logging.message(player, TextFormatting.YELLOW + LocalizeUtils.normal("Welcome DivineRPG patreon! " + player.getName() + " kindly supported the DivineRPG dev team, thank you for your help!"));
                }
                else {
                    System.out.println("Yes wcmessages is still true");
                    Logging.message(player, "Enjoy your useless welcome message " + player.getName());
                }
            }

            // Update checker
            sendUpdateCheckerMessage(player);
        }
    }

    private void sendUpdateCheckerMessage(EntityPlayer player) {
        if(UpdateChecker.isUpdateAvailable()) {
            Logging.message(player, TextFormatting.LIGHT_PURPLE + LocalizeUtils.normal("DivineRPG is out of date. The latest version is " + UpdateChecker.getUpdateTarget()));
        }
    }
}