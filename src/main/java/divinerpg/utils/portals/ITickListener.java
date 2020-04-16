package divinerpg.utils.portals;

import net.minecraft.server.MinecraftServer;

public interface ITickListener {

    /**
     * Performs tick operation
     */
    void tick(MinecraftServer server);
}
