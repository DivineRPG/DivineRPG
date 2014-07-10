package net.divinerpg.dimensions.vanilla;

import java.util.Random;

import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDivineDungeon extends WorldGenerator {

	private ItemStack[] items = new ItemStack[] {new ItemStack(VanillaItemsOther.rupeeIngot), new ItemStack(VanillaItemsOther.arlemiteIngot), new ItemStack(VanillaItemsOther.bloodgem),
			new ItemStack(VanillaItemsOther.realmiteIngot), new ItemStack(VanillaItemsOther.netheriteIngot)};

	@Override
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
		byte b0 = 3;
		int l = par2Random.nextInt(2) + 2;
		int i1 = par2Random.nextInt(2) + 2;
		int j1 = 0, k1, l1, i2;

		for(k1 = par3 - l - 1; k1 <= par3 + l + 1; ++k1) {
			for(l1 = par4 - 1; l1 <= par4 + b0 + 1; ++l1) {
				for(i2 = par5 - i1 - 1; i2 <= par5 + i1 + 1; ++i2) {
					Material material = par1World.getBlock(k1, l1, i2).getMaterial();
					if(l1 == par4 - 1 && !material.isSolid()) return false;      
					if(l1 == par4 + b0 + 1 && !material.isSolid()) return false;
					if((k1 == par3 - l - 1 || k1 == par3 + l + 1 || i2 == par5 - i1 - 1 || i2 == par5 + i1 + 1) && l1 == par4 && par1World.isAirBlock(k1, l1, i2) && par1World.isAirBlock(k1, l1 + 1, i2))
						++j1;
				}
			}
		}

		if(j1 >= 1 && j1 <= 5) {
			for(k1 = par3 - l - 1; k1 <= par3 + l + 1; ++k1) {
				for(l1 = par4 + b0; l1 >= par4 - 1; --l1) {
					for(i2 = par5 - i1 - 1; i2 <= par5 + i1 + 1; ++i2) {
						if(k1 != par3 - l - 1 && l1 != par4 - 1 && i2 != par5 - i1 - 1 && k1 != par3 + l + 1 && l1 != par4 + b0 + 1 && i2 != par5 + i1 + 1)
							par1World.setBlockToAir(k1, l1, i2);

						else if(l1 >= 0 && !par1World.getBlock(k1, l1 - 1, i2).getMaterial().isSolid())
							par1World.setBlockToAir(k1, l1, i2);

						else if(par1World.getBlock(k1, l1, i2).getMaterial().isSolid()) {
							if(l1 == par4 - 1 && par2Random.nextInt(4) != 0) par1World.setBlock(k1, l1, i2, VanillaBlocks.divineMossystone, 0, 2);
							else par1World.setBlock(k1, l1, i2, Blocks.cobblestone, 0, 2);
						}
					}
				}
			}
			k1 = 0;
			while(k1 < 2) {
				l1 = 0;
				while(true) {
					if(l1 < 3) {
						label101: {
						i2 = par3 + par2Random.nextInt(l * 2 + 1) - l;
						int j2 = par5 + par2Random.nextInt(i1 * 2 + 1) - i1;
						if (par1World.isAirBlock(i2, par4, j2)) {
							int k2 = 0;
							if(par1World.getBlock(i2 - 1, par4, j2).getMaterial().isSolid()) ++k2;
							if(par1World.getBlock(i2 + 1, par4, j2).getMaterial().isSolid()) ++k2;
							if(par1World.getBlock(i2, par4, j2 - 1).getMaterial().isSolid()) ++k2;
							if(par1World.getBlock(i2, par4, j2 + 1).getMaterial().isSolid()) ++k2;
							if(k2 == 1) {
								par1World.setBlock(i2, par4, j2, Blocks.chest, 0, 2);
								TileEntityChest tileentitychest = (TileEntityChest)par1World.getTileEntity(i2, par4, j2);
								if(tileentitychest != null && items != null) {
									for(ItemStack item : items){
										for(int i = 0; i < par2Random.nextInt(5) + 1; i++){
											tileentitychest.setInventorySlotContents(par2Random.nextInt(26) + 1, item);
										}
									}
								}
								break label101;
							}
						}
						++l1;
						continue;
					}
					}
					++k1;
					break;
				}
			}

			par1World.setBlock(par3, par4, par5, VanillaBlocks.divineMobSpawner, 0, 2);
			TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getTileEntity(par3, par4, par5);

			if(tileentitymobspawner != null) tileentitymobspawner.func_145881_a().setEntityName(this.pickMobSpawner(par2Random));
			else System.err.println("[DivineRPG] Failed to fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
			return true;
		}
		else return false;
	}

	private String pickMobSpawner(Random par1Random) {
		return DivineDungeonHooks.getRandomDungeonMob(par1Random);
	}
}
