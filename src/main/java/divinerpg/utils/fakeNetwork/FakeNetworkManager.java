package divinerpg.utils.fakeNetwork;

import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetworkManager;

public class FakeNetworkManager extends NetworkManager {

    public FakeNetworkManager() {
        super(EnumPacketDirection.CLIENTBOUND);
    }

    @Override
    public void setNetHandler(INetHandler handler) {

    }
}
