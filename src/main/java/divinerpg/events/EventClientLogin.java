package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.config.GeneralConfig;
import divinerpg.utils.UpdateChecker;
import divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.server.command.TextComponentHelper;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, value = Side.CLIENT)
public class EventClientLogin {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt) {
        EntityPlayer player = evt.player;

        if (!player.world.isRemote) {
            //Send welcome messages
            if(GeneralConfig.generalOptions.enableWelcomeMessages) {
                if (Utils.isDeveloperName(player.getUniqueID())) {
                    TextComponentBase message = TextComponentHelper.createComponentTranslation(player, "message.developer", player.getDisplayName());
                    message.getStyle().setColor(TextFormatting.DARK_RED);
                    player.sendMessage(message);
                } else if (Utils.isTesterName(player.getUniqueID())) {
                    TextComponentBase message = TextComponentHelper.createComponentTranslation(player, "message.tester", player.getDisplayName());
                    message.getStyle().setColor(TextFormatting.DARK_BLUE);
                    player.sendMessage(message);
                } else if (Utils.isPatreon(player.getUniqueID())) {
                    TextComponentBase message = TextComponentHelper.createComponentTranslation(player, "message.patreon", player.getDisplayName());
                    message.getStyle().setColor(TextFormatting.YELLOW);
                    player.sendMessage(message);
                } else if (Utils.isFriend(player.getUniqueID())) {
                    TextComponentBase message = TextComponentHelper.createComponentTranslation(player, "message.friend", player.getDisplayName());
                    message.getStyle().setColor(TextFormatting.Gray);
                    player.sendMessage(message);
                }
            }

            // Update checker
            sendUpdateCheckerMessage(player);
        }
    }

    private void sendUpdateCheckerMessage(EntityPlayer player) {
        if(UpdateChecker.isUpdateAvailable()) {
            TextComponentBase message = TextComponentHelper.createComponentTranslation(player, "message.version", UpdateChecker.getUpdateTarget());
            message.getStyle().setColor(TextFormatting.RED);
            player.sendMessage(message);
        }
    }
}
