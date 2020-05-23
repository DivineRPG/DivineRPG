package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Supplier;

public class BlockModLeaves extends BlockLeaves implements IShearable {
    private Supplier<Block> saplingSupplier;
    private MapColor mapColor;
    private final int radius;
    private int[][][] surroundings;

    public BlockModLeaves(String name, float hardness, @Nonnull MapColor mapColorIn) {
        this(name, hardness, () -> null, mapColorIn);

    }

    public BlockModLeaves(String name, float hardness, Supplier<Block> saplingSupplier, @Nonnull MapColor mapColorIn) {
        this(name, hardness, saplingSupplier, mapColorIn, 4);
    }

    public BlockModLeaves(String name, float hardness, Supplier<Block> saplingSupplier, @Nonnull MapColor mapColorIn, int radius) {
        super();
        this.radius = radius;
        this.saplingSupplier = () -> null;
        this.setMapColor(mapColorIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(DivineRPG.MODID, name);
        this.setHardness(hardness);
        this.setCreativeTab(DivineRPGTabs.BlocksTab);
        this.setTickRandomly(true);
        this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true).withProperty(DECAYABLE, true));
        this.saplingSupplier = saplingSupplier;

        surroundings = new int[radius * 2 + 1][radius * 2 + 1][radius * 2 + 1];
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.isRemote)
            return;

        if (!state.getValue(CHECK_DECAY))
            return;

        if (!state.getValue(DECAYABLE))
            return;

        // Forge: prevent decaying leaves from updating neighbors and loading unloaded chunks
        if (!worldIn.isAreaLoaded(pos, 1)) return;
        // Forge: extend range to account for neighbor checks in world.markAndNotifyBlock -> world.updateObservingBlocksAt
        if (worldIn.isAreaLoaded(pos, radius + 2)) {
            BlockPos.MutableBlockPos current = new BlockPos.MutableBlockPos();

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        current.setPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

                        int xIndex = x + radius;
                        int yIndex = y + radius;
                        int zIndex = z + radius;

                        IBlockState blockState = worldIn.getBlockState(current);
                        Block block = blockState.getBlock();

                        int index = block.canSustainLeaves(blockState, worldIn, current)
                                ? 0
                                : block.isLeaves(blockState, worldIn, current)
                                ? -2
                                : -1;


                        this.surroundings[xIndex][yIndex][zIndex] = index;
                    }
                }
            }

            for (int i3 = 1; i3 < radius; ++i3) {
                for (int x = 1; x < radius * 2; ++x) {
                    for (int y = 1; y < radius * 2; ++y) {
                        for (int z = 1; z < radius * 2; ++z) {

                            if (this.surroundings[x][y][z] == i3 - 1) {

                                if (this.surroundings[x - 1][y][z] == -2) {
                                    this.surroundings[x - 1][y][z] = i3;
                                }

                                if (this.surroundings[x + 1][y][z] == -2) {
                                    this.surroundings[x + 1][y][z] = i3;
                                }

                                if (this.surroundings[x][y - 1][z] == -2) {
                                    this.surroundings[x][y - 1][z] = i3;
                                }

                                if (this.surroundings[x][y + 1][z] == -2) {
                                    this.surroundings[x][y + 1][z] = i3;
                                }

                                if (this.surroundings[x][y][z + 1] == -2) {
                                    this.surroundings[x][y][z + 1] = i3;
                                }

                                if (this.surroundings[x][y][z - 1] == -2) {
                                    this.surroundings[x][y][z - 1] = i3;
                                }
                            }
                        }
                    }
                }
            }

            if (this.surroundings[radius][radius][radius] >= 0) {
                worldIn.setBlockState(pos, state.withProperty(CHECK_DECAY, false), 4);
            } else {
                this.destroy(worldIn, pos);
            }
        }
    }

    private void destroy(World worldIn, BlockPos pos) {
        this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
        worldIn.setBlockToAir(pos);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        Block sapling = this.saplingSupplier.get();
        return sapling != null ? Item.getItemFromBlock(sapling) : null;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;

        if (!state.getValue(DECAYABLE)) {
            i |= 4;
        }

        if (state.getValue(CHECK_DECAY)) {
            i |= 8;
        }
        return i;
    }

    @Deprecated
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DECAYABLE, (meta & 4) == 0).withProperty(CHECK_DECAY,
                (meta & 8) > 0);
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return BlockPlanks.EnumType.OAK;
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos,
                                            int fortune) {
        return NonNullList.withSize(1, new ItemStack(this, 1, 0));
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        if (Minecraft.isFancyGraphicsEnabled()) {
            return BlockRenderLayer.CUTOUT_MIPPED;
        } else {
            return BlockRenderLayer.SOLID;
        }
    }


    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return Blocks.LEAVES.isOpaqueCube(state);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return Blocks.LEAVES.shouldSideBeRendered(state, world, pos, side);
    }

    /**
     * Defensive helper method used to intercept null map colors.
     * Private access used to force the map color to be included in the constructor.
     *
     * @param mapColorIn the map color to set
     */
    private void setMapColor(MapColor mapColorIn) {
        if (mapColorIn == null) {
            this.mapColor = Material.LEAVES.getMaterialMapColor();
        } else {
            this.mapColor = mapColorIn;
        }
    }

    /**
     * Tells maps to use the map color we set.
     *
     * @param state   the blockstate
     * @param worldIn the world
     * @param pos     the block position
     * @return the map color
     */
    @Deprecated
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        if (this.mapColor == null) {
            return super.getMapColor(state, worldIn, pos);
        }
        return this.mapColor;
    }

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Random rand = world instanceof World ? ((World) world).rand : new Random();
        int chance = this.getSaplingDropChance(state);

        if (fortune > 0) {
            chance -= 2 << fortune;
            if (chance < 10) chance = 10;
        }

        if (rand.nextInt(chance) == 0) {
            ItemStack drop = new ItemStack(getItemDropped(state, rand, fortune), 1, damageDropped(state));
            if (!drop.isEmpty())
                drops.add(drop);
        }

        chance = 200;
        if (fortune > 0) {
            chance -= 10 << fortune;
            if (chance < 40) chance = 40;
        }
        if (this == BlockRegistry.edenLeaves && rand.nextInt(1500) == 0) {
            drops.add(new ItemStack(ItemRegistry.forbiddenFruit));
        }
        this.captureDrops(true);
        if (world instanceof World)
            this.dropApple((World) world, pos, state, chance);
        drops.addAll(this.captureDrops(false));
    }
}