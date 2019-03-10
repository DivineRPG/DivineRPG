package naturix.divinerpg.proxy;

import java.io.File;

import naturix.divinerpg.Config;
import naturix.divinerpg.objects.blocks.tile.block.TEBed;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityCoalstoneFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityDemonFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityIceikaChest;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityMoltenFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityOceanfireFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityWhitefireFurnace;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityAyeracoBeam;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityAyeracoSpawn;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixStatue;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.registry.ModEntities;
import naturix.divinerpg.registry.ModLiquids;
import naturix.divinerpg.utils.DRPGParticleTypes;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.world.structures.WorldGenCustomStructures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public static Configuration config;

	public EntityPlayer getPlayer() {
		return null;
	}

	public void init(FMLInitializationEvent e) {
	}

	public void postInit(FMLPostInitializationEvent e) {
		if (config.hasChanged()) {
			config.save();
		}
		ModEntities.initSpawns();
	}

	public void preInit(FMLPreInitializationEvent e) {
		ModDimensions.init();
		ModEntities.init();
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		ModLiquids.init();
		ModEntities.initLoot();

		File directory = e.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "DivineRPG/divinerpg.cfg"));
		Config.readConfig();
	}

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	@SuppressWarnings("deprecation")
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDramixAltar.class, Reference.MODID + ":te_altar_dramix");
		GameRegistry.registerTileEntity(TileEntityParasectaAltar.class, Reference.MODID + ":te_altar_parasecta");
		GameRegistry.registerTileEntity(TEBed.class, Reference.MODID + ":te_bed_dream");
		GameRegistry.registerTileEntity(TileEntityCoalstoneFurnace.class, Reference.MODID + ":te_colastone_furnace");
		GameRegistry.registerTileEntity(TileEntityMoltenFurnace.class, Reference.MODID + ":te_molten_furnace");
		GameRegistry.registerTileEntity(TileEntityOceanfireFurnace.class, Reference.MODID + ":te_oceanfire_furnace");
		GameRegistry.registerTileEntity(TileEntityWhitefireFurnace.class, Reference.MODID + ":te_whitefire_furnace");
		GameRegistry.registerTileEntity(TileEntityDemonFurnace.class, Reference.MODID + ":te_demon_furnace");
		GameRegistry.registerTileEntity(TileEntityIceikaChest.class, Reference.MODID + ":te_iceika_chest");
		GameRegistry.registerTileEntity(TileEntityAyeracoBeam.class, Reference.MODID + ":te_ayeraco_beam");
		GameRegistry.registerTileEntity(TileEntityAyeracoSpawn.class, Reference.MODID + ":te_ayeraco_spawn");
		GameRegistry.registerTileEntity(TileEntityDramixStatue.class, Reference.MODID + ":te_statue_dramix");
	}

	public void RegisterTileEntityRender() {
	}

	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
	}

	public void spawnParticle(World world, DRPGParticleTypes particle, double x, double y, double z, double velX,
	        double velY, double velZ) {
	}

	public void updateClientArcana(float amount) {
	}
}