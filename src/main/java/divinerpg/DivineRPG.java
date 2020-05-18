/**
 * @author NicosaurusRex99
 */
package divinerpg;

import divinerpg.events.enchants.WorldBreakEnchantHandler;
import divinerpg.utils.UpdateChecker;
import net.minecraftforge.common.ForgeVersion;
import org.apache.logging.log4j.LogManager;

import divinerpg.api.Reference;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.events.*;
import divinerpg.proxy.CommonProxy;
import divinerpg.registry.*;
import divinerpg.utils.Utils;
import divinerpg.utils.attributes.AttributeFixer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
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
        MinecraftForge.EVENT_BUS.register(new WorldBreakEnchantHandler());
        ModMessages.initMessages();
        AttributeFixer.patchMaximumHealth();
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
        DimensionHelper.initPortalDescriptions();

        UpdateChecker.checkForUpdates();
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