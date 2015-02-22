package net.divinerpg;

import net.divinerpg.blocks.base.ModFluid;
import net.divinerpg.libs.Reference;
import net.divinerpg.network.MessageArcanaBar;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.proxies.CommonProxy;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class DivineRPG {

	@Instance(Reference.MOD_ID)
	public static DivineRPG instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	public static SimpleNetworkWrapper network;
	
	//Awesome seed: 1414274842007233730
	
	public static Fluid tarFluid = new ModFluid("Tar", 10, 5000);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		LogHelper.info("Configuring mod");
		ConfigurationHelper.init(event.getModConfigurationDirectory());
		
		network = NetworkRegistry.INSTANCE.newSimpleChannel("DivineRPGNetwork");
		network.registerMessage(MessageArcanaBar.Handler.class, MessageArcanaBar.class, 0, Side.CLIENT);
		
		proxy.preInitServer(event);
		proxy.preInitClient(event);
		proxy.renderThings();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}
}