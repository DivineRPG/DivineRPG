package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockStackPlant extends BlockModDoubleCrop {

    public BlockStackPlant() {
        super();
    }

    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        return (levelReader.getRawBrightness(pos, 0) >= 8 || levelReader.canSeeSky(pos)) && levelReader.getBlockState(pos.below()).getBlock() == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_grass")) && Utils.bordersTar(levelReader, pos.getX(), pos.getY() - 1, pos.getZ());
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.BEACH;
    }
}
