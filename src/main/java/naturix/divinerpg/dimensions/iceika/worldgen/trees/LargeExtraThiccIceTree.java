package naturix.divinerpg.dimensions.iceika.worldgen.trees;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

/**
 * Created by LiteWolf101 on Jan
 * /24/2019
 */
public class LargeExtraThiccIceTree extends WorldGenAbstractTree {
    private int minTrunkHeight = 7;
    protected IBlockState log = ModBlocks.frozenLog.getDefaultState();
    protected IBlockState leaves = ModBlocks.brittleLeaves.getDefaultState();

    public LargeExtraThiccIceTree(boolean notify, int minTrunkHeight) {
        super(notify);
        this.minTrunkHeight = minTrunkHeight;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos blockPos) {
        int trunkHeight = rand.nextInt(5) + minTrunkHeight;
        int branchSectionNum = rand.nextInt(2) + 4;
        int bottomLayerHeight = 3;
        int treeHeight = trunkHeight + bottomLayerHeight + (branchSectionNum * 4);
        Material materialBelow = worldIn.getBlockState(blockPos.down()).getMaterial();
        if (blockPos.getY() <= worldIn.getSeaLevel() && blockPos.getY() + treeHeight + 1 >= worldIn.getHeight() || materialBelow != Material.GRASS && materialBelow != Material.GROUND) {
            return false;
        }
        generateTrunk(worldIn, blockPos, trunkHeight);
        generateBottomLayer(worldIn, blockPos, trunkHeight);
        generateBranchLayer(worldIn, blockPos, branchSectionNum, trunkHeight + bottomLayerHeight + 1);
        return true;
    }

    private void generateTrunk(World worldIn, BlockPos blockPos, int trunkHeight) {
        for (int y = 0; y <= trunkHeight; y++) {
            setBlockAndNotifyAdequately(worldIn, blockPos.up(y), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 0), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 1), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(0, y, 1), log);
        }
    }

    private void generateBottomLayer(World worldIn, BlockPos blockPos, int trunkHeight) {
        for (int x = -3; x <= 4; x++) {
            for (int z = -4; z <= 5; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight, z), leaves);
            }
        }
        for (int x = -4; x <= 5; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight, z), log);
            }
        }
        for (int x = -3; x <= 4; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight, z), log);
            }
        }

        for (int x = -2; x <= 3; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight, z), leaves);
            }
        }
        for (int x = -3; x <= 4; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight, z), log);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight, z), log);
            }
        }

        for (int x = -1; x <= 2; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight, z), leaves);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight, z), log);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight, z), log);
            }
        }

        for (int y = trunkHeight + 1; y <= trunkHeight + 3; y++) {
            setBlockAndNotifyAdequately(worldIn, blockPos.up(y), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 0), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 1), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(0, y, 1), log);
        }
    }

    private void generateBranchLayer(World worldIn, BlockPos blockPos, int branchSectionNum, int trunkHeight) {
        for (int y = 0; y <= branchSectionNum*4; y++) {
            if (y % 4 == 0) {
                for (int x = -4; x <= 5; x++) {
                    for (int z = -5; z <= 6; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = -5; x <= 6; x++) {
                    for (int z = -4; z <= 5; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = -1; x <= 2; x++) {
                    for (int z = -4; z <= 5; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), log);
                    }
                }
                for (int x = -4; x <= 5; x++) {
                    for (int z = -1; z <= 2; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), log);
                    }
                }
            }
            if (y % 4 == 1) {
                for (int x = -3; x <= 4; x++) {
                    for (int z = -4; z <= 5; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = -4; x <= 5; x++) {
                    for (int z = -3; z <= 4; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = 0; x <= 1; x++) {
                    for (int z = -3; z <= 4; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), log);
                    }
                }
                for (int x = -3; x <= 4; x++) {
                    for (int z = 0; z <= 1; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), log);
                    }
                }
            }
            if (y % 4 == 2) {
                for (int x = -2; x <= 3; x++) {
                    for (int z = -3; z <= 4; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = -3; x <= 4; x++) {
                    for (int z = -2; z <= 3; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = 0; x <= 1; x++) {
                    for (int z = -2; z <= 3; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), log);
                    }
                }
                for (int x = -2; x <= 3; x++) {
                    for (int z = 0; z <= 1; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), log);
                    }
                }
            }
            if (y % 4 == 3) {
                for (int x = -1; x <= 2; x++) {
                    for (int z = -2; z <= 3; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
                for (int x = -2; x <= 3; x++) {
                    for (int z = -1; z <= 2; z++) {
                        setBlockAndNotifyAdequately(worldIn, blockPos.add(x, y + trunkHeight, z), leaves);
                    }
                }
            }
            setBlockAndNotifyAdequately(worldIn, blockPos.up(y + trunkHeight), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y + trunkHeight, 0), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y + trunkHeight, 1), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(0, y + trunkHeight, 1), log);
        }
        //generate top
        //1
        for (int x = -3; x <= 4; x++) {
            for (int z = -4; z <= 5; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight + (branchSectionNum*4), z), leaves);
            }
        }
        for (int x = -4; x <= 5; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight + (branchSectionNum*4), z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -3; x <= 4; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 1 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }

        for (int x = -2; x <= 3; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight + (branchSectionNum*4), z), leaves);
            }
        }
        for (int x = -3; x <= 4; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight + (branchSectionNum*4), z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 2 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }

        for (int x = -1; x <= 2; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight + (branchSectionNum*4), z), leaves);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight + (branchSectionNum*4), z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 3 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        //2
        for (int x = -3; x <= 4; x++) {
            for (int z = -4; z <= 5; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 4, z), leaves);
            }
        }
        for (int x = -4; x <= 5; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 4, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 4 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -3; x <= 4; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 4 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }

        for (int x = -2; x <= 3; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 5, z), leaves);
            }
        }
        for (int x = -3; x <= 4; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 5, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 5 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 5 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }

        for (int x = -1; x <= 2; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 6, z), leaves);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 6, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 6 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 6 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }

        //3
        for (int x = -2; x <= 3; x++) {
            for (int z = -3; z <= 4; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 7, z), leaves);
            }
        }
        for (int x = -3; x <= 4; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 7, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 7 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 7 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }

        for (int x = -1; x <= 2; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 8, z), leaves);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 8, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 8 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, 8 + trunkHeight + (branchSectionNum*4), z), log);
            }
        }

        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 9, z), leaves);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 9, z), leaves);
            }
        }
        //4
        for (int x = -1; x <= 2; x++) {
            for (int z = -2; z <= 3; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 10, z), leaves);
            }
        }
        for (int x = -2; x <= 3; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 10, z), leaves);
            }
        }

        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 11, z), leaves);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 11, z), leaves);
            }
        }
        //5
        for (int x = 0; x <= 1; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 12, z), leaves);
            }
        }
        for (int x = 0; x <= 1; x++) {
            for (int z = -1; z <= 2; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 13, z), leaves);
            }
        }
        for (int x = -1; x <= 2; x++) {
            for (int z = 0; z <= 1; z++) {
                setBlockAndNotifyAdequately(worldIn, blockPos.add(x, (branchSectionNum*4) + trunkHeight + 13, z), leaves);
            }
        }
        for (int y = (branchSectionNum*4) + trunkHeight + 1; y <= (branchSectionNum*4) + trunkHeight + 11; y++) {
            setBlockAndNotifyAdequately(worldIn, blockPos.up(y), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 0), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(1, y, 1), log);
            setBlockAndNotifyAdequately(worldIn, blockPos.add(0, y, 1), log);
        }
    }

    protected boolean canGrowInto(Block blockType)
    {
        Material material = blockType.getDefaultState().getMaterial();
        return material == Material.AIR || material == Material.LEAVES || blockType == Blocks.GRASS || blockType == Blocks.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 || blockType == Blocks.SAPLING || blockType == Blocks.VINE;
    }

    protected void setDirtAt(World worldIn, BlockPos pos) {
        if (worldIn.getBlockState(pos).getBlock() != ModBlocks.dirtIceika) {
            this.setBlockAndNotifyAdequately(worldIn, pos, ModBlocks.dirtIceika.getDefaultState());
        }
    }

    public static int getDefaultMinTrunkHeight () {
        return 5;
    }
}
