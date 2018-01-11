package naturix.divinerpg;

import naturix.divinerpg.utils.blocknitems.BlockBase;
import naturix.divinerpg.utils.blocknitems.BlockOre;
import naturix.divinerpg.utils.blocknitems.BlockOreNether;
import naturix.divinerpg.utils.blocknitems.LampBase;
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
	public static BlockBase blockArlemite = new BlockBase(Material.ROCK, "block_arlemite");
	public static BlockBase blockApalachia = new BlockBase(Material.ROCK, "block_apalachia");
	public static BlockBase blockMortum = new BlockBase(Material.ROCK, "block_mortum");
	public static BlockBase blockRupee= new BlockBase(Material.ROCK, "block_rupee");
	public static BlockBase blockSkythern = new BlockBase(Material.ROCK, "block_skythern");
	public static BlockBase blockWildWood = new BlockBase(Material.ROCK, "block_wildwood");
	public static BlockBase blockRealmite = new BlockBase(Material.ROCK, "block_realmite");
	public static BlockBase blockEden = new BlockBase(Material.ROCK, "block_eden");
	public static BlockBase blockBloodGem= new BlockBase(Material.ROCK, "block_bloodgem");
	public static BlockBase blockNetherite = new BlockBase(Material.ROCK, "block_netherite");
	public static BlockOre oreArcanium = new BlockOre("ore_arcanium");
	public static LampBase blockArcaniumLamp = new LampBase(false, "block_arcanium_lamp", false);
	
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
				blockArcaniumLamp
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
				blockArcaniumLamp.createItemBlock()
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
		blockArcaniumLamp.registerItemModel(Item.getItemFromBlock(blockArcaniumLamp));
	}

}