package net.divinerpg;

import net.divinerpg.blocks.arcana.container.tile_entity.*;
import net.divinerpg.blocks.iceika.container.tile_entity.*;
import net.divinerpg.blocks.twilight.*;
import net.divinerpg.blocks.vanilla.container.tile_entity.*;
import net.divinerpg.blocks.vethea.container.tile_entity.*;
import net.divinerpg.client.*;
import net.divinerpg.client.render.*;
import net.divinerpg.client.render.block.*;
import net.divinerpg.dimension.gen.vanilla.*;
import net.divinerpg.helper.*;
import net.divinerpg.helper.*;
import net.divinerpg.helper.config.*;
import net.divinerpg.helper.entity.*;
import net.divinerpg.helper.event.*;
import net.divinerpg.helper.items.*;
import net.divinerpg.helper.recipes.*;
import net.divinerpg.helper.tabs.*;
import net.divinerpg.helper.utils.*;
import net.minecraft.command.*;
import net.minecraft.item.*;
import net.minecraft.server.*;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.relauncher.*;

public class CommonProxy{
	public void preInitClient(FMLPreInitializationEvent event){}

	public void renderThings(){}
	
	public void preInitServer(FMLPreInitializationEvent event){
		DivineRPGTabs.init();
		LogHelper.info("Adding events");
		Util.addEventBus(new EventBucketFill());
		Util.addEventBus(new EventBonemeal());
		Util.addEventBus(new EventArmorFullSet());
		Util.addEventBus(new EventLightningStrike());
		Util.addEventBus(new EventHarvest());
		Util.addEventBus(new EventDeath());
		LogHelper.info("Registering tile entities");
		GameRegistry.registerTileEntity(TileEntityTwilightFurnace.class, "Twilight Furnace");
		GameRegistry.registerTileEntity(TileEntityInfusionTable.class, "Infusion Table");
		GameRegistry.registerTileEntity(TileEntityStatue.class, "Statue");
		GameRegistry.registerTileEntity(TileEntityFrostedChest.class, "Iceika Chest");
		GameRegistry.registerTileEntity(TileEntityAyeracoBeam.class, "Ayeraco Beam");
		GameRegistry.registerTileEntity(TileEntityExtractor.class, "Extractor");
		GameRegistry.registerTileEntity(TileEntityDramixAltar.class, "Dramix Altar");
		GameRegistry.registerTileEntity(TileEntityParasectaAltar.class, "Parasecta Altar");
		GameRegistry.registerTileEntity(TileEntityCoalstoneFurnace.class, "Coalstone Furnace");
		GameRegistry.registerTileEntity(TileEntityGreenlightFurnace.class, "Greenlight Furnace");
		GameRegistry.registerTileEntity(TileEntityMoltenFurnace.class, "Molten Furnace");
		GameRegistry.registerTileEntity(TileEntityMoonlightFurnace.class, "Moonlight Furnace");
		GameRegistry.registerTileEntity(TileEntityOceanfireFurnace.class, "Oceanfire Furnace");
		GameRegistry.registerTileEntity(TileEntityWhitefireFurnace.class, "Whitefire Furnace");
		GameRegistry.registerTileEntity(TileEntityDemonFurnace.class, "Demon Furnace");
		GameRegistry.registerTileEntity(TileEntityAltarOfCorruption.class, "Altar Of Corruption");
		LogHelper.info("Registering entities");
		VanillaEntityRegistry.init();
		TwilightEntityRegistry.init();
		IceikaEntityRegistry.init();
		VetheaEntityRegistry.init();
		ArcanaEntityRegistry.init();
		LogHelper.info("Adding crafting/smelting recipes");
		VanillaRecipeHelper.init();
		TwilightRecipeHelper.init();
		DimensionHelper.init();
		MobSpawning.addSpawns();
	}

	public void init(FMLInitializationEvent event){
		int wut = 10;
		LogHelper.info("Adding world generators");
		GameRegistry.registerWorldGenerator(new WorldGenOverworld(), wut);
		DivineRPGAchievements.init();
	}

	public void postInit(FMLPostInitializationEvent event){
		Util.addBucket(DivineRPG.tarFluid, new ItemStack(VanillaItemsOther.tarBucket));
		Util.addBucket(DivineRPG.frozenLava, new ItemStack(IceikaItems.frozenLavaBucket));
	}

	public void serverStarting(FMLServerStartingEvent event){ 
		LogHelper.info("Setting up commands");
		if (MinecraftServer.getServer().getCommandManager() instanceof ServerCommandManager)
			((CommandHandler)MinecraftServer.getServer().getCommandManager()).registerCommand(new DivineRPGCommands());
	}
}
