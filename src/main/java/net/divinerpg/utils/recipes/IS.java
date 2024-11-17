package net.divinerpg.utils.recipes;

import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.items.TwilightItemsWeapons;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.items.VanillaItemsTools;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class IS {
	//Food
	public static ItemStack bacon = new ItemStack(ItemsFood.bacon, 6);
	public static ItemStack cheese = new ItemStack(ItemsFood.cheese, 3);
			
	//Weapons
	public static ItemStack shuriken = new ItemStack(VanillaItemsWeapons.shuriken, 20);

	//Materials
	public static ItemStack arlemiteIngot = new ItemStack(VanillaItemsOther.arlemiteIngot, 9);
	public static ItemStack rupeeIngot = new ItemStack(VanillaItemsOther.rupeeIngot, 9);
	public static ItemStack realIngot = new ItemStack(VanillaItemsOther.realmiteIngot, 9);
	public static ItemStack netherIngot = new ItemStack(VanillaItemsOther.netheriteIngot, 9);
	public static ItemStack bloodgem = new ItemStack(VanillaItemsOther.bloodgem, 9);
	public static ItemStack edenFragments = new ItemStack(TwilightItemsOther.edenFragments, 9);
	public static ItemStack wildwoodFragments = new ItemStack(TwilightItemsOther.wildwoodFragments, 9);
	public static ItemStack apalachiaFragments = new ItemStack(TwilightItemsOther.apalachiaFragments, 9);
	public static ItemStack skythernFragments = new ItemStack(TwilightItemsOther.skythernFragments, 9);
	public static ItemStack mortumFragments = new ItemStack(TwilightItemsOther.mortumFragments, 9);
	public static ItemStack eyeShards = new ItemStack(VanillaItemsOther.cyclopsEyeShards, 9);

	//Blocks
	public static ItemStack bedrock = new ItemStack(Blocks.bedrock, 3);
	public static ItemStack divinePlanks = new ItemStack(VanillaBlocks.divinePlanks, 4);
}
