/**
 * @author NicosaurusRex99
 *
 */
package divinerpg;

import divinerpg.client.render.RenderFluids;
import divinerpg.compat.ProjectECompat;
import divinerpg.events.ArcanaTickHandler;
import divinerpg.events.EventArmorSet;
import divinerpg.events.EventArmorTick;
import divinerpg.proxy.CommonProxy;
import divinerpg.registry.ModMessages;
import divinerpg.registry.ModOreDict;
import divinerpg.registry.ModSmelting;
import divinerpg.registry.ModTriggers;
import divinerpg.utils.Reference;
import divinerpg.utils.Utils;
import divinerpg.utils.handlers.RegistryHandler;
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

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE_URL)
public class DivineRPG {
    @Mod.Instance
    public static DivineRPG instance;

    @SidedProxy(serverSide = "naturix.divinerpg.proxy.CommonProxy", clientSide = "naturix.divinerpg.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    public static SimpleNetworkWrapper network = new SimpleNetworkWrapper(Reference.MODID);

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ModOreDict.init();
        ModTriggers.registerTriggers();
        RenderFluids.registerCustomMeshesAndStates();

        // 1.12.2 only
        if (!Config.genJSON) {
            ModSmelting.init();
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        if (Loader.isModLoaded("projecte")) {
            ProjectECompat.init();
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
        MinecraftForge.EVENT_BUS.register(new EventArmorSet());
        MinecraftForge.EVENT_BUS.register(new EventArmorTick());
        MinecraftForge.EVENT_BUS.register(new ArcanaTickHandler());

        ModMessages.initServer();
    }

    /** For Registering Commands */
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    	Utils.addDevsToList();
    }
    
}