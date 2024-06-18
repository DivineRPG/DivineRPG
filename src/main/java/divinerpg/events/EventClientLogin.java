package divinerpg.events;

import divinerpg.capability.ArcanaProvider;
import divinerpg.config.ClientConfig;
import divinerpg.util.*;
import divinerpg.util.packets.PacketArcanaBar;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.network.PacketDistributor;

public class EventClientLogin {
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        Player player = event.getEntity();
        if(!player.level().isClientSide()) {
        	//Weather update
        	if(player instanceof ServerPlayer pl) {
        		DivineRPGPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> pl), Utils.ICEIKA_WEATHER);
        		player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
        			DivineRPGPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> pl), new PacketArcanaBar(arcana));
        		});
        	}
            //Send welcome messages
            if(ClientConfig.welcomeMessage.get()) {
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