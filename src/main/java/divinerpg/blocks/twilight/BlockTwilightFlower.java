package divinerpg.blocks.twilight;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.common.*;

import java.util.function.Supplier;

public class BlockTwilightFlower extends BushBlock implements IPlantable {
    private Supplier<Block> grassSupplier;
//    private AABB size;

    public BlockTwilightFlower(Supplier<Block> grassSupplier, MapColor color) {
        this(grassSupplier, 0.4, 1, color);
    }

    public BlockTwilightFlower(Supplier<Block> grassSupplier, double width, double height, MapColor color) {
        super(Block.Properties.of().mapColor(color).instabreak().pushReaction(PushReaction.DESTROY).noOcclusion().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XZ).noCollission().randomTicks());
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

//        double leftCorner = Double.max(0, 0.5 - width / 2);
//        double rightCorner = 0.5 + width / 2;

//        size = new AABB(leftCorner,
//                0,
//                leftCorner,
//                rightCorner,
//                height,
//                rightCorner);
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this)
            return defaultBlockState();
        return state;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos);
        return worldIn.getBlockState(pos.below()).getBlock() != this && soil.getBlock() == grassSupplier.get();
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return state.getBlock() == grassSupplier.get();
    }

    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        Vec3 vector3d = p_220053_1_.getOffset(p_220053_2_, p_220053_3_);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
    }

    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }

    public Block getGrass(){
        return this.grassSupplier.get();
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.PLAINS;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 60;
    }
}
