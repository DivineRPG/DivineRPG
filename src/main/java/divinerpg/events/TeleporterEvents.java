package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModDimensions;
import divinerpg.utils.portals.ITickListener;
import divinerpg.utils.portals.ServerPortal;
import divinerpg.utils.portals.VetheaPortal;
import divinerpg.utils.portals.description.*;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Mod.EventBusSubscriber
public class TeleporterEvents {
    public final static Map<Block, IPortalDescription> descriptionsByBlock = new HashMap<>();
    public final static Map<DimensionType, IPortalDescription> descriptionsByDimension = new HashMap<>();
    private final static Map<DimensionType, ITeleporter> teleporterMapByModdedDimension = new HashMap<>();
    private final static Set<ITickListener> listeners = new HashSet<>();

    /**
     * Should call after ModDimensions.registerDimensions()
     */
    public static void initPortalDescriptions() {
        ServerPortal portal = new ServerPortal(128, 20 * 10);

        add(ModDimensions.edenDimension, new NetherLikePortalDescription(ModBlocks.divineRock, ModBlocks.edenPortal), portal);
        add(ModDimensions.wildWoodDimension, new NetherLikePortalDescription(ModBlocks.edenBlock, ModBlocks.wildwoodPortal), portal);
        add(ModDimensions.apalachiaDimension, new NetherLikePortalDescription(ModBlocks.wildwoodBlock, ModBlocks.apalachiaPortal), portal);
        add(ModDimensions.skythernDimension, new NetherLikePortalDescription(ModBlocks.apalachiaBlock, ModBlocks.skythernPortal), portal);
        add(ModDimensions.mortumDimension, new NetherLikePortalDescription(ModBlocks.skythernBlock, ModBlocks.mortumPortal), portal);
        add(ModDimensions.iceikaDimension, new NetherLikePortalDescription(Blocks.SNOW, ModBlocks.iceikaPortal), portal);

        VetheaPortal vetheaPortal = new VetheaPortal(128, 20 * 60);
        add(ModDimensions.vetheaDimension, new VetheaPortalDescription(), vetheaPortal);

        ArcanaTeleporter teleporter = new ArcanaTeleporter(20 * 60);
        add(ModDimensions.arcanaDimension,
                new ArcanaPortalRoomDescription(ModBlocks.arcanaPortalFrame, ModBlocks.arcanaPortal),
                teleporter);
    }

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

            if (server != null) {
                listeners.forEach(x -> x.tick(server));
            }
        }
    }

    private static void add(DimensionType type, IPortalDescription description, ITeleporter teleporter) {
        descriptionsByBlock.put(description.getFrame(), description);
        descriptionsByDimension.put(type, description);
        teleporterMapByModdedDimension.put(type, teleporter);

        if (teleporter instanceof ITickListener)
            listeners.add(((ITickListener) teleporter));
    }

    /**
     * Transfer entity to another dimension
     *
     * @param e            - any entity
     * @param modDimension - non vanilla dimension!
     */
    public static void transferEntity(Entity e, DimensionType modDimension) {
        if (e == null || modDimension == null)
            return;

        DimensionType current = e.getEntityWorld().provider.getDimensionType();

        ITeleporter teleporter = teleporterMapByModdedDimension.get(current);
        if (teleporter == null) {
            teleporter = teleporterMapByModdedDimension.get(modDimension);
        }

        if (teleporter == null) {
            DivineRPG.logger.warn(String.format("Unknown dimensions: 1) %s/n2)%s", current.getName(), modDimension.getName()));
            return;
        }

        e.changeDimension(modDimension.getId(), teleporter);
    }
}
