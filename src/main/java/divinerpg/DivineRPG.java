/**
 * @author NicosaurusRex99
 */
package divinerpg;

import org.apache.logging.log4j.LogManager;

import divinerpg.api.Reference;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.events.*;
import divinerpg.events.enchants.DiggingTaskFactory;
import divinerpg.proxy.CommonProxy;
import divinerpg.registry.*;
import divinerpg.utils.Utils;
import divinerpg.utils.attributes.AttributeFixer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.registries.RegistryBuilder;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE_URL, dependencies = "required:forge@[14.23.5.2768,)")
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

    public DivineRPG() {
        MinecraftForge.EVENT_BUS.register(this);
        logger = LogManager.getLogger();
    }

    /** Init Methods */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        ModLiquids.registerFluids();
        proxy.preInit(event);
        proxy.registerTileEntities();
        MinecraftForge.EVENT_BUS.register(new ArcanaTickHandler());
        MinecraftForge.EVENT_BUS.register(new EventEntityDrop());
        ModMessages.initMessages();
        AttributeFixer.init();
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
            divinerpg.compat.ProjectECompat.init();
        }
        ModSpawns.initSpawns();
        Utils.loadHatInformation();

        MinecraftForge.EVENT_BUS.register(new DiggingTaskFactory());
        DimensionHelper.initPortalDescriptions();
    }

    /** For Registering Commands */
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {

    }

    /**
     * Creating new registry here
     */
    @SubscribeEvent
    public void createRegistries(RegistryEvent.NewRegistry event) {
        logger.info("Creating registries");

//        new RegistryBuilder<IPoweredArmor>()
//                .setName(new ResourceLocation(Reference.MODID, "powers"))
//                .setType(IPoweredArmor.class)
//                .create();

        new RegistryBuilder<IArmorDescription>()
                .setName(new ResourceLocation(Reference.MODID, "armor_descriptions"))
                .setType(IArmorDescription.class)
                .create();
    }

}