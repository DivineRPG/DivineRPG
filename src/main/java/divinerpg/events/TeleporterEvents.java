package divinerpg.events;

import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModDimensions;
import divinerpg.utils.portals.ServerPortal;
import divinerpg.utils.portals.description.IPortalDescription;
import divinerpg.utils.portals.description.NetherLikePortalDescription;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class TeleporterEvents {
    public final static Map<Block, IPortalDescription> descriptionsByBlock = new HashMap<>();
    public final static Map<DimensionType, IPortalDescription> descriptionsByDimension = new HashMap<>();
    private final static ServerPortal portal = new ServerPortal(32, 20 * 10);

    /**
     * Should call after ModDimensions.registerDimensions()
     */
    public static void initPortalDescriptions() {
        add(ModDimensions.edenDimension, new NetherLikePortalDescription(ModBlocks.divineRock, ModBlocks.edenPortal));
        add(ModDimensions.wildWoodDimension, new NetherLikePortalDescription(ModBlocks.edenBlock, ModBlocks.wildwoodPortal));
        add(ModDimensions.apalachiaDimension, new NetherLikePortalDescription(ModBlocks.wildwoodBlock, ModBlocks.apalachiaPortal));
        add(ModDimensions.skythernDimension, new NetherLikePortalDescription(ModBlocks.apalachiaBlock, ModBlocks.skythernPortal));
        add(ModDimensions.mortumDimension, new NetherLikePortalDescription(ModBlocks.skythernBlock, ModBlocks.mortumPortal));
        add(ModDimensions.iceikaDimension, new NetherLikePortalDescription(Blocks.SNOW, ModBlocks.iceikaPortal));
    }

    private static void add(DimensionType type, IPortalDescription description) {
        descriptionsByBlock.put(description.getFrame(), description);
        descriptionsByDimension.put(type, description);
    }

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent e) {
        if (e.phase == TickEvent.Phase.END) {
            portal.recheckPortals(FMLCommonHandler.instance().getMinecraftServerInstance());
        }
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

        // unknown dimension
        if (!descriptionsByDimension.containsKey(modDimension) && !descriptionsByDimension.containsKey(e.getEntityWorld().provider.getDimensionType()))
            return;

        e.changeDimension(modDimension.getId(), portal);
    }
}
