package divinerpg.blocks.twilight;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class BlockTwilightGrass extends BushBlock implements IPlantable, IForgeShearable {
    private Supplier<Block> grassSupplier;

    public BlockTwilightGrass(Supplier<Block> grassSupplier, MaterialColor colour) {
        super(Block.Properties.of(Material.PLANT, colour).noOcclusion().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XZ).noCollission().randomTicks());
        this.grassSupplier = grassSupplier;
    }

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        Vec3 vector3d = p_220053_1_.getOffset(p_220053_2_, p_220053_3_);
        return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
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