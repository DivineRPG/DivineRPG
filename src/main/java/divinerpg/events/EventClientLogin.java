package divinerpg.events;

import divinerpg.config.*;
import divinerpg.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventClientLogin {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt){
        Player player = evt.getEntity();
        if (!player.level().isClientSide) {
            //Send welcome messages
            if(ClientConfig.welcomeMessage.get()) {
                if (Utils.isDeveloperName(player.getUUID())) {
                    MutableComponent message = Component.translatable("message.developer", player.getDisplayName());
                    message.withStyle(ChatFormatting.DARK_RED);
                    player.sendSystemMessage(message);
                } else if (Utils.isTesterName(player.getUUID())) {
                    MutableComponent message = Component.translatable("message.tester", player.getDisplayName());
                    message.withStyle(ChatFormatting.BLUE);
                    player.sendSystemMessage(message);
                } else if (Utils.isSpecial(player.getUUID())) {
                    MutableComponent message = Component.translatable("message.special", player.getDisplayName());
                    message.withStyle(ChatFormatting.GOLD);
                    player.sendSystemMessage(message);
                } else if (Utils.isFriend(player.getUUID())) {
                    MutableComponent message = Component.translatable("message.friend", player.getDisplayName());
                    message.withStyle(ChatFormatting.LIGHT_PURPLE);
                    player.sendSystemMessage(message);
                }
            }
        }
    }

}
