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
import naturix.divinerpg.registry.ModBiomes;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModEvents;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModRecipes;
import naturix.divinerpg.registry.ModSeeds;
import naturix.divinerpg.registry.ModSpawns;
import naturix.divinerpg.utils.log.InitLog;
import naturix.divinerpg.utils.log.PostInitLog;
import naturix.divinerpg.utils.log.PreInitLog;
import naturix.divinerpg.world.ModWorldGen;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = DivineRPG.modId, name = DivineRPG.name, version = DivineRPG.version, updateJSON = DivineRPG.UPDATE_URL)
public class DivineRPG {

	public static final String modId = "divinerpg";
	public static final String name = "Divine RPG";
	public static final String version = "1.12.2.0";
	public static final String UPDATE_URL = "https://raw.githubusercontent.com/NicosaurusRex99/DivineRPG/1.12.2/divinerpg_update.json";
	
	@SidedProxy(serverSide = "naturix.divinerpg.proxy.ServerProxy", clientSide = "naturix.divinerpg.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance(modId)
	public static DivineRPG instance;
	public static org.apache.logging.log4j.Logger logger;

	 @Mod.EventHandler
	    public void preInit(FMLPreInitializationEvent event) {
	        logger = event.getModLog();
	        proxy.preInit(event);
	        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
	        ModSeeds.init();
	        ModEvents.preInit();
	        PreInitLog.init();
	        
	    }

	    @Mod.EventHandler
	    public void init(FMLInitializationEvent e) {
	        proxy.init(e);

	        InitLog.init();
	    }

	    @Mod.EventHandler
	    public void postInit(FMLPostInitializationEvent e) {
	        proxy.postInit(e);
	        if(Loader.isModLoaded("projecte")) {ProjectECompat.init();}
	        PostInitLog.init();
	    }
	    @Mod.EventBusSubscriber
		public static class RegistrationHandler {
		
			@SubscribeEvent
			public static void registerItems(RegistryEvent.Register<Item> event) {
				ModItems.register(event.getRegistry());
				ModBlocks.registerItemBlocks(event.getRegistry());
				ModRecipes.init();
			}
			@SubscribeEvent
			public static void registerItems(ModelRegistryEvent event) {
				ModItems.registerModels();
				ModBlocks.registerModels();	
			}
			@SubscribeEvent
	    	public static void registerBlocks(RegistryEvent.Register<Block> event) {
	    		ModBlocks.register(event.getRegistry());
	    	}
			@SubscribeEvent
			public static void onLivingSpawn(LivingSpawnEvent event) {
				ModSpawns.init(event);
			}
			@SubscribeEvent
			public static void registerBiomes(RegistryEvent.Register<Biome> event) {
				ModBiomes.registerBiomes(event.getRegistry()); 
			}
			 
	    }
	    
	    
	    
	    
	    public static final CreativeTabs BlocksTab = new CreativeTabs("Blocks")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModBlocks.oreArlemite);
	        }
			
	    };
	    public static final CreativeTabs ItemsTab = new CreativeTabs("Item")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModItems.ingotArlemite);
	        }
			
	    };
	    public static final CreativeTabs CombatTab = new CreativeTabs("Combat")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModItems.arlemiteStabber);
	        }
			
	    };
	    public static final CreativeTabs ArmorTab = new CreativeTabs("Armor")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModItems.realmiteChestplate);
	        }
			
	    };
	    public static final CreativeTabs ToolsTab = new CreativeTabs("Tools")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModItems.arlemiteShickaxe);
	        }
			
	    };
	    public static final CreativeTabs TrophyTab = new CreativeTabs("Trophy")
	    {

	        @SideOnly(Side.CLIENT)
	        public ItemStack getTabIconItem()
	        {
	            return new ItemStack(ModBlocks.watcherStatue); 
	        }
			
	    };
	    public static void registerEvent(Object o) {
			MinecraftForge.EVENT_BUS.register(o);
			FMLCommonHandler.instance().bus().register(o);
		}
}