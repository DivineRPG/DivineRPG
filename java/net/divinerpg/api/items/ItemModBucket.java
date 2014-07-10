package net.divinerpg.api.items;

import java.util.Random;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.dimensions.iceika.village.WorldGenHouse1;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModBucket extends ItemBucket {

	protected String name;

	public ItemModBucket(Block liquid, String name) {
		super(liquid);
		this.name = name;
		setCreativeTab(DivineRPGTabs.utility);
		setTextureName(Reference.PREFIX + name);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World w, int x, int y, int z, int i1, float f, float f1, float f2) {
		//calebsWork(w, x, y, z);
		return true;
	}

	public void calebsWork(World world, int x, int y, int z){
		Random rand = new Random();
		final int height = 20 + rand.nextInt(10);
		final int leafStart = 1 + rand.nextInt(12);
		final int leafHeight = height - leafStart;

		int width = 6;
		int xChange = 2;

		/*for (int down = height; down >= leafStart; down-=4) {
        	WorldGenAPI.addRectangle(width, width, 1, world, x-xChange, y + down, z-xChange, IceikaBlocks.brittleLeaves);
        	width+=2;
        	xChange++;
        }*/
		WorldGenAPI.addCornerlessRectangle(4, 4, leafHeight - 1, world, x-1, y + leafStart, z-1, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addCornerlessRectangle(4, 4, 1, world, x-1, y + height, z-1, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(2, 2, 1, world, x, y + height + 1, z, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(2, 2, height, world, x, y, z, IceikaBlocks.frozenWood);
	}
}
