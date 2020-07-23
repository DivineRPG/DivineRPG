package divinerpg.utils;

import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class MessageUtils {
    public static void sendMessageToPlayer(EntityPlayer player, String message, TextFormatting color) {
        player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(color)));
    }
}
