package naturix.divinerpg.utils.world;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

public class WorldGenTrees extends WorldGenerator {
	 private IBlockState blockStateWood = ModBlocks.apalachiaLog.getDefaultState();
	    private IBlockState blockStateLeaves = ModBlocks.apalachiaLeaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	    /** The minimum height of a generated tree. */
	    private final int minTreeHeight = 4;

	    public WorldGenTrees(boolean parShouldNotify)
	    {
	        super(parShouldNotify);
	    }

	    @Override
	    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos)
	    {
	        int minHeight = parRandom.nextInt(3) + minTreeHeight;
	        
	        // Check if tree fits in world
	        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight())
	        {
	            if (!isSuitableLocation(parWorld, parBlockPos, minHeight))
	            {
	                return false;
	            }
	            else
	            {
	                IBlockState state = parWorld.getBlockState(parBlockPos.down());

	                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1)
	                {
	                    state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);
	                    generateLeaves(parWorld, parBlockPos, minHeight, parRandom);
	                    generateTrunk(parWorld, parBlockPos, minHeight);
	                    DivineRPG.logger.info(blockStateWood + " tree has generated");
	                    return true;
	                }
	                else
	                {
	                    return false;
	                }
	            }
	        }
	        else
	        {
	            return false;
	        }
	    }

	    private void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom)
	    {
	        for (int foliageY = parBlockPos.getY() - 3 + height; foliageY <= parBlockPos.getY() + height; ++foliageY)
	        {
	            int foliageLayer = foliageY - (parBlockPos.getY() + height);
	            int foliageLayerRadius = 1 - foliageLayer / 2;

	            for (int foliageX = parBlockPos.getX() - foliageLayerRadius; foliageX <= parBlockPos.getX() + foliageLayerRadius; ++foliageX)
	            {
	                int foliageRelativeX = foliageX - parBlockPos.getX();

	                for (int foliageZ = parBlockPos.getZ() - foliageLayerRadius; foliageZ <= parBlockPos.getZ() + foliageLayerRadius; ++foliageZ)
	                {
	                    int foliageRelativeZ = foliageZ - parBlockPos.getZ();

	                    // Fill in layer with some randomness
	                    if (Math.abs(foliageRelativeX) != foliageLayerRadius || Math.abs(foliageRelativeZ) != foliageLayerRadius || parRandom.nextInt(2) != 0 && foliageLayer != 0)
	                    {
	                        BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
	                        IBlockState state = parWorld.getBlockState(blockPos);

	                        if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos))
	                        {
	                            setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
	                        }
	                    }
	                }
	            }
	        }
	    }

	    private void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight)
	    {
	        for (int height = 0; height < minHeight; ++height)
	        {
	            BlockPos upN = parBlockPos.up(height);
	            IBlockState state = parWorld.getBlockState(upN);

	            if (state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN))
	            {
	                setBlockAndNotifyAdequately(parWorld, parBlockPos.up(height), blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
	            }
	        }
	    }

	    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight)
	    {
	        boolean isSuitableLocation = true;
	        
	        for (int checkY = parBlockPos.getY(); checkY <= parBlockPos.getY() + 1 + minHeight; ++checkY)
	        {
	            // Handle increasing space towards top of tree
	            int extraSpaceNeeded = 1;
	            // Handle base location
	            if (checkY == parBlockPos.getY())
	            {
	                extraSpaceNeeded = 0;
	            }             
	            // Handle top location
	            if (checkY >= parBlockPos.getY() + 1 + minHeight - 2)
	            {
	                extraSpaceNeeded = 2;
	            }

	            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

	            for (int checkX = parBlockPos.getX() - extraSpaceNeeded; checkX <= parBlockPos.getX() + extraSpaceNeeded && isSuitableLocation; ++checkX)
	            {
	                for (int checkZ = parBlockPos.getZ() - extraSpaceNeeded; checkZ <= parBlockPos.getZ() + extraSpaceNeeded && isSuitableLocation; ++checkZ)
	                {
	                    isSuitableLocation = isReplaceable(parWorld,blockPos.setPos(checkX, checkY, checkZ));
	                }
	            }
	        }
	        
	        return isSuitableLocation;
	    }

		private boolean isReplaceable(World parWorld, MutableBlockPos setPos) {
			// TODO Auto-generated method stub
			return false;
		}
	}