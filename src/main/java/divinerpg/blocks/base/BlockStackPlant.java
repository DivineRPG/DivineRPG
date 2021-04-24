package divinerpg.blocks.base;

import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

public class BlockStackPlant extends BlockModDoubleCrop {
    public BlockStackPlant(String name) {
        super(name);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader world, BlockPos pos) {
        state = world.getBlockState(pos.below());
        Block block = state.getBlock();
        return block == this || (block == BlockRegistry.arcaniteGrass
                && Utils.bordersTar(world, pos.getX(), pos.getY() - 1, pos.getZ()));
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.BEACH;
    }

}
