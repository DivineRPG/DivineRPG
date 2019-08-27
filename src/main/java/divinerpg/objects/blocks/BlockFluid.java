package divinerpg.objects.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;

import java.util.Random;

public class BlockFluid extends BlockFluidClassic {
	public BlockFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));

		if (material == Material.LAVA) {
			setTickRandomly(true);
		}
	}

	@Override
	public void updateTick(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state, @Nonnull Random rand) {
		super.updateTick(world, pos, state, rand);

		/*
			Stolen from Lava block
		 */
		if (this.blockMaterial == Material.LAVA)
		{
			if (world.getGameRules().getBoolean("doFireTick"))
			{
				int i = rand.nextInt(3);

				if (i > 0)
				{
					BlockPos blockpos = pos;

					for (int j = 0; j < i; ++j)
					{
						blockpos = blockpos.add(rand.nextInt(3) - 1, 1, rand.nextInt(3) - 1);

						if (blockpos.getY() >= 0 && blockpos.getY() < world.getHeight() && !world.isBlockLoaded(blockpos))
						{
							return;
						}

						IBlockState block = world.getBlockState(blockpos);

						if (block.getBlock().isAir(block, world, blockpos))
						{
							if (this.isSurroundingBlockFlammable(world, blockpos))
							{
								world.setBlockState(blockpos, ForgeEventFactory.fireFluidPlaceBlockEvent(world, blockpos, pos, Blocks.FIRE.getDefaultState()));
								return;
							}
						}
						else if (block.getMaterial().blocksMovement())
						{
							return;
						}
					}
				}
				else
				{
					for (int k = 0; k < 3; ++k)
					{
						BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, 0, rand.nextInt(3) - 1);

						if (blockpos1.getY() >= 0 && blockpos1.getY() < 256 && !world.isBlockLoaded(blockpos1))
						{
							return;
						}

						if (world.isAirBlock(blockpos1.up()) && this.getCanBlockBurn(world, blockpos1))
						{
							world.setBlockState(blockpos1.up(), ForgeEventFactory.fireFluidPlaceBlockEvent(world, blockpos1.up(), pos, Blocks.FIRE.getDefaultState()));
						}
					}
				}
			}
		}
	}

	@Override
	@SuppressWarnings("deprecation")
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	/*
		Stolen from Lava Block
	 */
	private boolean isSurroundingBlockFlammable(World worldIn, BlockPos pos)
	{
		for (EnumFacing enumfacing : EnumFacing.values())
		{
			if (this.getCanBlockBurn(worldIn, pos.offset(enumfacing)))
			{
				return true;
			}
		}

		return false;
	}

	/*
		Stolen from Lava block
	 */
	private boolean getCanBlockBurn(World worldIn, BlockPos pos)
	{
		return pos.getY() >= 0 && pos.getY() < 256 && !worldIn.isBlockLoaded(pos) ? false : worldIn.getBlockState(pos).getMaterial().getCanBurn();
	}

	// Still stolen from lava
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double d0 = (double)pos.getX();
		double d1 = (double)pos.getY();
		double d2 = (double)pos.getZ();

		if (this.blockMaterial == Material.LAVA
				&& worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR
				&& !worldIn.getBlockState(pos.up()).isOpaqueCube())
		{
			if (rand.nextInt(100) == 0)
			{
				double d8 = d0 + (double)rand.nextFloat();
				double d4 = d1 + stateIn.getBoundingBox(worldIn, pos).maxY;
				double d6 = d2 + (double)rand.nextFloat();
				worldIn.spawnParticle(EnumParticleTypes.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D);
				worldIn.playSound(d8, d4, d6, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
			}

			if (rand.nextInt(200) == 0)
			{
				worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
			}
		}
	}
}