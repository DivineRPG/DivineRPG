package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.BaseStatue;
import naturix.divinerpg.bases.blocks.BeaconBaseBase;
import naturix.divinerpg.bases.blocks.BlockBase;
import naturix.divinerpg.bases.blocks.BlockNetherite;
import naturix.divinerpg.bases.blocks.BlockOre;
import naturix.divinerpg.bases.blocks.BlockOreNether;
import naturix.divinerpg.bases.blocks.LampBase;
import naturix.divinerpg.bases.blocks.LeavesBase;
import naturix.divinerpg.bases.blocks.LogBase;
import naturix.divinerpg.bases.blocks.Spike;
import naturix.divinerpg.bases.blocks.TorchBase;
import naturix.divinerpg.bases.blocks.arcana.Acceleron;
import naturix.divinerpg.bases.blocks.arcana.HeatTrap;
import naturix.divinerpg.bases.blocks.sapling.SaplingApalachia;
import naturix.divinerpg.bases.blocks.sapling.SaplingEden;
import naturix.divinerpg.bases.blocks.sapling.SaplingMortum;
import naturix.divinerpg.bases.blocks.sapling.SaplingSkythern;
import naturix.divinerpg.bases.blocks.sapling.SaplingWildwood;
import naturix.divinerpg.bases.blocks.tile.AltarDramix;
import naturix.divinerpg.bases.blocks.tile.AltarParasecta;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.bases.blocks.tile.furnace.BlockFurnace;
import naturix.divinerpg.bases.blocks.tile.furnace.entity.TileEntityFurnace;
import naturix.divinerpg.bases.blocks.vethia.Acid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	public static BlockOre oreArlemite = new BlockOre("ore_arlemite");
	public static BlockOre oreapalachia = new BlockOre("ore_apalachia");
	public static BlockOreNether orebloodgem = new BlockOreNether("ore_bloodgem");
	public static BlockOre oremortum = new BlockOre("ore_mortum");
	public static BlockNetherite oreNetherite = new BlockNetherite("ore_netherite");
	public static BlockOre oreRupee = new BlockOre("ore_rupee");
	public static BlockOre oreSkythern = new BlockOre("ore_skythern");
	public static BlockOre oreWildwood = new BlockOre("ore_wildwood");
	public static BlockOre oreRealmite = new BlockOre("ore_realmite");
	public static BlockOre oreEden = new BlockOre("ore_eden");
	public static BeaconBaseBase blockArlemite = new BeaconBaseBase(Material.ROCK, "block_arlemite");
	public static BeaconBaseBase blockApalachia = new BeaconBaseBase(Material.ROCK, "block_apalachia");
	public static BeaconBaseBase blockMortum = new BeaconBaseBase(Material.ROCK, "block_mortum");
	public static BeaconBaseBase blockRupee= new BeaconBaseBase(Material.ROCK, "block_rupee");
	public static BeaconBaseBase blockSkythern = new BeaconBaseBase(Material.ROCK, "block_skythern");
	public static BeaconBaseBase blockWildWood = new BeaconBaseBase(Material.ROCK, "block_wildwood");
	public static BeaconBaseBase blockRealmite = new BeaconBaseBase(Material.ROCK, "block_realmite");
	public static BeaconBaseBase blockEden = new BeaconBaseBase(Material.ROCK, "block_eden");
	public static BeaconBaseBase blockBloodGem= new BeaconBaseBase(Material.ROCK, "block_bloodgem");
	public static BeaconBaseBase blockNetherite = new BeaconBaseBase(Material.ROCK, "block_netherite");
	public static BlockOre oreArcanium = new BlockOre("ore_arcanium");
	public static LampBase blockAquaLamp = new LampBase(Material.ICE, "block_aqua_lamp");
	public static LampBase blockArlemiteLamp = new LampBase(Material.ICE, "block_arlemite_lamp");
	public static LampBase blockBlazeLamp = new LampBase(Material.ICE, "block_blaze_lamp");
	public static LampBase blockCellLamp = new LampBase(Material.ICE, "block_cell_lamp");
	public static LampBase blockDiamondLamp = new LampBase(Material.ICE, "block_diamond_lamp");
	public static LampBase blockDivineLamp = new LampBase(Material.ICE, "block_divine_lamp");
	public static LampBase blockDrakenLamp = new LampBase(Material.ICE, "block_draken_lamp");
	public static LampBase blockDreamLamp = new LampBase(Material.ICE, "block_dream_lamp");
	public static LampBase blockDungeonLamp = new LampBase(Material.ICE, "block_dungeon_lamp");
	public static LampBase blockEdenLamp = new LampBase(Material.ICE, "block_eden_lamp");
	public static LampBase blockEnderLamp = new LampBase(Material.ICE, "block_ender_lamp");
	public static LampBase blockGoldLamp = new LampBase(Material.ICE, "block_gold_lamp");
	public static LampBase blockIceLamp = new LampBase(Material.ICE, "block_ice_lamp");
	public static LampBase blockJungleLamp = new LampBase(Material.ICE, "block_jungle_lamp");
	public static LampBase blockKrakenLamp = new LampBase(Material.ICE, "block_kraken_lamp");
	public static LampBase blockLapisLazuliLamp = new LampBase(Material.ICE, "block_lapis_lazuli_lamp");
	public static LampBase blockLavaLamp = new LampBase(Material.ICE, "block_lava_lamp");
	public static LampBase blockMilkyLamp = new LampBase(Material.ICE, "block_milky_lamp");
	public static LampBase blockMoltenLamp = new LampBase(Material.ICE, "block_molten_lamp");
	public static LampBase blockNetheriteLamp = new LampBase(Material.ICE, "block_netherite_lamp");
	public static LampBase blockRealmiteLamp = new LampBase(Material.ICE, "block_realmite_lamp");
	public static LampBase blockRedstoneLamp = new LampBase(Material.ICE, "block_redstone_lamp");
	public static LampBase blockRupeeLamp = new LampBase(Material.ICE, "block_rupee_lamp");
	public static LampBase blockSlimeLamp = new LampBase(Material.ICE, "block_slime_lamp");
	public static LampBase blockTerranLamp = new LampBase(Material.ICE, "block_terran_lamp");
	public static LampBase blockVillageLamp = new LampBase(Material.ICE, "block_village_lamp");
	public static LampBase blockWorkshopLamp = new LampBase(Material.ICE, "block_workshop_lamp");
	public static LogBase divineLog = new LogBase("log_divine");
	public static LogBase dreamLog = new LogBase("log_dream");
	public static LogBase frozenLog = new LogBase("log_frozen");
	public static LogBase hyreLog = new LogBase("log_hyre");
	public static LogBase mintLog = new LogBase("log_mint");
	public static LogBase edenLog = new LogBase("log_eden");
	public static LogBase fireLog = new LogBase("log_fire");
	public static LogBase wildwoodLog = new LogBase("log_wildwood");
	public static LogBase apalachiaLog = new LogBase("log_apalachia");
	public static LogBase skythernLog = new LogBase("log_skythern");
	public static LogBase mortumLog = new LogBase("log_mortum");
	public static LeavesBase divineLeaves = new LeavesBase("leaves_divine");
	public static LeavesBase dreamLeaves = new LeavesBase("leaves_dream");
	//public static BlockBase frozenLeaves = new BlockBase(Material.LEAVES, "leaves_frozen");
	public static LeavesBase hyreLeaves = new LeavesBase("leaves_hyre");
	public static LeavesBase mintLeaves = new LeavesBase("leaves_mint");
	public static LeavesBase edenLeaves = new LeavesBase("leaves_eden", ModBlocks.edenSapling);
	public static LeavesBase fireLeaves = new LeavesBase("leaves_fire");
	public static LeavesBase wildwoodLeaves = new LeavesBase("leaves_wildwood", ModBlocks.wildwoodSapling);
	public static LeavesBase apalachiaLeaves = new LeavesBase("leaves_apalachia", ModBlocks.apalachiaSapling);
	public static LeavesBase skythernLeaves = new LeavesBase("leaves_skythern", ModBlocks.skythernSapling); 
	public static LeavesBase mortumLeaves = new LeavesBase("leaves_mortum", ModBlocks.mortumSapling);
	public static TorchBase torchSkeleton = new TorchBase(Material.CIRCUITS, "torch_skeleton");
	public static TorchBase torchAqua = new TorchBase(Material.CIRCUITS, "torch_aqua");
	public static TorchBase torchEden = new TorchBase(Material.CIRCUITS, "torch_eden");
	public static TorchBase torchArcanium= new TorchBase(Material.CIRCUITS, "torch_arcanium");
	public static SaplingApalachia apalachiaSapling = new SaplingApalachia("sapling_apalachia");
	//public static SaplingApalachia divineSapling = new SaplingApalachia("sapling_divine");
	//public static SaplingApalachia dreamSapling = new SaplingApalachia("sapling_dream");
	//public static SaplingApalachia frozenSapling = new SaplingApalachia("sapling_frozen");
	//public static SaplingApalachia hyreSapling = new SaplingApalachia("sapling_hyre");
	//public static SaplingApalachia mintSapling = new SaplingApalachia("sapling_mint");
	public static SaplingEden edenSapling = new SaplingEden("sapling_eden");
	//public static SaplingApalachia fireSapling = new SaplingApalachia("sapling_fire");
	public static SaplingWildwood wildwoodSapling = new SaplingWildwood("sapling_wildwood");
	public static SaplingSkythern skythernSapling = new SaplingSkythern("sapling_skythern");
	public static SaplingMortum mortumSapling = new SaplingMortum("sapling_mortum");
	public static BaseStatue watcherStatue = new BaseStatue("statue_watcher");
	public static BaseStatue ancientEntityStatue = new BaseStatue("statue_anciententity");
	public static BaseStatue ayeracoHordeStatue = new BaseStatue("statue_ayeracohorde");
	public static BaseStatue densosStatue = new BaseStatue("statue_densos");
	public static BaseStatue dexZichileStatue = new BaseStatue("statue_dexzichile");
	public static BaseStatue dramixStatue = new BaseStatue("statue_dramix");
	public static BaseStatue kingScorcherStatue = new BaseStatue("statue_kingscorcher");
	public static BaseStatue reyvorStatue = new BaseStatue("statue_reyvor");
	public static BaseStatue soulFiendStatue = new BaseStatue("statue_soulfiend");
	public static BaseStatue twilightDemonStatue = new BaseStatue("statue_twilightdemon");
	public static BaseStatue vamacheronStatue = new BaseStatue("statue_vamacheron");
	//public static BedBase nightmarebed = new BedBase("bed_nightmare");
	public static AltarDramix altarDramix = new AltarDramix("altar_dramix");
	public static AltarParasecta altarParasecta = new AltarParasecta("altar_parasecta");
	public static BlockFurnace furnace = new BlockFurnace("furnace_1");
	public static HeatTrap heatTrap = new HeatTrap("heat_trap");
	public static HeatTrap heatTrapOn = new HeatTrap("heat_trap_on");
	public static Spike spikeCold = new Spike("spike_cold");
	public static Spike spikeHot = new Spike("spike_hot");
	public static Acid acidBacteria = new Acid("acid_bacterial", false, true);
	public static Acid acidBlock = new Acid("acid_block", true, false);
	public static Acid acidLunic = new Acid("acid_lunic", true, true);
	public static Acceleron acceleron = new Acceleron("acceleron");
	public static BlockBase grassArcana = new BlockBase("grass_arcana");
	 
	public static void register(IForgeRegistry<Block> registry) { 
		System.out.print("DivineRPG blocks loading");
		registry.registerAll(
				oreArlemite,
				oreapalachia,
				orebloodgem,
				oremortum,
				oreNetherite,
				oreRupee,
				oreSkythern,
				oreWildwood,
				oreRealmite,
				oreEden,
				blockArlemite,
				blockApalachia,
				blockMortum,
				blockRupee,
				blockSkythern,
				blockWildWood,
				blockRealmite,
				blockEden,
				blockBloodGem,
				blockNetherite,
				oreArcanium,
				blockAquaLamp,
				blockArlemiteLamp,
				blockBlazeLamp,
				blockCellLamp,
				blockDiamondLamp,
				blockDivineLamp,
				blockDrakenLamp,
				blockDreamLamp,
				blockDungeonLamp,
				blockEdenLamp,
				blockEnderLamp,
				blockGoldLamp,
				blockIceLamp,
				blockJungleLamp,
				blockKrakenLamp,
				blockLapisLazuliLamp,
				blockLavaLamp,
				blockMilkyLamp,
				blockMoltenLamp,
				blockNetheriteLamp,
				blockRealmiteLamp,
				blockRedstoneLamp,
				blockRupeeLamp,
				blockSlimeLamp,
				blockTerranLamp,
				blockVillageLamp,
				blockWorkshopLamp,
				divineLog,
				dreamLog,
				frozenLog,
				hyreLog,
				mintLog,
				edenLog,
				fireLog,
				wildwoodLog,
				apalachiaLog,
				skythernLog,
				mortumLog,
				divineLeaves, 
				dreamLeaves,
				//frozenLeaves,
				hyreLeaves,
				mintLeaves,
				edenLeaves,
				fireLeaves,
				wildwoodLeaves,
				apalachiaLeaves,
				skythernLeaves,
				mortumLeaves,
				torchSkeleton,
				torchAqua,
				torchEden,
				torchArcanium,
				apalachiaSapling,
				//divineSapling,
				//dreamSapling,
				//frozenSapling,
				//hyreSapling,
				//mintSapling,
				edenSapling,
				//fireSapling,
				wildwoodSapling,
				skythernSapling,
				mortumSapling,
				watcherStatue,
				ancientEntityStatue,
				ayeracoHordeStatue,
				densosStatue,
				dexZichileStatue,
				dramixStatue,
				kingScorcherStatue,
				reyvorStatue,
				soulFiendStatue,
				twilightDemonStatue,
				vamacheronStatue,
				altarDramix,
				altarParasecta,
				heatTrap,
				heatTrapOn,
				spikeCold,
				spikeHot,
				acidBacteria,
				acidBlock,
				acidLunic,
				acceleron,
				grassArcana,
				furnace
		);
		GameRegistry.registerTileEntity(TileEntityDramixAltar.class, altarDramix.getRegistryName().toString());
		GameRegistry.registerTileEntity(TileEntityParasectaAltar.class, altarParasecta.getRegistryName().toString());
		GameRegistry.registerTileEntity(TileEntityFurnace.class, furnace.getRegistryName().toString());
		
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				oreArlemite.createItemBlock(),
				oreapalachia.createItemBlock(),
				orebloodgem.createItemBlock(),
				oremortum.createItemBlock(),
				oreNetherite.createItemBlock(),
				oreRupee.createItemBlock(),
				oreSkythern.createItemBlock(),
				oreWildwood.createItemBlock(),
				oreRealmite.createItemBlock(),
				oreEden.createItemBlock(),
				blockArlemite.createItemBlock(),
				blockApalachia.createItemBlock(),
				blockMortum.createItemBlock(),
				blockRupee.createItemBlock(),
				blockSkythern.createItemBlock(),
				blockWildWood.createItemBlock(),
				blockRealmite.createItemBlock(),
				blockEden.createItemBlock(),
				blockBloodGem.createItemBlock(),
				blockNetherite.createItemBlock(),
				oreArcanium.createItemBlock(),
				blockAquaLamp.createItemBlock(),
				blockArlemiteLamp.createItemBlock(),
				blockBlazeLamp.createItemBlock(),
				blockCellLamp.createItemBlock(),
				blockDiamondLamp.createItemBlock(),
				blockDivineLamp.createItemBlock(),
				blockDrakenLamp.createItemBlock(),
				blockDreamLamp.createItemBlock(),
				blockDungeonLamp.createItemBlock(),
				blockEdenLamp.createItemBlock(),
				blockEnderLamp.createItemBlock(),
				blockGoldLamp.createItemBlock(),
				blockIceLamp.createItemBlock(),
				blockJungleLamp.createItemBlock(),
				blockKrakenLamp.createItemBlock(),
				blockLapisLazuliLamp.createItemBlock(),
				blockLavaLamp.createItemBlock(),
				blockMilkyLamp.createItemBlock(),
				blockMoltenLamp.createItemBlock(),
				blockNetheriteLamp.createItemBlock(),
				blockRealmiteLamp.createItemBlock(),
				blockRedstoneLamp.createItemBlock(),
				blockRupeeLamp.createItemBlock(),
				blockSlimeLamp.createItemBlock(),
				blockTerranLamp.createItemBlock(),
				blockVillageLamp.createItemBlock(),
				blockWorkshopLamp.createItemBlock(),
				divineLog.createItemBlock(),
				dreamLog.createItemBlock(),
				frozenLog.createItemBlock(),
				hyreLog.createItemBlock(),
				mintLog.createItemBlock(),
				edenLog.createItemBlock(),
				fireLog.createItemBlock(),
				wildwoodLog.createItemBlock(),
				apalachiaLog.createItemBlock(),
				skythernLog.createItemBlock(),
				mortumLog.createItemBlock(),
				divineLeaves.createItemBlock() ,
				dreamLeaves.createItemBlock(),
				//frozenLeaves.createItemBlock(),
				hyreLeaves.createItemBlock(),
				mintLeaves.createItemBlock(),
				edenLeaves.createItemBlock(),
				fireLeaves.createItemBlock(),
				wildwoodLeaves.createItemBlock(),
				apalachiaLeaves.createItemBlock(),
				skythernLeaves.createItemBlock(),
				mortumLeaves.createItemBlock(),
				torchSkeleton.createItemBlock(),
				torchAqua.createItemBlock(),
				torchEden.createItemBlock(),
				torchArcanium.createItemBlock(),
				apalachiaSapling.createItemBlock(),
				//divineSapling.createItemBlock(),
				//dreamSapling.createItemBlock(),
				//frozenSapling.createItemBlock(),
				//hyreSapling.createItemBlock(),
				//mintSapling.createItemBlock(),
				edenSapling.createItemBlock(),
				//fireSapling.createItemBlock(),
				wildwoodSapling.createItemBlock(),
				skythernSapling.createItemBlock(),
				mortumSapling.createItemBlock(),
				watcherStatue.createItemBlock(),
				ancientEntityStatue.createItemBlock(),
				ayeracoHordeStatue.createItemBlock(),
				densosStatue.createItemBlock(),
				dexZichileStatue.createItemBlock(),
				dramixStatue.createItemBlock(),
				kingScorcherStatue.createItemBlock(),
				reyvorStatue.createItemBlock(),
				soulFiendStatue.createItemBlock(),
				twilightDemonStatue.createItemBlock(), 
				vamacheronStatue.createItemBlock(),
				altarDramix.createItemBlock(),
				altarParasecta.createItemBlock(),
				heatTrap.createItemBlock(),
				furnace.createItemBlock(),
				spikeCold.createItemBlock(),
				spikeHot.createItemBlock(),
				acidBacteria.createItemBlock(),
				acidBlock.createItemBlock(),
				acidLunic.createItemBlock(),
				acceleron.createItemBlock(),
				grassArcana.createItemBlock()
				//nightmarebed.createItemBlock()
				);
	} 
	
	public static void registerModels() {
		oreArlemite.registerItemModel(Item.getItemFromBlock(oreArlemite));
		oreapalachia.registerItemModel(Item.getItemFromBlock(oreapalachia));
		orebloodgem.registerItemModel(Item.getItemFromBlock(orebloodgem));
		oremortum.registerItemModel(Item.getItemFromBlock(oremortum));
		oreNetherite.registerItemModel(Item.getItemFromBlock(oreNetherite));
		oreRupee.registerItemModel(Item.getItemFromBlock(oreRupee));
		oreSkythern.registerItemModel(Item.getItemFromBlock(oreSkythern));
		oreWildwood.registerItemModel(Item.getItemFromBlock(oreWildwood));
		oreRealmite.registerItemModel(Item.getItemFromBlock(oreRealmite));
		oreEden.registerItemModel(Item.getItemFromBlock(oreEden));
		blockArlemite.registerItemModel(Item.getItemFromBlock(blockArlemite));
		blockApalachia.registerItemModel(Item.getItemFromBlock(blockApalachia));
		blockMortum.registerItemModel(Item.getItemFromBlock(blockMortum));
		blockRupee.registerItemModel(Item.getItemFromBlock(blockRupee));
		blockSkythern.registerItemModel(Item.getItemFromBlock(blockSkythern));
		blockWildWood.registerItemModel(Item.getItemFromBlock(blockWildWood));
		blockRealmite.registerItemModel(Item.getItemFromBlock(blockRealmite));
		blockEden.registerItemModel(Item.getItemFromBlock(blockEden));
		blockBloodGem.registerItemModel(Item.getItemFromBlock(blockBloodGem));
		blockNetherite.registerItemModel(Item.getItemFromBlock(blockNetherite));
		oreArcanium.registerItemModel(Item.getItemFromBlock(oreArcanium));	
		blockAquaLamp.registerItemModel(Item.getItemFromBlock(blockAquaLamp));
		blockArlemiteLamp.registerItemModel(Item.getItemFromBlock(blockArlemiteLamp));
		blockBlazeLamp.registerItemModel(Item.getItemFromBlock(blockBlazeLamp));
		blockCellLamp.registerItemModel(Item.getItemFromBlock(blockCellLamp));
		blockDiamondLamp.registerItemModel(Item.getItemFromBlock(blockDiamondLamp));
		blockDivineLamp.registerItemModel(Item.getItemFromBlock(blockDivineLamp));
		blockDrakenLamp.registerItemModel(Item.getItemFromBlock(blockDrakenLamp));
		blockDreamLamp.registerItemModel(Item.getItemFromBlock(blockDreamLamp));
		blockDungeonLamp.registerItemModel(Item.getItemFromBlock(blockDungeonLamp));
		blockEdenLamp.registerItemModel(Item.getItemFromBlock(blockEdenLamp));
		blockEnderLamp.registerItemModel(Item.getItemFromBlock(blockEnderLamp));
		blockGoldLamp.registerItemModel(Item.getItemFromBlock(blockGoldLamp));
		blockIceLamp.registerItemModel(Item.getItemFromBlock(blockIceLamp));
		blockJungleLamp.registerItemModel(Item.getItemFromBlock(blockJungleLamp));
		blockKrakenLamp.registerItemModel(Item.getItemFromBlock(blockKrakenLamp));
		blockLapisLazuliLamp.registerItemModel(Item.getItemFromBlock(blockLapisLazuliLamp));
		blockLavaLamp.registerItemModel(Item.getItemFromBlock(blockLavaLamp));
		blockMilkyLamp.registerItemModel(Item.getItemFromBlock(blockMilkyLamp));
		blockMoltenLamp.registerItemModel(Item.getItemFromBlock(blockMoltenLamp));
		blockNetheriteLamp.registerItemModel(Item.getItemFromBlock(blockNetheriteLamp));
		blockRealmiteLamp.registerItemModel(Item.getItemFromBlock(blockRealmiteLamp));
		blockRedstoneLamp.registerItemModel(Item.getItemFromBlock(blockRedstoneLamp));
		blockRupeeLamp.registerItemModel(Item.getItemFromBlock(blockRupeeLamp));
		blockSlimeLamp.registerItemModel(Item.getItemFromBlock(blockSlimeLamp));
		blockTerranLamp.registerItemModel(Item.getItemFromBlock(blockTerranLamp));
		blockVillageLamp.registerItemModel(Item.getItemFromBlock(blockVillageLamp));
		blockWorkshopLamp.registerItemModel(Item.getItemFromBlock(blockWorkshopLamp));
		divineLog.registerItemModel(Item.getItemFromBlock(divineLog));
		dreamLog.registerItemModel(Item.getItemFromBlock(dreamLog));
		frozenLog.registerItemModel(Item.getItemFromBlock(frozenLog));
		hyreLog.registerItemModel(Item.getItemFromBlock(hyreLog));
		mintLog.registerItemModel(Item.getItemFromBlock(mintLog));
		edenLog.registerItemModel(Item.getItemFromBlock(edenLog));
		fireLog.registerItemModel(Item.getItemFromBlock(fireLog));
		wildwoodLog.registerItemModel(Item.getItemFromBlock(wildwoodLog));
		apalachiaLog.registerItemModel(Item.getItemFromBlock(apalachiaLog));
		skythernLog.registerItemModel(Item.getItemFromBlock(skythernLog));
		mortumLog.registerItemModel(Item.getItemFromBlock(mortumLog));
		divineLog.registerItemModel(Item.getItemFromBlock(divineLog));
		divineLeaves.registerItemModel(Item.getItemFromBlock(divineLeaves)); 
		dreamLeaves.registerItemModel(Item.getItemFromBlock(dreamLeaves));
		//frozenLeaves.registerItemModel(Item.getItemFromBlock(frozenLeaves));
		hyreLeaves.registerItemModel(Item.getItemFromBlock(hyreLeaves));
		mintLeaves.registerItemModel(Item.getItemFromBlock(mintLeaves));
		edenLeaves.registerItemModel(Item.getItemFromBlock(edenLeaves));
		fireLeaves.registerItemModel(Item.getItemFromBlock(fireLeaves));
		wildwoodLeaves.registerItemModel(Item.getItemFromBlock(wildwoodLeaves));
		apalachiaLeaves.registerItemModel(Item.getItemFromBlock(apalachiaLeaves));
		skythernLeaves.registerItemModel(Item.getItemFromBlock(skythernLeaves));
		mortumLeaves.registerItemModel(Item.getItemFromBlock(mortumLeaves));
		torchSkeleton.registerItemModel(Item.getItemFromBlock(torchSkeleton));
		torchAqua.registerItemModel(Item.getItemFromBlock(torchAqua));
		torchEden.registerItemModel(Item.getItemFromBlock(torchEden));
		torchArcanium.registerItemModel(Item.getItemFromBlock(torchArcanium));
		apalachiaSapling.registerItemModel(Item.getItemFromBlock(apalachiaSapling));
		//divineSapling.registerItemModel(Item.getItemFromBlock(divineSapling));
		//dreamSapling.registerItemModel(Item.getItemFromBlock(dreamSapling));
		//frozenSapling.registerItemModel(Item.getItemFromBlock(frozenSapling));
		//hyreSapling.registerItemModel(Item.getItemFromBlock(hyreSapling));
		//mintSapling.registerItemModel(Item.getItemFromBlock(mintSapling));
		edenSapling.registerItemModel(Item.getItemFromBlock(edenSapling));
		//fireSapling.registerItemModel(Item.getItemFromBlock(fireSapling));
		wildwoodSapling.registerItemModel(Item.getItemFromBlock(wildwoodSapling));
		skythernSapling.registerItemModel(Item.getItemFromBlock(skythernSapling));
		mortumSapling.registerItemModel(Item.getItemFromBlock(mortumSapling));
		watcherStatue.registerItemModel(Item.getItemFromBlock(watcherStatue));
		ancientEntityStatue.registerItemModel(Item.getItemFromBlock(ancientEntityStatue));
		ayeracoHordeStatue.registerItemModel(Item.getItemFromBlock(ayeracoHordeStatue));
		densosStatue.registerItemModel(Item.getItemFromBlock(densosStatue));
		dexZichileStatue.registerItemModel(Item.getItemFromBlock(dexZichileStatue));
		dramixStatue.registerItemModel(Item.getItemFromBlock(dramixStatue));
		kingScorcherStatue.registerItemModel(Item.getItemFromBlock(kingScorcherStatue));
		reyvorStatue.registerItemModel(Item.getItemFromBlock(reyvorStatue));
		soulFiendStatue.registerItemModel(Item.getItemFromBlock(soulFiendStatue));
		twilightDemonStatue.registerItemModel(Item.getItemFromBlock(twilightDemonStatue));
		vamacheronStatue.registerItemModel(Item.getItemFromBlock(vamacheronStatue));
		altarDramix.registerItemModel(Item.getItemFromBlock(altarDramix));
		altarParasecta.registerItemModel(Item.getItemFromBlock(altarParasecta));
		heatTrap.registerItemModel(Item.getItemFromBlock(heatTrap));
		spikeCold.registerItemModel(Item.getItemFromBlock(spikeCold));
		spikeHot.registerItemModel(Item.getItemFromBlock(spikeHot));
		acidBacteria.registerItemModel(Item.getItemFromBlock(acidBacteria));
		acidBlock.registerItemModel(Item.getItemFromBlock(acidBlock));
		acidLunic.registerItemModel(Item.getItemFromBlock(acidLunic));
		acceleron.registerItemModel(Item.getItemFromBlock(acceleron));
		grassArcana.registerItemModel(Item.getItemFromBlock(grassArcana));
		
		furnace.registerItemModel(Item.getItemFromBlock(furnace));
		//nightmarebed.registerItemModel(Item.getItemFromBlock(nightmarebed));
		
		DivineRPG.logger.info(DivineRPG.name + " blocks are loaded");
	}

}