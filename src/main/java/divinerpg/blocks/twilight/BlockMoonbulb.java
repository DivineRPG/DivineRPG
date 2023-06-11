package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModDoubleCrop;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockMoonbulb extends BlockModDoubleCrop {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)
    };

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
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return this.defaultBlockState();
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
    }
}
