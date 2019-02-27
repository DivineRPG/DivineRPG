/**
 *
 */
/**
 * @author NicosaurusRex99
 *
 */
package naturix.divinerpg;

import naturix.divinerpg.compat.ProjectECompat;
import naturix.divinerpg.proxy.CommonProxy;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModEvents;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModTriggers;
import naturix.divinerpg.utils.ModFurnaceRecipes;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.handlers.RegistryHandler;
import naturix.divinerpg.utils.log.InitLog;
import naturix.divinerpg.utils.log.IntenseDebug;
import naturix.divinerpg.utils.log.PostInitLog;
import naturix.divinerpg.utils.log.PreInitLog;
import naturix.divinerpg.world.WorldGenCustomOres;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE_URL)
public class DivineRPG {
    @Mod.Instance
    public static DivineRPG instance;

    @SidedProxy(serverSide = "naturix.divinerpg.proxy.CommonProxy", clientSide = "naturix.divinerpg.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static org.apache.logging.log4j.Logger logger;

    public static SimpleNetworkWrapper network;

    /* Creative Tabs */
    public static final CreativeTabs BlocksTab = new CreativeTabs("Blocks") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.oreArlemite);
        }
    };
    public static final CreativeTabs ItemsTab = new CreativeTabs("Item") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.ingotArlemite);
        }
    };
    public static final CreativeTabs CombatTab = new CreativeTabs("Combat") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.arlemiteStabber);
        }
    };
    public static final CreativeTabs ArmorTab = new CreativeTabs("Armor") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.divineHelmet);
        }
    };
    public static final CreativeTabs ToolsTab = new CreativeTabs("Tools") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.arlemiteShickaxe);
        }
    };
    public static final CreativeTabs TrophyTab = new CreativeTabs("Trophy") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.watcherStatue);
        }
    };

    /** Init Methods */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        proxy.registerTileEntities();
        proxy.RegisterTileEntityRender();
        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 3);
        ModEvents.preInit();
        PreInitLog.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ModTriggers.registerTriggers();
        InitLog.init();
        RegistryHandler.otherRegistries();
        ModFurnaceRecipes.registerFurnaceRecipies();
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

    /** For Registering Commands */
    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    }

    public DivineRPG() {
        FluidRegistry.enableUniversalBucket();
    }
}