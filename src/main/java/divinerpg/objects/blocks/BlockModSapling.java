package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;
import java.util.function.Supplier;

public class BlockModSapling extends BlockBush implements IGrowable {
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D,
            0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    private Supplier<Block> grassSupplier;
    private Supplier<Block> dirtSupplier;
    private WorldGenerator tree;
    private int xOff, zOff;

    public BlockModSapling(String name, Supplier<Block> grassSupplier, Supplier<Block> dirtSupplier, WorldGenerator tree) {
        this.setUnlocalizedName(name);
        this.setRegistryName(DivineRPG.MODID, name);
        this.grassSupplier = grassSupplier;
        this.dirtSupplier = dirtSupplier;
        this.tree = tree;
        setCreativeTab(DivineRPGTabs.BlocksTab);
        setHardness(0.0F);
        setSoundType(SoundType.PLANT);
    }

    public BlockModSapling(String name, Supplier<Block> grassSupplier, Supplier<Block> dirtSupplier, WorldGenerator tree, int xOff, int zOff) {
        this(name, grassSupplier, dirtSupplier, tree);
        this.xOff = xOff;
        this.zOff = zOff;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
                grow(worldIn, rand, pos, state);
            }
        }
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!TerrainGen.saplingGrowTree(worldIn, rand, pos))
            return;
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
        if (!tree.generate(worldIn, rand, pos.add(xOff, 0, zOff))) {
            worldIn.setBlockState(pos, this.getDefaultState(), 4);
        }
    }

    /**
     * Whether this IGrowable can grow
     */
    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if (state.getValue(STAGE).intValue() == 0) {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        } else {
            generateTree(worldIn, pos, state, rand);
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    /**
     * Convert the BlockState into the correct metadata percantage
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | state.getValue(STAGE).intValue() << 3;
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, STAGE);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return soil.getBlock() == grassSupplier.get() || soil.getBlock() == dirtSupplier.get();
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == grassSupplier.get() || state.getBlock() == dirtSupplier.get();
    }
}