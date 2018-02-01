package naturix.divinerpg;

import naturix.divinerpg.bases.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	public static BlockOre oreArlemite = new BlockOre("ore_arlemite");
	public static BlockOre oreapalachia = new BlockOre("ore_apalachia");
	public static BlockOreNether orebloodgem = new BlockOreNether("ore_bloodgem");
	public static BlockOre oremortum = new BlockOre("ore_mortum");
	public static BlockOreNether oreNetherite = new BlockOreNether("ore_netherite");
	public static BlockOre oreRupee = new BlockOre("ore_rupee");
	public static BlockOre oreSkythern = new BlockOre("ore_skythern");
	public static BlockOre oreWildwood = new BlockOre("ore_wildwood");
	public static BlockOre oreRealmite = new BlockOre("ore_realmite");
	public static BlockOre oreEden = new BlockOre("ore_eden");
	public static BeaconBase blockArlemite = new BeaconBase(Material.ROCK, "block_arlemite");
	public static BeaconBase blockApalachia = new BeaconBase(Material.ROCK, "block_apalachia");
	public static BeaconBase blockMortum = new BeaconBase(Material.ROCK, "block_mortum");
	public static BeaconBase blockRupee= new BeaconBase(Material.ROCK, "block_rupee");
	public static BeaconBase blockSkythern = new BeaconBase(Material.ROCK, "block_skythern");
	public static BeaconBase blockWildWood = new BeaconBase(Material.ROCK, "block_wildwood");
	public static BeaconBase blockRealmite = new BeaconBase(Material.ROCK, "block_realmite");
	public static BeaconBase blockEden = new BeaconBase(Material.ROCK, "block_eden");
	public static BeaconBase blockBloodGem= new BeaconBase(Material.ROCK, "block_bloodgem");
	public static BeaconBase blockNetherite = new BeaconBase(Material.ROCK, "block_netherite");
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
				blockWorkshopLamp
		);
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
				blockWorkshopLamp.createItemBlock()
				);
	}
	
	public static void registerModels() {
		System.out.print("DivineRPG blocks loaded");
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
	}

}