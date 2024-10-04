package divinerpg.events;

import divinerpg.attachments.Arcana;
import divinerpg.config.ClientConfig;
import divinerpg.network.payload.*;
import divinerpg.util.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;

public class EventClientLogin {
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        Player player = event.getEntity();
        if(!player.level().isClientSide()) {
        	//Weather update
        	if(player instanceof ServerPlayer pl) PacketDistributor.sendToPlayer(pl, new Weather(Utils.ICEIKA_WEATHER), new MaxArcana(Arcana.getMaxArcana(pl)), new ArcanaAmount(Arcana.getAmount(pl)));
            //Send welcome messages
            if(ClientConfig.WELCOME_MESSAGE) {
                Component message;
                if(Utils.isDeveloperName(player.getUUID())) {
                    message = LocalizeUtils.clientMessage(ChatFormatting.DARK_RED, "player.developer", player.getDisplayName());
                    player.sendSystemMessage(message);
                } else if(Utils.isTesterName(player.getUUID())) {
                    message = LocalizeUtils.clientMessage(ChatFormatting.BLUE, "player.tester", player.getDisplayName());
                    player.sendSystemMessage(message);
                } else if(Utils.isSpecial(player.getUUID())) {
                    message = LocalizeUtils.clientMessage(ChatFormatting.GOLD, "player.special", player.getDisplayName());
                    player.sendSystemMessage(message);
                } else if(Utils.isFriend(player.getUUID())) {
                    message = LocalizeUtils.clientMessage(ChatFormatting.LIGHT_PURPLE, "player.friend", player.getDisplayName());
                    player.sendSystemMessage(message);
                }
            }
        }
    }
}