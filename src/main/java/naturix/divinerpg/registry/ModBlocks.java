package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BaseStatue;
import naturix.divinerpg.objects.blocks.BeaconBaseBase;
import naturix.divinerpg.objects.blocks.BedBase;
import naturix.divinerpg.objects.blocks.BlockBase;
import naturix.divinerpg.objects.blocks.BlockModSpawner;
import naturix.divinerpg.objects.blocks.BlockNetherite;
import naturix.divinerpg.objects.blocks.BlockOre;
import naturix.divinerpg.objects.blocks.BlockOreNether;
import naturix.divinerpg.objects.blocks.CoalstoneFurnace;
import naturix.divinerpg.objects.blocks.DirtBase;
import naturix.divinerpg.objects.blocks.FireBase;
import naturix.divinerpg.objects.blocks.FrostedGlass;
import naturix.divinerpg.objects.blocks.GrassBase;
import naturix.divinerpg.objects.blocks.IceikaChest;
import naturix.divinerpg.objects.blocks.LampBase;
import naturix.divinerpg.objects.blocks.LeavesBase;
import naturix.divinerpg.objects.blocks.LogBase;
import naturix.divinerpg.objects.blocks.Spike;
import naturix.divinerpg.objects.blocks.SteelDoor;
import naturix.divinerpg.objects.blocks.TorchBase;
import naturix.divinerpg.objects.blocks.VineBase;
import naturix.divinerpg.objects.blocks.WorkshopCarpet;
import naturix.divinerpg.objects.blocks.arcana.Acceleron;
import naturix.divinerpg.objects.blocks.arcana.HeatTrap;
import naturix.divinerpg.objects.blocks.fluid.BlockTar;
import naturix.divinerpg.objects.blocks.portal.ApalachiaPortal;
import naturix.divinerpg.objects.blocks.portal.EdenBlock;
import naturix.divinerpg.objects.blocks.portal.IceikaPortal;
import naturix.divinerpg.objects.blocks.portal.MortumPortal;
import naturix.divinerpg.objects.blocks.portal.SkythernPortal;
import naturix.divinerpg.objects.blocks.portal.WildWoodPortal;
import naturix.divinerpg.objects.blocks.sapling.SaplingApalachia;
import naturix.divinerpg.objects.blocks.sapling.SaplingEden;
import naturix.divinerpg.objects.blocks.sapling.SaplingMortum;
import naturix.divinerpg.objects.blocks.sapling.SaplingSkythern;
import naturix.divinerpg.objects.blocks.sapling.SaplingWildwood;
import naturix.divinerpg.objects.blocks.tile.block.AltarDramix;
import naturix.divinerpg.objects.blocks.tile.block.AltarParasecta;
import naturix.divinerpg.objects.blocks.tile.block.BlockAyeracoBeam;
import naturix.divinerpg.objects.blocks.tile.block.BlockAyeracoSpawn;
import naturix.divinerpg.objects.blocks.tile.block.TEBed;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityCoalstoneFurnace;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityIceikaChest;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityDramixAltar;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityParasectaAltar;
import naturix.divinerpg.objects.blocks.vethia.Acid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	public static BlockOre oreArlemite = new BlockOre("ore_arlemite");
	public static BlockOre oreapalachia = new BlockOre("ore_apalachia");
	public static BlockOreNether orebloodgem = new BlockOreNether("ore_bloodgem");
	public static BlockOre oreMortum = new BlockOre("ore_mortum");
	public static BlockNetherite oreNetherite = new BlockNetherite("ore_netherite");
	public static BlockOre oreRupee = new BlockOre("ore_rupee");
	public static BlockOre oreSkythern = new BlockOre("ore_skythern");
	public static BlockOre oreWildwood = new BlockOre("ore_wildwood");
	public static BlockOre oreRealmite = new BlockOre("ore_realmite");
	public static BlockOre oreEden = new BlockOre("ore_eden");
	public static BeaconBaseBase blockArlemite = new BeaconBaseBase(Material.ROCK, "block_arlemite");
	public static BeaconBaseBase blockApalachia = new BeaconBaseBase(Material.ROCK, "block_apalachia");
	public static BeaconBaseBase blockMortum = new BeaconBaseBase(Material.ROCK, "block_mortum");
	public static BeaconBaseBase blockRupee = new BeaconBaseBase(Material.ROCK, "block_rupee");
	public static BeaconBaseBase blockSkythern = new BeaconBaseBase(Material.ROCK, "block_skythern");
	public static BeaconBaseBase blockWildWood = new BeaconBaseBase(Material.ROCK, "block_wildwood");
	public static BeaconBaseBase blockRealmite = new BeaconBaseBase(Material.ROCK, "block_realmite");
	public static BeaconBaseBase blockEden = new BeaconBaseBase(Material.ROCK, "block_eden");
	public static BeaconBaseBase blockBloodGem = new BeaconBaseBase(Material.ROCK, "block_bloodgem");
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
	public static TorchBase torchArcanium = new TorchBase(Material.CIRCUITS, "torch_arcanium");
	public static SaplingApalachia apalachiaSapling = new SaplingApalachia("sapling_apalachia");
	public static SaplingEden edenSapling = new SaplingEden("sapling_eden");
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
	// public static BedBase nightmarebed = new BedBase("bed_nightmare");
	public static AltarDramix altarDramix = new AltarDramix("altar_dramix");
	public static AltarParasecta altarParasecta = new AltarParasecta("altar_parasecta");
	public static HeatTrap heatTrap = new HeatTrap("heat_trap");
	public static HeatTrap heatTrapOn = new HeatTrap("heat_trap_on");
	public static Spike spikeCold = new Spike("spike_cold");
	public static Spike spikeHot = new Spike("spike_hot");
	public static Acid acidBacteria = new Acid("acid_bacterial", false, true);
	public static Acid acidBlock = new Acid("acid_block", true, false);
	public static Acid acidLunic = new Acid("acid_lunic", true, true);
	public static Acceleron acceleron = new Acceleron("acceleron");
	public static GrassBase grassArcana = new GrassBase("grass_arcana");
	public static EdenBlock portalEden = new EdenBlock("portal_eden", ModBlocks.blueFire);
	public static FireBase blueFire = new FireBase("fire_blue");
	public static BlockBase rockDivine = new BlockBase("rock_divine");
	public static BlockBase rockTwilight = new BlockBase("rock_twilight");
	public static DirtBase dirtEden = new DirtBase("dirt_eden");
	public static GrassBase grassEden = new GrassBase("grass_eden");
	public static BedBase bedDream = new BedBase("bed_dream");
	public static GrassBase grassWild = new GrassBase("grass_wildwood");
	public static BlockBase dirtWild = new BlockBase("dirt_wild");
	public static WildWoodPortal portalWild = new WildWoodPortal("portal_wild", ModBlocks.blueFire);
	public static VineBase vineWild = new VineBase("vine_wildwood");
	public static GrassBase grassApalachia = new GrassBase("grass_apalachia");
	public static BlockBase dirtApalachia = new BlockBase(Material.GROUND, "dirt_apalachia");
	public static ApalachiaPortal portalApalachia = new ApalachiaPortal("portal_apalachia", ModBlocks.blueFire);
	public static GrassBase grassSkythern = new GrassBase("grass_skythern");
	public static BlockBase dirtSkythern = new BlockBase("dirt_skythern");
	public static SkythernPortal portalSkythern = new SkythernPortal("portal_skythern", ModBlocks.blueFire);
	public static GrassBase grassMortum = new GrassBase("grass_mortum");
	public static BlockBase dirtMortum = new BlockBase("dirt_mortum");
	public static MortumPortal portalMortum = new MortumPortal("portal_mortum", ModBlocks.blueFire);
	public static GrassBase grassIceika = new GrassBase("grass_iceika");
	public static DirtBase dirtIceika = new DirtBase("dirt_iceika");
	public static IceikaPortal portalIceika = new IceikaPortal("portal_iceika", ModBlocks.blueFire);
	public static BlockBase stoneFrozen = new BlockBase(Material.ROCK, "stone_frozen");
	public static BlockBase stoneIcy = new BlockBase("stone_icy");
	public static BlockBase bricksIceika = new BlockBase("bricks_iceika");
	public static LeavesBase brittleLeaves = new LeavesBase("leaves_brittle");
	public static BlockModSpawner spawnerArcher = new BlockModSpawner("spawner_archer",
	        DivineRPG.modId + ".frost_archer");
	public static BlockModSpawner spawnerRollum = new BlockModSpawner("spawner_rollum", DivineRPG.modId + ".rollum");
	public static BlockTar tar = new BlockTar();
	public static BlockBase coalStone = new BlockBase("coalstone");
	public static BlockBase snowBricks = new BlockBase("snow_bricks");
	public static BlockBase workshopBookcase = new BlockBase("workshop_bookcase");
	public static FrostedGlass frostedGlass = new FrostedGlass("frosted_glass");
	public static WorkshopCarpet workshopCarpet = new WorkshopCarpet("workshop_carpet");
	public static CoalstoneFurnace coalstoneFurnace = new CoalstoneFurnace("coalstone_furnace");
	public static final IceikaChest iceikaChest = new IceikaChest("iceika_chest");

	// Has a unique class because i dont have a method for universal itemblocks for
	// doors - LiteWolf101
	public static SteelDoor steelDoor = new SteelDoor("steel_door", Material.ANVIL);

	public static Block ayeracoBeamBlue = new BlockAyeracoBeam("ayeracoBeamBlue", "blue");
	public static Block ayeracoBeamGreen = new BlockAyeracoBeam("ayeracoBeamGreen", "green");
	public static Block ayeracoBeamRed = new BlockAyeracoBeam("ayeracoBeamRed", "red");
	public static Block ayeracoBeamYellow = new BlockAyeracoBeam("ayeracoBeamYellow", "yellow");
	public static Block ayeracoBeamPurple = new BlockAyeracoBeam("ayeracoBeamPurple", "purple");
	public static Block ayeracoSpawn = new BlockAyeracoSpawn();

	public static void register(IForgeRegistry<Block> registry) {
		System.out.print("DivineRPG blocks loading");
		registry.registerAll(oreArlemite, oreapalachia, orebloodgem, oreMortum, oreNetherite, oreRupee, oreSkythern,
		        oreWildwood, oreRealmite, oreEden, blockArlemite, blockApalachia, blockMortum, blockRupee,
		        blockSkythern, blockWildWood, blockRealmite, blockEden, blockBloodGem, blockNetherite, oreArcanium,
		        blockAquaLamp, blockArlemiteLamp, blockBlazeLamp, blockCellLamp, blockDiamondLamp, blockDivineLamp,
		        blockDrakenLamp, blockDreamLamp, blockDungeonLamp, blockEdenLamp, blockEnderLamp, blockGoldLamp,
		        blockIceLamp, blockJungleLamp, blockKrakenLamp, blockLapisLazuliLamp, blockLavaLamp, blockMilkyLamp,
		        blockMoltenLamp, blockNetheriteLamp, blockRealmiteLamp, blockRedstoneLamp, blockRupeeLamp,
		        blockSlimeLamp, blockTerranLamp, blockVillageLamp, blockWorkshopLamp, divineLog, dreamLog, frozenLog,
		        hyreLog, mintLog, edenLog, fireLog, wildwoodLog, apalachiaLog, skythernLog, mortumLog, divineLeaves,
		        dreamLeaves,
		        // frozenLeaves,
		        hyreLeaves, mintLeaves, edenLeaves, fireLeaves, wildwoodLeaves, apalachiaLeaves, skythernLeaves,
		        mortumLeaves, torchSkeleton, torchAqua, torchEden, torchArcanium, apalachiaSapling,
		        // divineSapling,
		        // dreamSapling,
		        // frozenSapling,
		        // hyreSapling,
		        // mintSapling,
		        edenSapling,
		        // fireSapling,
		        wildwoodSapling, skythernSapling, mortumSapling, watcherStatue, ancientEntityStatue, ayeracoHordeStatue,
		        densosStatue, dexZichileStatue, dramixStatue, kingScorcherStatue, reyvorStatue, soulFiendStatue,
		        twilightDemonStatue, vamacheronStatue, altarDramix, altarParasecta, heatTrap, heatTrapOn, spikeCold,
		        spikeHot, acidBacteria, acidBlock, acidLunic, acceleron, grassArcana, portalEden, rockDivine, dirtEden,
		        grassEden, blueFire, rockTwilight, bedDream, grassWild, dirtWild, portalWild, vineWild, grassApalachia,
		        dirtApalachia, portalApalachia, grassSkythern, dirtSkythern, portalSkythern, grassMortum, dirtMortum,
		        portalMortum, grassIceika, dirtIceika, portalIceika, stoneFrozen, stoneIcy, bricksIceika, spawnerArcher,
		        spawnerRollum, brittleLeaves, tar, coalStone, snowBricks, workshopBookcase, frostedGlass,
		        workshopCarpet, steelDoor, coalstoneFurnace, iceikaChest);
		GameRegistry.registerTileEntity(TileEntityDramixAltar.class,
		        new ModelResourceLocation(DivineRPG.modId + ":" + altarDramix.getUnlocalizedName(), "inventory"));
		GameRegistry.registerTileEntity(TileEntityParasectaAltar.class,
		        new ModelResourceLocation(DivineRPG.modId + ":" + altarParasecta.getUnlocalizedName(), "inventory"));
		GameRegistry.registerTileEntity(TEBed.class,
		        new ModelResourceLocation(DivineRPG.modId + ":" + bedDream.getUnlocalizedName(), "inventory"));
		GameRegistry.registerTileEntity(TileEntityCoalstoneFurnace.class, DivineRPG.modId + ":te_coalstone_furnace");
		GameRegistry.registerTileEntity(TileEntityIceikaChest.class, DivineRPG.modId + ":te_iceika_chest");

	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(oreArlemite.createItemBlock(), oreapalachia.createItemBlock(),
		        orebloodgem.createItemBlock(), oreMortum.createItemBlock(), oreNetherite.createItemBlock(),
		        oreRupee.createItemBlock(), oreSkythern.createItemBlock(), oreWildwood.createItemBlock(),
		        oreRealmite.createItemBlock(), oreEden.createItemBlock(), blockArlemite.createItemBlock(),
		        blockApalachia.createItemBlock(), blockMortum.createItemBlock(), blockRupee.createItemBlock(),
		        blockSkythern.createItemBlock(), blockWildWood.createItemBlock(), blockRealmite.createItemBlock(),
		        blockEden.createItemBlock(), blockBloodGem.createItemBlock(), blockNetherite.createItemBlock(),
		        oreArcanium.createItemBlock(), blockAquaLamp.createItemBlock(), blockArlemiteLamp.createItemBlock(),
		        blockBlazeLamp.createItemBlock(), blockCellLamp.createItemBlock(), blockDiamondLamp.createItemBlock(),
		        blockDivineLamp.createItemBlock(), blockDrakenLamp.createItemBlock(), blockDreamLamp.createItemBlock(),
		        blockDungeonLamp.createItemBlock(), blockEdenLamp.createItemBlock(), blockEnderLamp.createItemBlock(),
		        blockGoldLamp.createItemBlock(), blockIceLamp.createItemBlock(), blockJungleLamp.createItemBlock(),
		        blockKrakenLamp.createItemBlock(), blockLapisLazuliLamp.createItemBlock(),
		        blockLavaLamp.createItemBlock(), blockMilkyLamp.createItemBlock(), blockMoltenLamp.createItemBlock(),
		        blockNetheriteLamp.createItemBlock(), blockRealmiteLamp.createItemBlock(),
		        blockRedstoneLamp.createItemBlock(), blockRupeeLamp.createItemBlock(), blockSlimeLamp.createItemBlock(),
		        blockTerranLamp.createItemBlock(), blockVillageLamp.createItemBlock(),
		        blockWorkshopLamp.createItemBlock(), divineLog.createItemBlock(), dreamLog.createItemBlock(),
		        frozenLog.createItemBlock(), hyreLog.createItemBlock(), mintLog.createItemBlock(),
		        edenLog.createItemBlock(), fireLog.createItemBlock(), wildwoodLog.createItemBlock(),
		        apalachiaLog.createItemBlock(), skythernLog.createItemBlock(), mortumLog.createItemBlock(),
		        divineLeaves.createItemBlock(), dreamLeaves.createItemBlock(),
		        // frozenLeaves.createItemBlock(),
		        hyreLeaves.createItemBlock(), mintLeaves.createItemBlock(), edenLeaves.createItemBlock(),
		        fireLeaves.createItemBlock(), wildwoodLeaves.createItemBlock(), apalachiaLeaves.createItemBlock(),
		        skythernLeaves.createItemBlock(), mortumLeaves.createItemBlock(), torchSkeleton.createItemBlock(),
		        torchAqua.createItemBlock(), torchEden.createItemBlock(), torchArcanium.createItemBlock(),
		        apalachiaSapling.createItemBlock(),
		        // divineSapling.createItemBlock(),
		        // dreamSapling.createItemBlock(),
		        // frozenSapling.createItemBlock(),
		        // hyreSapling.createItemBlock(),
		        // mintSapling.createItemBlock(),
		        edenSapling.createItemBlock(),
		        // fireSapling.createItemBlock(),
		        wildwoodSapling.createItemBlock(), skythernSapling.createItemBlock(), mortumSapling.createItemBlock(),
		        watcherStatue.createItemBlock(), ancientEntityStatue.createItemBlock(),
		        ayeracoHordeStatue.createItemBlock(), densosStatue.createItemBlock(),
		        dexZichileStatue.createItemBlock(), dramixStatue.createItemBlock(),
		        kingScorcherStatue.createItemBlock(), reyvorStatue.createItemBlock(), soulFiendStatue.createItemBlock(),
		        twilightDemonStatue.createItemBlock(), vamacheronStatue.createItemBlock(),
		        altarDramix.createItemBlock(), altarParasecta.createItemBlock(), heatTrap.createItemBlock(),
		        spikeCold.createItemBlock(), spikeHot.createItemBlock(), acidBacteria.createItemBlock(),
		        acidBlock.createItemBlock(), acidLunic.createItemBlock(), acceleron.createItemBlock(),
		        grassArcana.createItemBlock(), portalEden.createItemBlock(), rockDivine.createItemBlock(),
		        dirtEden.createItemBlock(), grassEden.createItemBlock(), blueFire.createItemBlock(),
		        rockTwilight.createItemBlock(), bedDream.createItemBlock(), grassWild.createItemBlock(),
		        dirtWild.createItemBlock(), portalWild.createItemBlock(), vineWild.createItemBlock(),
		        grassApalachia.createItemBlock(), dirtApalachia.createItemBlock(), portalApalachia.createItemBlock(),
		        grassSkythern.createItemBlock(), dirtSkythern.createItemBlock(), portalSkythern.createItemBlock(),
		        grassMortum.createItemBlock(), dirtMortum.createItemBlock(), portalMortum.createItemBlock(),
		        grassIceika.createItemBlock(), dirtIceika.createItemBlock(), portalIceika.createItemBlock(),
		        stoneFrozen.createItemBlock(), stoneIcy.createItemBlock(), bricksIceika.createItemBlock(),
		        spawnerArcher.createItemBlock(), brittleLeaves.createItemBlock(), spawnerRollum.createItemBlock(),
		        coalStone.createItemBlock(), snowBricks.createItemBlock(), workshopBookcase.createItemBlock(),
		        frostedGlass.createItemBlock(), workshopCarpet.createItemBlock(), coalstoneFurnace.createItemBlock(),
		        iceikaChest.createItemBlock()
		// nightmarebed.createItemBlock()
		);
	}

	public static void registerModels() {
		oreArlemite.registerItemModel();
		oreapalachia.registerItemModel();
		orebloodgem.registerItemModel();
		oreMortum.registerItemModel();
		oreNetherite.registerItemModel();
		oreRupee.registerItemModel();
		oreSkythern.registerItemModel();
		oreWildwood.registerItemModel();
		oreRealmite.registerItemModel();
		oreEden.registerItemModel();
		blockArlemite.registerItemModel();
		blockApalachia.registerItemModel();
		blockMortum.registerItemModel();
		blockRupee.registerItemModel();
		blockSkythern.registerItemModel();
		blockWildWood.registerItemModel();
		blockRealmite.registerItemModel();
		blockEden.registerItemModel();
		blockBloodGem.registerItemModel();
		blockNetherite.registerItemModel();
		oreArcanium.registerItemModel();
		blockAquaLamp.registerItemModel();
		blockArlemiteLamp.registerItemModel();
		blockBlazeLamp.registerItemModel();
		blockCellLamp.registerItemModel();
		blockDiamondLamp.registerItemModel();
		blockDivineLamp.registerItemModel();
		blockDrakenLamp.registerItemModel();
		blockDreamLamp.registerItemModel();
		blockDungeonLamp.registerItemModel();
		blockEdenLamp.registerItemModel();
		blockEnderLamp.registerItemModel();
		blockGoldLamp.registerItemModel();
		blockIceLamp.registerItemModel();
		blockJungleLamp.registerItemModel();
		blockKrakenLamp.registerItemModel();
		blockLapisLazuliLamp.registerItemModel();
		blockLavaLamp.registerItemModel();
		blockMilkyLamp.registerItemModel();
		blockMoltenLamp.registerItemModel();
		blockNetheriteLamp.registerItemModel();
		blockRealmiteLamp.registerItemModel();
		blockRedstoneLamp.registerItemModel();
		blockRupeeLamp.registerItemModel();
		blockSlimeLamp.registerItemModel();
		blockTerranLamp.registerItemModel();
		blockVillageLamp.registerItemModel();
		blockWorkshopLamp.registerItemModel();
		divineLog.registerItemModel();
		dreamLog.registerItemModel();
		frozenLog.registerItemModel();
		hyreLog.registerItemModel();
		mintLog.registerItemModel();
		edenLog.registerItemModel();
		fireLog.registerItemModel();
		wildwoodLog.registerItemModel();
		apalachiaLog.registerItemModel();
		skythernLog.registerItemModel();
		mortumLog.registerItemModel();
		divineLog.registerItemModel();
		divineLeaves.registerItemModel();
		dreamLeaves.registerItemModel();
		hyreLeaves.registerItemModel();
		mintLeaves.registerItemModel();
		edenLeaves.registerItemModel();
		fireLeaves.registerItemModel();
		wildwoodLeaves.registerItemModel();
		apalachiaLeaves.registerItemModel();
		skythernLeaves.registerItemModel();
		mortumLeaves.registerItemModel();
		torchSkeleton.registerItemModel();
		torchAqua.registerItemModel();
		torchEden.registerItemModel();
		torchArcanium.registerItemModel();
		apalachiaSapling.registerItemModel();
		edenSapling.registerItemModel();
		wildwoodSapling.registerItemModel();
		skythernSapling.registerItemModel();
		mortumSapling.registerItemModel();
		watcherStatue.registerItemModel();
		ancientEntityStatue.registerItemModel();
		ayeracoHordeStatue.registerItemModel();
		densosStatue.registerItemModel();
		dexZichileStatue.registerItemModel();
		dramixStatue.registerItemModel();
		kingScorcherStatue.registerItemModel();
		reyvorStatue.registerItemModel();
		soulFiendStatue.registerItemModel();
		twilightDemonStatue.registerItemModel();
		vamacheronStatue.registerItemModel();

		altarDramix.registerItemModel();
		altarParasecta.registerItemModel();
		heatTrap.registerItemModel();
		spikeCold.registerItemModel();
		spikeHot.registerItemModel();
		acidBacteria.registerItemModel();
		acidBlock.registerItemModel();
		acidLunic.registerItemModel();
		acceleron.registerItemModel();
		grassArcana.registerItemModel();
		portalEden.registerItemModel();
		rockDivine.registerItemModel();
		dirtEden.registerItemModel();
		grassEden.registerItemModel();
		blueFire.registerItemModel();
		rockTwilight.registerItemModel();
		bedDream.registerItemModel();
		grassWild.registerItemModel();
		dirtWild.registerItemModel();
		portalWild.registerItemModel();
		vineWild.registerItemModel();
		grassApalachia.registerItemModel();
		dirtApalachia.registerItemModel();
		portalApalachia.registerItemModel();
		grassSkythern.registerItemModel();
		dirtSkythern.registerItemModel();
		portalSkythern.registerItemModel();
		grassMortum.registerItemModel();
		dirtMortum.registerItemModel();
		portalMortum.registerItemModel();
		grassIceika.registerItemModel();
		dirtIceika.registerItemModel();
		portalIceika.registerItemModel();
		stoneFrozen.registerItemModel();
		stoneIcy.registerItemModel();
		bricksIceika.registerItemModel();
		spawnerArcher.registerItemModel();
		brittleLeaves.registerItemModel();
		spawnerRollum.registerItemModel();
		tar.initModel();
		coalStone.registerItemModel();
		snowBricks.registerItemModel();
		workshopBookcase.registerItemModel();
		frostedGlass.registerItemModel();
		workshopCarpet.registerItemModel();
		coalstoneFurnace.registerItemModel();
		iceikaChest.registerItemModel();
		// nightmarebed.registerItemModel(Item.getItemFromBlock(nightmarebed));

		DivineRPG.logger.info(DivineRPG.name + " blocks are loaded");
	}
}