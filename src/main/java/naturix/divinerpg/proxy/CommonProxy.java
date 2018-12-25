package naturix.divinerpg.proxy;

import java.io.File;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.events.EventArmorSet;
import naturix.divinerpg.events.EventClientLogin;
import naturix.divinerpg.events.EventLightning;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModEntities;
import naturix.divinerpg.registry.ModLiquids;
import naturix.divinerpg.utils.ListAllObjs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



@Mod.EventBusSubscriber
	public class CommonProxy {
	public static Configuration config;
	
	    public void preInit(FMLPreInitializationEvent e) {
	    	File directory = e.getModConfigurationDirectory();
	        config = new Configuration(new File(directory.getPath(), "naturix/divinerpg.cfg"));
	        Config.readConfig();
	        ModDimensions.init();
	        ModEntities.init();
	        ModLiquids.init();
	        ListAllObjs.listobjs();
	        DivineRPG.registerEvent(new EventArmorSet());
	        DivineRPG.registerEvent(new EventClientLogin());
	        DivineRPG.registerEvent(new EventLightning());
	        }
	    public EntityPlayer getPlayer() { return null; }
	    public void init(FMLInitializationEvent e) {
	    }

	    public void postInit(FMLPostInitializationEvent e) {
	    	if (config.hasChanged()) {
	            config.save();
	        }
	    }

	    @SubscribeEvent
	    public static void registerBlocks(RegistryEvent.Register<Block> event) {
	    	
	    }

	    @SubscribeEvent
	    public static void registerItems(RegistryEvent.Register<Item> event) {
	    }

		public void registerItemRenderer(Item itemBlock, int i, String name) {

		}
		
		public static void registerEvent(Object event)
		{
			FMLCommonHandler.instance().bus().register(event);
			MinecraftForge.EVENT_BUS.register(event);
		}

		public void updateClientArcana(float amount) {}
	}