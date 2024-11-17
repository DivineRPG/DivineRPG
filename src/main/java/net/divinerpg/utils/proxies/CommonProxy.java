package net.divinerpg.utils.proxies;

import java.awt.Color;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.DivineRPG;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityDemonFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityDramixAltar;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityExtractor;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityGreenlightFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityMoltenFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityMoonlightFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityOceanfireFurnace;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityParasectaAltar;
import net.divinerpg.blocks.arcana.container.tile_entity.TileEntityWhitefireFurnace;
import net.divinerpg.blocks.base.tileentity.TileEntityStupidSpawner;
import net.divinerpg.blocks.iceika.tileentity.TileEntityCoalstoneFurnace;
import net.divinerpg.blocks.iceika.tileentity.TileEntityFrostedChest;
import net.divinerpg.blocks.iceika.tileentity.TileEntityPresentBox;
import net.divinerpg.blocks.twilight.TileEntityEdenChest;
import net.divinerpg.blocks.vanilla.container.tileentity.TileEntityAltarOfCorruption;
import net.divinerpg.blocks.vanilla.container.tileentity.TileEntityAyeracoBeam;
import net.divinerpg.blocks.vanilla.container.tileentity.TileEntityAyeracoSpawn;
import net.divinerpg.blocks.vanilla.container.tileentity.TileEntityBoneChest;
import net.divinerpg.blocks.vethea.container.tileentity.TileEntityDreamLamp;
import net.divinerpg.blocks.vethea.container.tileentity.TileEntityInfusionTable;
import net.divinerpg.client.GuiHandler;
import net.divinerpg.client.render.block.TileEntityStatue;
import net.divinerpg.dimensions.vanilla.DivineWorldgen;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.DimensionHelper;
import net.divinerpg.utils.DivineOredict;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.entities.ArcanaEntityRegistry;
import net.divinerpg.utils.entities.IceikaEntityRegistry;
import net.divinerpg.utils.entities.MobSpawning;
import net.divinerpg.utils.entities.TwilightEntityRegistry;
import net.divinerpg.utils.entities.VanillaEntityRegistry;
import net.divinerpg.utils.entities.VetheaEntityRegistry;
import net.divinerpg.utils.events.ArcanaTickHandler;
import net.divinerpg.utils.events.EntityConstructorEvent;
import net.divinerpg.utils.events.EventArmorFullSet;
import net.divinerpg.utils.events.EventArmorTick;
import net.divinerpg.utils.events.EventBonemeal;
import net.divinerpg.utils.events.EventBucketFill;
import net.divinerpg.utils.events.EventClientLogin;
import net.divinerpg.utils.events.EventEnsureVetheaSpawn;
import net.divinerpg.utils.events.EventHarvest;
import net.divinerpg.utils.events.EventLightning;
import net.divinerpg.utils.events.EventTooltip;
import net.divinerpg.utils.events.Ticker;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsCrops;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.TwilightItemsTools;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsTools;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.divinerpg.utils.items.VetheaItems;
import net.divinerpg.utils.recipes.TwilightRecipeHelper;
import net.divinerpg.utils.recipes.VanillaRecipeHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CommonProxy{
	public void preInitClient(FMLPreInitializationEvent event){}

	public void renderThings(){}
	
	public void preInitServer(FMLPreInitializationEvent event){
		Util.postForgeEvent(new EventBucketFill());
		Util.postForgeEvent(new EventBonemeal());
		Util.postForgeEvent(new EventArmorFullSet());
		Util.postFMLEvent(new EventArmorTick());
		Util.postForgeEvent(new EventHarvest());
        Util.postFMLEvent(new ArcanaTickHandler());
        Util.postForgeEvent(new ArcanaTickHandler());
        Util.postForgeEvent(new EntityConstructorEvent());
        Util.postForgeEvent(new EventTooltip());
        Util.postForgeEvent(new EventLightning());
        Util.postFMLEvent(new EventClientLogin());
        Util.postFMLEvent(new Ticker());
        Util.postFMLEvent(new EventEnsureVetheaSpawn());
        Util.postForgeEvent(new EventEnsureVetheaSpawn());
		ItemsFood.init();
		IceikaItems.init();
		IceikaBlocks.init();
		VetheaBlocks.init();
		VetheaItems.init();
		VanillaBlocks.init();
		TwilightItemsOther.init();
		TwilightBlocks.init();
		TwilightItemsCrops.init();
		TwilightItemsArmor.init();
		TwilightItemsWeapons.init();
		TwilightItemsTools.init();
		VanillaItemsOther.init();
		VanillaItemsArmor.init();
		VanillaItemsWeapons.init();
		VanillaItemsTools.init();
		ArcanaBlocks.init();
		ArcanaItems.init();
		DivineRPGTabs.init();
		DivineOredict.init();
		GameRegistry.registerTileEntity(TileEntityInfusionTable.class, "Infusion Table");
		GameRegistry.registerTileEntity(TileEntityStatue.class, "DivineRPGStatue");
		GameRegistry.registerTileEntity(TileEntityFrostedChest.class, "Frosted Chest");
		GameRegistry.registerTileEntity(TileEntityEdenChest.class, "Eden Chest");
		GameRegistry.registerTileEntity(TileEntityBoneChest.class, "Bone Chest");
		GameRegistry.registerTileEntity(TileEntityAyeracoBeam.class, "Ayeraco Beam");
		GameRegistry.registerTileEntity(TileEntityExtractor.class, "Arcanium Extractor");
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
		GameRegistry.registerTileEntity(TileEntityStupidSpawner.class, "StupidMobSpawner");
        GameRegistry.registerTileEntity(TileEntityPresentBox.class, "PresentBox");
        GameRegistry.registerTileEntity(TileEntityAyeracoSpawn.class, "AyeracoSpawn");
        GameRegistry.registerTileEntity(TileEntityDreamLamp.class, "DreamLamp");
		VanillaEntityRegistry.init();
		TwilightEntityRegistry.init();
		IceikaEntityRegistry.init();
		VetheaEntityRegistry.init();
		ArcanaEntityRegistry.init();
		DimensionHelper.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(DivineRPG.instance, new GuiHandler());
	}

	public void init(FMLInitializationEvent event){
		GameRegistry.registerWorldGenerator(new DivineWorldgen(), 0);
		DivineRPGAchievements.init();
        MobSpawning.addSpawns();
        VanillaRecipeHelper.init();
        TwilightRecipeHelper.init();
	}

	public void postInit(FMLPostInitializationEvent event){
		Util.addBucket(DivineRPG.tarFluid, new ItemStack(VanillaItemsOther.tarBucket));
	}

	public void spawnParticle(World w, double x, double y, double z, String particle, boolean random) {}
	public void spawnParticle(World w, double x, double y, double z, String particle, boolean random, int randFactor) {}
	public void spawnParticle(World w, double x, double y, double z, Color c, boolean random) {}
	
	public void updateClientArcana(float amount) {}
}
