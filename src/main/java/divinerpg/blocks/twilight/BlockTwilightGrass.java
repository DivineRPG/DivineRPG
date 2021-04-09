package divinerpg.blocks.twilight;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class BlockTwilightGrass extends BushBlock implements IPlantable, IShearable {
    private Supplier<Block> grassSupplier;

    public BlockTwilightGrass(String name, Supplier<Block> grassSupplier, MaterialColor colour) {
        super(Block.Properties.of(Material.PLANT, colour).instabreak().sound(SoundType.CROP).noCollission().randomTicks());
        setRegistryName(DivineRPG.MODID, name);
        this.grassSupplier = grassSupplier;
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this)
            return defaultBlockState();
        return state;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.below());
        return soil.getBlock() == grassSupplier.get();
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return state.getBlock() == grassSupplier.get();
    }

    @Override
    public void shear(SoundCategory p_230263_1_) {

    }

    @Override
    public boolean readyForShearing() {
        return true;
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.PLAINS;
    }
}