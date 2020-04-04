package divinerpg.utils.fakeNetwork;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.*;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;

import java.util.Set;

public class FakeNetHandlerPlayServer extends NetHandlerPlayServer {

    public FakeNetHandlerPlayServer(EntityPlayerMP playerIn) {
        super(getServerFromPlayer(playerIn), new FakeNetworkManager(), playerIn);
    }

    private static MinecraftServer getServerFromPlayer(Entity e) {
        if (e != null && e.world != null) {
            return e.world.getMinecraftServer();
        }

        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void disconnect(ITextComponent textComponent) {

    }

    @Override
    public void func_194308_a(CPacketPlaceRecipe p_194308_1_) {

    }

    @Override
    public void handleAnimation(CPacketAnimation packetIn) {

    }

    @Override
    public void handleRecipeBookUpdate(CPacketRecipeInfo p_191984_1_) {

    }

    @Override
    public void handleResourcePackStatus(CPacketResourcePackStatus packetIn) {

    }

    @Override
    public void handleSeenAdvancements(CPacketSeenAdvancements p_194027_1_) {

    }

    @Override
    public void handleSpectate(CPacketSpectate packetIn) {

    }

    @Override
    public void onDisconnect(ITextComponent reason) {

    }

    @Override
    public void processChatMessage(CPacketChatMessage packetIn) {

    }

    @Override
    public void processClickWindow(CPacketClickWindow packetIn) {

    }

    @Override
    public void processClientSettings(CPacketClientSettings packetIn) {

    }

    @Override
    public void processClientStatus(CPacketClientStatus packetIn) {

    }

    @Override
    public void processCloseWindow(CPacketCloseWindow packetIn) {

    }

    @Override
    public void processConfirmTeleport(CPacketConfirmTeleport packetIn) {

    }

    @Override
    public void processConfirmTransaction(CPacketConfirmTransaction packetIn) {

    }

    @Override
    public void processCreativeInventoryAction(CPacketCreativeInventoryAction packetIn) {

    }

    @Override
    public void processCustomPayload(CPacketCustomPayload packetIn) {

    }

    @Override
    public void processEnchantItem(CPacketEnchantItem packetIn) {
    }

    @Override
    public void processEntityAction(CPacketEntityAction packetIn) {

    }

    @Override
    public void processHeldItemChange(CPacketHeldItemChange packetIn) {

    }

    @Override
    public void processInput(CPacketInput packetIn) {

    }

    @Override
    public void processKeepAlive(CPacketKeepAlive packetIn) {

    }

    @Override
    public void processPlayer(CPacketPlayer packetIn) {

    }

    @Override
    public void processPlayerAbilities(CPacketPlayerAbilities packetIn) {

    }

    @Override
    public void processPlayerDigging(CPacketPlayerDigging packetIn) {

    }

    @Override
    public void processSteerBoat(CPacketSteerBoat packetIn) {

    }

    @Override
    public void processTabComplete(CPacketTabComplete packetIn) {

    }

    @Override
    public void processTryUseItem(CPacketPlayerTryUseItem packetIn) {

    }

    @Override
    public void processTryUseItemOnBlock(CPacketPlayerTryUseItemOnBlock packetIn) {

    }

    @Override
    public void processUpdateSign(CPacketUpdateSign packetIn) {

    }

    @Override
    public void processUseEntity(CPacketUseEntity packetIn) {

    }

    @Override
    public void processVehicleMove(CPacketVehicleMove packetIn) {

    }

    @Override
    public void sendPacket(Packet<?> packetIn) {

    }

    @Override
    public void setPlayerLocation(double x, double y, double z, float yaw, float pitch) {

    }

    @Override
    public void setPlayerLocation(double x, double y, double z, float yaw, float pitch, Set<SPacketPlayerPosLook.EnumFlags> relativeSet) {

    }
}
