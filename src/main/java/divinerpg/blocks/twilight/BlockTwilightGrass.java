package divinerpg.blocks.twilight;

import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class BlockTwilightGrass extends BushBlock implements IPlantable, IForgeShearable {
    private Supplier<Block> grassSupplier;

    public BlockTwilightGrass(Supplier<Block> grassSupplier, MaterialColor colour) {
        super(Block.Properties.of(Material.PLANT, colour).noOcclusion().instabreak().sound(SoundType.CROP).noCollission().randomTicks());
        this.grassSupplier = grassSupplier;
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
        return !worldIn.getBlockState(pos.below()).isAir() && worldIn.getBlockState(pos.below()).getBlock() != this && soil.getBlock() == grassSupplier.get();
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.PLAINS;
    }
}