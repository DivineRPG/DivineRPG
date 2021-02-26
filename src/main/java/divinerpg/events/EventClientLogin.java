package divinerpg.events;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.server.command.*;

public class EventClientLogin {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt){
        PlayerEntity player = evt.getPlayer();
        if (!player.world.isRemote) {

            //Send welcome messages
            if(Config.welcomeMessage.get()) {
            //TODO - colour
                if (Utils.isDeveloperName(player.getUniqueID())) {
                    TextComponent message = TextComponentHelper.createComponentTranslation(player, "message.developer", player.getDisplayName());
                    message.getStyle().setColor(Color.fromTextFormatting(TextFormatting.DARK_RED));
                    player.sendMessage(message, player.getUniqueID());
                } else if (Utils.isTesterName(player.getUniqueID())) {
                    TextComponent message = TextComponentHelper.createComponentTranslation(player, "message.tester", player.getDisplayName());
                    message.getStyle().setColor(Color.fromTextFormatting(TextFormatting.BLUE));
                    player.sendMessage(message, player.getUniqueID());
                } else if (Utils.isPatreon(player.getUniqueID())) {
                    TextComponent message = TextComponentHelper.createComponentTranslation(player, "message.patreon", player.getDisplayName());
                    message.getStyle().setColor(Color.fromTextFormatting(TextFormatting.GOLD));
                    player.sendMessage(message, player.getUniqueID());
                } else if (Utils.isFriend(player.getUniqueID())) {
                    TextComponent message = TextComponentHelper.createComponentTranslation(player, "message.friend", player.getDisplayName());
                    message.getStyle().setColor(Color.fromTextFormatting(TextFormatting.LIGHT_PURPLE));
                    player.sendMessage(message, player.getUniqueID());
                }
            }
        }
    }

}
