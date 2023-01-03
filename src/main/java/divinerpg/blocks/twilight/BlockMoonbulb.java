package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModDoubleCrop;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockMoonbulb extends BlockModDoubleCrop {
    public BlockMoonbulb() {
        super();
    }
    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb_seeds"));
    }

    @Override
    public int getMaxAge() {
        return 1;
    }
    @Override
    public IntegerProperty getAgeProperty() {
        return BlockStateProperties.AGE_1;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 2;
    }
    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.CROP;
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return this.defaultBlockState();
    }
}