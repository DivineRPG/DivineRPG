package naturix.divinerpg.objects.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModDoubleSlab extends BlockMod {

	Block drop2;

	public BlockModDoubleSlab(String name2, Block drop) {
		super(Material.WOOD, name2);
		drop2 = drop;
		this.setHarvestLevel("axe", 0);
	}

	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
		if (!worldIn.isRemote && !worldIn.restoringBlockSnapshots) // do not drop items while restoring blockstates,
		                                                           // prevents item dupe
		{
			List<ItemStack> drops = getDrops(worldIn, pos, state, fortune); // use the old method until it gets removed,
			                                                                // for backward compatibility
			chance = net.minecraftforge.event.ForgeEventFactory.fireBlockHarvesting(drops, worldIn, pos, state, fortune,
			        chance, false, harvesters.get());

			for (ItemStack drop : drops) {
				if (worldIn.rand.nextFloat() <= chance) {
					spawnAsEntity(worldIn, pos, drop);
					spawnAsEntity(worldIn, pos, drop);
				}
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (drop2 == null) {
			return Item.getItemFromBlock(this);
		}
		return Item.getItemFromBlock(drop2);
	}

	@Override
	public int quantityDropped(Random random) {
		return 2;
	}
}
