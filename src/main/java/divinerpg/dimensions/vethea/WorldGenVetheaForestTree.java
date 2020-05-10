package divinerpg.dimensions.vethea;

import java.util.Iterator;
import java.util.Random;

import divinerpg.dimensions.vethea.WorldGenVetheaTree;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Copy-pasted version of Vanilla's WorldGenTrees class with some changes.
 * Still contains boiler plate code for cocoa beans and leaves because apparently that class handles all tree types in the overworld
 */
public abstract class WorldGenVetheaForestTree extends WorldGenVetheaTree {
    private final int minTreeHeight;
    private final boolean vinesGrow;
    private final IBlockState metaWood;
    private final IBlockState metaLeaves;

    public WorldGenVetheaForestTree(boolean notify, IBlockState wood, IBlockState leaves) {
        this(notify, 4, wood, leaves, false);
    }

    public WorldGenVetheaForestTree(boolean notify, int minTreeHeightIn, IBlockState wood, IBlockState leaves, boolean growVines) {
        super(notify);
        this.minTreeHeight = minTreeHeightIn;
        this.metaWood = wood;
        this.metaLeaves = leaves;
        this.vinesGrow = growVines;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int i = rand.nextInt(3) + this.minTreeHeight;
        boolean flag = true;
        if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getHeight()) {
            int l3;
            int i4;
            for(int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
                int k = 1;
                if (j == position.getY()) {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2) {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for(l3 = position.getX() - k; l3 <= position.getX() + k && flag; ++l3) {
                    for(i4 = position.getZ() - k; i4 <= position.getZ() + k && flag; ++i4) {
                        if (j >= 0 && j < worldIn.getHeight()) {
                            if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.setPos(l3, j, i4))) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                IBlockState state = worldIn.getBlockState(position.down());
                if (state.getBlock() == ModBlocks.dreamGrass || state.getBlock() == ModBlocks.dreamDirt) {
                    state.getBlock().onPlantGrow(state, worldIn, position.down(), position);
                    boolean k2 = true;
                    boolean l2 = false;

                    int k4;
                    int l4;
                    int i5;
                    BlockPos blockpos3;
                    for(l3 = position.getY() - 3 + i; l3 <= position.getY() + i; ++l3) {
                        i4 = l3 - (position.getY() + i);
                        k4 = 1 - i4 / 2;

                        for(int k1 = position.getX() - k4; k1 <= position.getX() + k4; ++k1) {
                            l4 = k1 - position.getX();

                            for(i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5) {
                                int j2 = i5 - position.getZ();
                                if (Math.abs(l4) != k4 || Math.abs(j2) != k4 || rand.nextInt(2) != 0 && i4 != 0) {
                                    blockpos3 = new BlockPos(k1, l3, i5);
                                    state = worldIn.getBlockState(blockpos3);
                                    if (state.getBlock().isAir(state, worldIn, blockpos3) || state.getBlock().isLeaves(state, worldIn, blockpos3) || state.getMaterial() == Material.VINE) {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos3, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for(l3 = 0; l3 < i; ++l3) {
                        BlockPos upN = position.up(l3);
                        state = worldIn.getBlockState(upN);
                        if (state.getBlock().isAir(state, worldIn, upN) || state.getBlock().isLeaves(state, worldIn, upN) || state.getMaterial() == Material.VINE) {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(l3), this.metaWood);
                            if (this.vinesGrow && l3 > 0) {
                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(-1, l3, 0))) {
                                    this.addVine(worldIn, position.add(-1, l3, 0), BlockVine.EAST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(1, l3, 0))) {
                                    this.addVine(worldIn, position.add(1, l3, 0), BlockVine.WEST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, l3, -1))) {
                                    this.addVine(worldIn, position.add(0, l3, -1), BlockVine.SOUTH);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.isAirBlock(position.add(0, l3, 1))) {
                                    this.addVine(worldIn, position.add(0, l3, 1), BlockVine.NORTH);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow) {
                        for(l3 = position.getY() - 3 + i; l3 <= position.getY() + i; ++l3) {
                            i4 = l3 - (position.getY() + i);
                            k4 = 2 - i4 / 2;
                            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

                            for(l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4) {
                                for(i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5) {
                                    blockpos$mutableblockpos1.setPos(l4, l3, i5);
                                    state = worldIn.getBlockState(blockpos$mutableblockpos1);
                                    if (state.getBlock().isLeaves(state, worldIn, blockpos$mutableblockpos1)) {
                                        BlockPos blockpos2 = blockpos$mutableblockpos1.west();
                                        blockpos3 = blockpos$mutableblockpos1.east();
                                        BlockPos blockpos4 = blockpos$mutableblockpos1.north();
                                        BlockPos blockpos1 = blockpos$mutableblockpos1.south();
                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos2)) {
                                            this.addHangingVine(worldIn, blockpos2, BlockVine.EAST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos3)) {
                                            this.addHangingVine(worldIn, blockpos3, BlockVine.WEST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos4)) {
                                            this.addHangingVine(worldIn, blockpos4, BlockVine.SOUTH);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos1)) {
                                            this.addHangingVine(worldIn, blockpos1, BlockVine.NORTH);
                                        }
                                    }
                                }
                            }
                        }

                        if (rand.nextInt(5) == 0 && i > 5) {
                            for(l3 = 0; l3 < 2; ++l3) {
                                Iterator var23 = EnumFacing.Plane.HORIZONTAL.iterator();

                                while(var23.hasNext()) {
                                    EnumFacing enumfacing = (EnumFacing)var23.next();
                                    if (rand.nextInt(4 - l3) == 0) {
                                        EnumFacing enumfacing1 = enumfacing.getOpposite();
                                        this.placeCocoa(worldIn, rand.nextInt(3), position.add(enumfacing1.getFrontOffsetX(), i - 5 + l3, enumfacing1.getFrontOffsetZ()), enumfacing);
                                    }
                                }
                            }
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private void placeCocoa(World worldIn, int p_181652_2_, BlockPos pos, EnumFacing side) {
        this.setBlockAndNotifyAdequately(worldIn, pos, Blocks.COCOA.getDefaultState().withProperty(BlockCocoa.AGE, p_181652_2_).withProperty(BlockCocoa.FACING, side));
    }

    private void addVine(World worldIn, BlockPos pos, PropertyBool prop) {
        this.setBlockAndNotifyAdequately(worldIn, pos, Blocks.VINE.getDefaultState().withProperty(prop, true));
    }

    private void addHangingVine(World worldIn, BlockPos pos, PropertyBool prop) {
        this.addVine(worldIn, pos, prop);
        int i = 4;

        for(BlockPos blockpos = pos.down(); worldIn.isAirBlock(blockpos) && i > 0; --i) {
            this.addVine(worldIn, blockpos, prop);
            blockpos = blockpos.down();
        }
    }
/*
    static {
        DEFAULT_TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
        DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, false);
    }*/
}