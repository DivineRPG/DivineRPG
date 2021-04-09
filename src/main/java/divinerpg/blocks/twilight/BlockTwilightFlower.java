package divinerpg.blocks.twilight;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class BlockTwilightFlower extends BushBlock implements IPlantable {
    private Supplier<Block> grassSupplier;
    private AxisAlignedBB size;

    public BlockTwilightFlower(String name, Supplier<Block> grassSupplier, MaterialColor color) {
        this(name, grassSupplier, 0.4, 1, color);
    }

    public BlockTwilightFlower(String name, Supplier<Block> grassSupplier, double width, double height, MaterialColor color) {
        super(Block.Properties.of(Material.PLANT, color).instabreak().sound(SoundType.CROP).noCollission().randomTicks());
        setRegistryName(DivineRPG.MODID, name);
        this.grassSupplier = grassSupplier;

        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Width or height cannot be less/equals zero!");
        }
        // This is bounding box, 1*1 size
        // Center point (A) is 0.5;0.5
        // We need to find L's and R's points, that's a
        // rectangle with given size
        //////////////////////////
        //  L1----width----R1   //
        //  h                   //
        //  e                   //
        //  i      A            //
        //  g                   //
        //  h                   //
        //  t                   //
        //  L2             R2   //
        //////////////////////////

        double leftCorner = Double.max(0, 0.5 - width / 2);
        double rightCorner = 0.5 + width / 2;

        size = new AxisAlignedBB(leftCorner,
                0,
                leftCorner,
                rightCorner,
                height,
                rightCorner);
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this)
            return defaultBlockState();
        return state;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
        BlockState soil = reader.getBlockState(pos.below());
        return soil.getBlock() == grassSupplier.get();
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return state.getBlock() == grassSupplier.get();
    }



    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        Vector3d vector3d = p_220053_1_.getOffset(p_220053_2_, p_220053_3_);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }

    public AbstractBlock.OffsetType getOffsetType() {
        return AbstractBlock.OffsetType.XZ;
    }

    public Block getGrass(){
        return this.grassSupplier.get();
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.PLAINS;
    }

}
