package naturix.divinerpg.bases.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GrassBase extends BlockGrass {

	protected String name;
	public GrassBase(String name) {
		super();
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.BlocksTab);
		this.setHardness(1);
		this.setHarvestLevel("shovel", 0);
	}

	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
	{
		return true;
  	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2)
            {
                worldIn.setBlockState(pos, ModBlocks.dirtEden.getDefaultState());
            }
            else
            {
                if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
                {
                    for (int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos))
                        {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == ModBlocks.dirtEden && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(worldIn, pos.up()) <= 2)
                        {
                        	if(this == ModBlocks.grassEden) {
                            worldIn.setBlockState(blockpos, ModBlocks.grassEden.getDefaultState());
                        }
                       }
                    }
                }
            }
        }
    }
	
	Item returns;
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		
		if (state == ModBlocks.grassEden.getDefaultState()) {
			returns = Item.getItemFromBlock(ModBlocks.dirtEden);
		}
		if (state == ModBlocks.grassArcana.getDefaultState()) {
			returns = Item.getItemFromBlock(ModBlocks.dirtEden);
		}
		if (state == ModBlocks.grassWild.getDefaultState()) {
			returns = Item.getItemFromBlock(ModBlocks.dirtWild);
		}
		if (state == ModBlocks.grassApalachia.getDefaultState()) {
			returns = Item.getItemFromBlock(ModBlocks.dirtApalachia);
		}
		if (state == ModBlocks.grassSkythern.getDefaultState()) {
			returns = Item.getItemFromBlock(ModBlocks.dirtSkythern);
		}
		if (state == ModBlocks.grassMortum.getDefaultState()) {
			returns = Item.getItemFromBlock(ModBlocks.dirtMortum);
		}
		if (state == ModBlocks.grassIceika.getDefaultState()) {
			returns = Item.getItemFromBlock(ModBlocks.dirtIceika);
		}
		DivineRPG.logger.info(state.getBlock().getLocalizedName() + " drops " + returns.getUnlocalizedName());
        return returns;
    }
}