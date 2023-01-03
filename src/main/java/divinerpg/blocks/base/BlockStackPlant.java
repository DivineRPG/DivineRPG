package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockStackPlant extends BlockModDoubleCrop {
    public BlockStackPlant() {
        super();
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        state = world.getBlockState(pos.below());
        Block block = state.getBlock();
        return block == this || (block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_grass"))
                && Utils.bordersTar(world, pos.getX(), pos.getY() - 1, pos.getZ()));
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.BEACH;
    }

}
