package divinerpg.blocks.twilight;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

public class BlockMoonbulb extends BlockModDoubleCrop {
    public BlockMoonbulb() {
        super("moonbulb_plant");
    }
    @Override
    protected IItemProvider getBaseSeedId() {
        return ItemRegistry.moonbulbSeeds;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 2;
    }

    @Override
    public int getMaxAge() {
        return 1;
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.CROP;
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        return this.defaultBlockState();
    }
}