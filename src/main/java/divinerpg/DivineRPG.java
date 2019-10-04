/**
 * @author NicosaurusRex99
 *
 */
package divinerpg;

import divinerpg.api.Reference;
import divinerpg.compat.ProjectECompat;
import divinerpg.config.Config;
import divinerpg.events.ArcanaTickHandler;
import divinerpg.events.EventEntityDrop;
import divinerpg.proxy.CommonProxy;
import divinerpg.registry.*;
import divinerpg.utils.Utils;
import divinerpg.world.WorldGenCustomOres;
import net.minecraftforge.common.MinecraftForge;
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

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE_URL, dependencies="required:forge@[14.23.5.2768,)")
public class DivineRPG {
    @Mod.Instance
    public static DivineRPG instance;

    @SidedProxy(serverSide = "divinerpg.proxy.CommonProxy", clientSide = "divinerpg.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    public static SimpleNetworkWrapper network = new SimpleNetworkWrapper(Reference.MODID);

    static {
        FluidRegistry.enableUniversalBucket();
    }

    /** Init Methods */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        ModLiquids.registerFluids();
        proxy.preInit(event);
        proxy.registerTileEntities();
        proxy.RegisterTileEntityRender();

        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 3);
        MinecraftForge.EVENT_BUS.register(new ArcanaTickHandler());
        ModArmorEvents.init();

        MinecraftForge.EVENT_BUS.register(new EventEntityDrop());
        ModMessages.initServer();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ModOreDict.init();
        ModTriggers.registerTriggers();
        ModSmelting.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        if (Loader.isModLoaded("projecte")) {
            ProjectECompat.init();
        }
    }

    /** For Registering Commands */
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        Utils.addDevsToList();
    }

}