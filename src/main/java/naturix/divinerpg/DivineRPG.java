/**
 * @author NicosaurusRex99
 *
 */
package naturix.divinerpg;

import naturix.divinerpg.client.render.RenderFluids;
import naturix.divinerpg.compat.ProjectECompat;
import naturix.divinerpg.proxy.CommonProxy;
import naturix.divinerpg.registry.ModEvents;
import naturix.divinerpg.registry.ModTriggers;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.handlers.RegistryHandler;
import naturix.divinerpg.utils.log.InitLog;
import naturix.divinerpg.utils.log.IntenseDebug;
import naturix.divinerpg.utils.log.PostInitLog;
import naturix.divinerpg.utils.log.PreInitLog;
import naturix.divinerpg.world.WorldGenCustomOres;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE_URL)
public class DivineRPG {
    @Mod.Instance
    public static DivineRPG instance;

    @SidedProxy(serverSide = "naturix.divinerpg.proxy.CommonProxy", clientSide = "naturix.divinerpg.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    public static SimpleNetworkWrapper network;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ModTriggers.registerTriggers();
        RenderFluids.registerCustomMeshesAndStates();
        InitLog.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        if (Loader.isModLoaded("projecte")) {
            ProjectECompat.init();
        }
        PostInitLog.init();

        if (Config.debug) {
            IntenseDebug.init();
        }
    }

    /** Init Methods */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.preInitRegistries(event);
        logger = event.getModLog();
        proxy.preInit(event);
        proxy.registerTileEntities();
        proxy.RegisterTileEntityRender();
        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 3);
        ModEvents.preInit();
        PreInitLog.init();
    }

    /** For Registering Commands */
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    }
}