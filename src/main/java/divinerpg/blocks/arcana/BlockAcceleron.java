package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.world.level.block.HorizontalDirectionalBlock.FACING;
import static net.minecraft.world.level.block.SoundType.METAL;
import static net.minecraft.world.level.material.MapColor.LAPIS;

public class BlockAcceleron extends BlockMod {
    public BlockAcceleron() {
        super(Properties.of().mapColor(LAPIS).requiresCorrectToolForDrops().strength(5, 6).sound(METAL).friction(1.2F));
    }
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public float getFriction(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        return entity != null && entity.isSteppingCarefully() ? 0.1F : super.getFriction(state, level, pos, entity);
    }
}